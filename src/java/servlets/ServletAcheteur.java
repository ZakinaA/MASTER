/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.CategVenteDAO;
import database.LotDAO;
import database.VenteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.CategVente;
import modele.Cheval;
import modele.Vente;
import formulaires.EnchereForm;
import modele.Lot;
import modele.Enchere;

/**
 * 
 * @author DUBOSQ
 */
public class ServletAcheteur extends HttpServlet {

       Connection connection;
    
    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        connection = (Connection) servletContext.getAttribute("connection");
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAcheteur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAcheteur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = request.getRequestURI();
        if (url.equals(request.getContextPath() + "/acheteur/Accueil")) {
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            request.setAttribute("pLesCategVente", lesCategVentes);
                    
            this.getServletContext().getRequestDispatcher("/vues/acheteur/Acheteur.jsp").forward(request, response);
        }
        
        if (url.equals(request.getContextPath() + "/acheteur/ventes")) {
            String codeCat = (String)request.getParameter("categ");
            ArrayList<Vente> lesVentes = VenteDAO.getVentesByCateg(connection, codeCat);
            request.setAttribute("pLesVentes", lesVentes);
            getServletContext().getRequestDispatcher("/vues/acheteur/listerLesVentesParCateg.jsp").forward(request, response);
        }
        
        if (url.equals(request.getContextPath() + "/acheteur/lots")) {
            String idVente = (String)request.getParameter("idVente");
            request.setAttribute("pIdVente", idVente);
            
            ArrayList<Cheval> lesChevaux = VenteDAO.getLesChevaux(connection, idVente);
            request.setAttribute("pLesChevaux", lesChevaux);

            
            getServletContext().getRequestDispatcher("/vues/acheteur/listerLesLots.jsp").forward(request, response);
   
        }
        
        if (url.equals(request.getContextPath() + "/acheteur/ficheCheval")) {
            String idCheval = (String)request.getParameter("idCheval");
            Cheval unCheval = VenteDAO.getInfosCheval(connection, idCheval);
            request.setAttribute("pIdCheval", unCheval);
            
            String idVente = (String)request.getParameter("idVente");
            Vente uneVente = VenteDAO.getUneVente(connection, idVente);
            request.setAttribute("pIdVente", uneVente);
                        
            
            Lot unLot = LotDAO.getLotByIdCheval(connection, idCheval, idVente);
            request.setAttribute("pIdLot", unLot);
            
            int idLot = unLot.getId();
            Enchere uneEnchere = LotDAO.prixActuel(connection, idLot);
            request.setAttribute("pMontantEnchere", uneEnchere);
            
            getServletContext().getRequestDispatcher("/vues/acheteur/ficheCheval.jsp").forward(request, response);
   
        }
        
        if (url.equals(request.getContextPath() + "/acheteur/encherir")){
            
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EnchereForm form = new EnchereForm();
        Enchere uneEnchere = form.ajouterEnchere(request);
        
        request.setAttribute("form", form);
        request.setAttribute("pEnchere", uneEnchere);
		
        if (form.getErreurs().isEmpty()){
            LotDAO.encherirSurUnLot(connection, uneEnchere);
            getServletContext().getRequestDispatcher("/vues/acheteur/enchereRecap.jsp" ).forward( request, response );
        }
        else {
            request.setAttribute("errMessage", "Verifier le montant de l'enchère");
            request.getRequestDispatcher("/vues/connexion/login.jsp").forward(request, response);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

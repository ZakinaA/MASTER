/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.CategVenteDAO;
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

/**
 *
 * @author sio2
 */
public class ServletVendeur extends HttpServlet {
    
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
            out.println("<title>Servlet ServletVendeur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletVendeur at " + request.getContextPath() + "</h1>");
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
        if (url.equals(request.getContextPath() + "/vendeur/Accueil")) {
            ArrayList<CategVente> lesCategVentes = CategVenteDAO.getLesCategVentes(connection);
            request.setAttribute("pLesCategVente", lesCategVentes);
                    
            this.getServletContext().getRequestDispatcher("/vues/vendeur/Vendeur.jsp").forward(request, response);
        }
        
        if (url.equals(request.getContextPath() + "/vendeur/ventes")) {
            String codeCat = (String)request.getParameter("categ");
            ArrayList<Vente> lesVentes = VenteDAO.getVentesByCateg(connection, codeCat);
            request.setAttribute("pLesVentes", lesVentes);
            getServletContext().getRequestDispatcher("/vues/vendeur/listerLesVentesParCateg.jsp").forward(request, response);
        }
        
        if (url.equals(request.getContextPath() + "/vendeur/lots")) {
            String idVente = (String)request.getParameter("idVente");
            ArrayList<Cheval> lesChevaux = VenteDAO.getLesChevaux(connection, idVente);
            request.setAttribute("pLesChevaux", lesChevaux);
            getServletContext().getRequestDispatcher("/vues/vendeur/listerLesLots.jsp").forward(request, response);
   
        }
        
        if (url.equals(request.getContextPath() + "/vendeur/ficheCheval")) {
            String idCheval = (String)request.getParameter("idCheval");
            Cheval unCheval = VenteDAO.getInfosCheval(connection, idCheval);
            //Lot unLot = ;
            request.setAttribute("pIdCheval", unCheval);
            //request.setAttribute("pIdLot", unLot);
            getServletContext().getRequestDispatcher("/vues/vendeur/ficheCheval.jsp").forward(request, response);
   
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
        processRequest(request, response);
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

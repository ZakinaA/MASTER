/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.CategVenteDAO;
import database.LieuDAO;
import database.Utilitaire;
import database.VenteDAO;
import formulaires.CategVenteForm;
import formulaires.LieuForm;
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
import modele.Lieu;
import modele.Vente;

/**
 *
 * @author sio2
 */
public class ServletLieu extends HttpServlet {

    
    
    Connection connection ;
      
        
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
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
            out.println("<title>Servlet ServletLieu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLieu at " + request.getContextPath() + "</h1>");
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
        if(url.equals("/EquidaWeb20/ServletLieu/ajouterLieu"))
        {                   
            this.getServletContext().getRequestDispatcher("/vues/lieu/lieuAjouter.jsp" ).forward( request, response );
        }
        
        if(url.equals("/EquidaWeb20/ServletLieu/listerLesLieux"))
        {  
            ArrayList<Lieu> lesLieux = LieuDAO.getLesLieux(connection);
            request.setAttribute("pLesLieux", lesLieux);
            getServletContext().getRequestDispatcher("/vues/lieu/listerLesLieux.jsp").forward(request, response);
        }
        if(url.equals("/EquidaWeb20/ServletLieu/listerLesLieux?idLieu1="))
        {  
            ArrayList<Lieu> lesLieux = LieuDAO.getLesLieux(connection);
            request.setAttribute("pLesLieux", lesLieux);
            getServletContext().getRequestDispatcher("/vues/lieu/listerLesLieux.jsp").forward(request, response);
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
            /* Préparation de l'objet formulaire */
        LieuForm form = new LieuForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Lieu unLieu = form.ajouterLieu(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pLieu", unLieu );
	System.out.println(form.getErreurs());
        if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
            LieuDAO.ajouterLieu(connection, unLieu);
            this.getServletContext().getRequestDispatcher("/vues/lieu/lieuConsulter.jsp" ).forward( request, response );
        }
        else
        { 
		// il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
           this.getServletContext().getRequestDispatcher("/vues/lieu/lieuAjouter.jsp" ).forward( request, response );
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
public void destroy(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        try
        {
            //fermeture
            System.out.println("Connexion fermée");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        finally
        {
            //Utilitaire.fermerConnexion(rs);
            //Utilitaire.fermerConnexion(requete);
            Utilitaire.fermerConnexion(connection);
        }
    }
}

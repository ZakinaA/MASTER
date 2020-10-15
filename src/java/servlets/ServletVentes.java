/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Utilitaire;
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
import modele.Cheval;
import modele.Client;
import modele.Courriel;
import modele.Participer;
import modele.Vente;
import org.omg.CORBA.SystemException;

/**
 *
 * @author Zakina
 * Classe Servlet permettant d'executer les fonctionnalités relatives aux ventes :
 * Fonctionnalités implémentées :
 *      lister les ventes
 *      lister les clients d'une vente passée en paramètre
 */
public class ServletVentes extends HttpServlet {
    
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
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletVentes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletVentes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        
        String url = request.getRequestURI();
        
        // Récup et affichage par date décroissante de toutes les ventes   
          
        if(url.equals("/MASTER/ServletVentes/listerLesVentes"))
        {  
            ArrayList<Vente> lesVentes = VenteDAO.getLesVentes(connection);
            request.setAttribute("pLesVentes", lesVentes);
            getServletContext().getRequestDispatcher("/vues/ventes/listerLesVentes.jsp").forward(request, response);
        }
        
        // Récup et affichage des clients interessés par une certaine catégorie de ventes
        if(url.equals("/MASTER/ServletVentes/listerLesClients"))
        {  
           System.out.println("DANS LISTER LES CLIENTS");
            String codeCat = (String)request.getParameter("codeCat");
           
            
            ArrayList<Client> lesClients = VenteDAO.getLesClients(connection, codeCat);
            request.setAttribute("pLesClients", lesClients);
            getServletContext().getRequestDispatcher("/vues/ventes/listerLesClients.jsp").forward(request, response);
        }
        
        // Récup et affichage des mails concernés par une catégorie de vente
        if(url.equals("/MASTER/ServletVentes/listerLesCourriels"))
        {  
            
            System.out.println("Dans lister les mails");
            String idVente = (String)request.getParameter("idVente");

            ArrayList<Courriel> lesCourriels = VenteDAO.getLesCourriels(connection, idVente);
            request.setAttribute("pLesCourriels", lesCourriels);
            getServletContext().getRequestDispatcher("/vues/ventes/listerLesCourriels.jsp").forward(request, response);
           
        }
        
        if(url.equals("/MASTER/ServletVentes/listerLesChevaux"))
        {  
            
            System.out.println("Dans lister les chevaux");
            String idVente = (String)request.getParameter("idVente");

            ArrayList<Cheval> lesChevaux = VenteDAO.getLesChevaux(connection, idVente);
            System.out.println("NB chevaux" +lesChevaux.size());
            request.setAttribute("pLesChevaux", lesChevaux);
            getServletContext().getRequestDispatcher("/vues/ventes/listerLesChevaux.jsp").forward(request, response);
           
        }
        
        if(url.equals("/MASTER/ServletVentes/listerInfosCheval"))
        {  
            
            System.out.println("Dans lister les chevaux");
            String idCheval = (String)request.getParameter("idCheval");

            Cheval unCheval = VenteDAO.getInfosCheval(connection, idCheval);
            System.out.println("Cheval:" + unCheval.getId());
            System.out.println("NB chevaux" +unCheval.getNom());
            request.setAttribute("pIdCheval", unCheval);
            getServletContext().getRequestDispatcher("/vues/ventes/listerInfosCheval.jsp").forward(request, response);
           
        } 
        
        if(url.equals("/MASTER/ServletVentes/listerCourseCheval"))
        {  
            
            System.out.println("Dans lister les courses");
            String idCheval = (String)request.getParameter("idCheval");

            ArrayList<Participer> lesParticipations = VenteDAO.getLesCourses(connection, idCheval);
            request.setAttribute("pIdCheval", lesParticipations);
            getServletContext().getRequestDispatcher("/vues/ventes/listerCourseCheval.jsp").forward(request, response);
           
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
    }
    
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

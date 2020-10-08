/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Utilisateur;

/**
 *
 * @author noedu
 */
public class ServletConnexion extends HttpServlet {

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
            out.println("<title>Servlet ServletConnexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConnexion at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String username = request.getParameter("username");
        String passsword = request.getParameter("password");

        Utilisateur unUtilisateur = new Utilisateur();

        unUtilisateur.setUsername(username);
        unUtilisateur.setPassword(passsword);

        UserDAO unUserDAO = new UserDAO();

        try {
            String userRole = unUserDAO.authentification(connection, unUtilisateur);

            if (userRole.equals("admin")) {
                System.out.println("admin");
                HttpSession session = request.getSession(); //création de la session
                session.setAttribute("admin", username); //attribution du role admin pour la session
                session.setAttribute("role", username);
                request.setAttribute("username", username);
                request.getRequestDispatcher("/vues/admin/Admin.jsp").forward(request, response);
            } else if (userRole.equals("employee")) {
                System.out.println("employee");
                HttpSession session = request.getSession(); //création de la session
                session.setAttribute("employee", username); //attribution du role employee pour la session
                request.setAttribute("username", username);
                request.getRequestDispatcher("/vues/admin/Employee.jsp").forward(request, response);
            } else if (userRole.equals("acheteur")) {
                System.out.println("acheteur");
                HttpSession session = request.getSession(); //création de la session
                session.setAttribute("acheteur", username); //attribution du role acheteur pour la session
                request.setAttribute("username", username);
                request.getRequestDispatcher("/vues/admin/Acheteur.jsp").forward(request, response);
            } else if (userRole.equals("vendeur")) {
                System.out.println("vendeur");
                HttpSession session = request.getSession(); //création de la session
                session.setAttribute("vendeur", username); //attribution du role vendeur pour la session
                request.setAttribute("username", username);
                request.getRequestDispatcher("/vues/admin/Vendeur.jsp").forward(request, response);
            } else {
                System.out.println("Erreur! <" + userRole + ">");
                request.setAttribute("errMessage", userRole);

                request.getRequestDispatcher("/vues/connexion/login.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
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

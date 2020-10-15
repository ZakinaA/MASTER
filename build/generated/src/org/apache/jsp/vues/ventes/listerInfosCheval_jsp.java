package org.apache.jsp.vues.ventes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modele.Cheval;
import java.util.ArrayList;

public final class listerInfosCheval_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <title>LISTE DES INFOS DU CHEVAL</title>\r\n");
      out.write("        <!-- NAVBAR -->\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"/MASTER\">\r\n");
      out.write("                <img src=\"vues/Images/black-head-horse-side-view-with-horsehair.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\"  alt=\"\" loading=\"lazy\">\r\n");
      out.write("                Master\r\n");
      out.write("            </a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                    <li class=\"nav-item active\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"/MASTER\">Accueil <span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <!-- Item à ajouter\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                      <a class=\"nav-link\" href=\"#\">Items</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    -->\r\n");
      out.write("                    <li class=\"nav-item dropdown\">\r\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                            Servlet (dev)\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"/MASTER/ServletVentes/listerLesVentes\">Lister les ventes</a>\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"/MASTER/ServletClient/ajouterClient\">Ajouter un client</a>\r\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"/MASTER/ServletCheval/ajouterCheval\">Ajouter Cheval</a>\r\n");
      out.write("                            <a class=\"dropdown-item\" href=\"/MASTER/ServletCheval/listerCheval\">Lister les chevaux</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <a href=\"/MASTER/login\" class=\"text-dark px-3 text-decoration-none\" type=\"submit\">Se connecter</a>\r\n");
      out.write("                <a class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">S'inscrire</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!-- FIN DE LA NAVBAR -->\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("    <div class=\"container-lg\">\r\n");
      out.write("        \r\n");
      out.write("         ");

        Cheval unCheval = (Cheval)request.getAttribute("pIdCheval");
        
      out.write("\r\n");
      out.write("        <h1>LISTE DES INFOS DU CHEVAL ");
 out.print("N° " + unCheval.getId()); 
      out.write(" </h1>\r\n");
      out.write("        <table class=\"table table-hover table-striped shadow-lg p-3 mb-5 bg-white rounded\">\r\n");
      out.write("            <thead>\r\n");
      out.write("              <tr>\r\n");
      out.write("                    <th>NOM</th>\r\n");
      out.write("                    <th>SEXE</th>\r\n");
      out.write("                    <th>PRIX</th>\r\n");
      out.write("                    <th>SIRE</th>\r\n");
      out.write("                    <th>PHOTO</th>\r\n");
      out.write("                    <th>VENDEUR</th>\r\n");
      out.write("                    <th>RACE</th>\r\n");
      out.write("                    <th>PERE</th>\r\n");
      out.write("                    <th>MERE</th>\r\n");
      out.write("\r\n");
      out.write("              </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    ");

                    
                        out.println("<td class='align-middle'> ");
                        out.println(unCheval.getNom());
                        out.println("</td class='align-middle'>");
                        
                        out.println("<td class='align-middle'> ");
                        out.println(unCheval.getSexe());
                        out.println("</td>");
                        
                        out.println("<td class='align-middle'> ");
                        out.println(unCheval.getPrixDepart());
                        out.println("</td>");
                        
                        out.println("<td class='align-middle'> ");
                        out.println(unCheval.getSIRE());
                        out.println("</td>");
                        
                        out.println("<td class='align-middle'> ");
                        out.println("<img src='../vues/Images/"+ unCheval.getImg_url() +"' width='100' height='100'>");
                        out.println("</td>");
                        
                        out.println("<td> ");
                        out.println(unCheval.getUnClient().getNom());
                        out.println("</td>");
                        
                        out.println("<td> ");
                        out.println(unCheval.getLeTypeDeCheval().getLibelle());
                        out.println("</td>");
                        
                        out.println("<td> ");
                        out.println(unCheval.getPere().getNom());
                        out.println("</td>");
                        
                        out.println("<td> ");
                        out.println(unCheval.getMere().getNom());
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVentes/listerCourseCheval?idCheval="+ unCheval.getId()+"'>");
                        out.println("Lister les courses");
                        out.println("</td>");
                        

                        

                    
                    
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Optional JavaScript -->\r\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp.vues.ventes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modele.Participer;
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
      out.write("                <img src=\"../vues/Images/black-head-horse-side-view-with-horsehair.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\"  alt=\"\" loading=\"lazy\">\r\n");
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
      out.write("         ");

        Cheval unCheval = (Cheval)request.getAttribute("pIdCheval");
        
      out.write("\r\n");
      out.write("        <h1>LISTE DES INFOS DU CHEVAL ");
 out.print("N° " + unCheval.getId()); 
      out.write(" </h1>\r\n");
      out.write("            <div class=\"card mb-3\" style=\"max-width: 1110px;\">\r\n");
      out.write("                <div class=\"row no-gutters\">\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                    ");

                        out.println("<img src='"+ unCheval.getImg_url() +"' alt='...' class='card-img'>");
                    
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-8\">\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <table class=\"table table-borderless\">\r\n");
      out.write("                            <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Nom</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                   out.println("<td class='align-middle'> ");
                                   out.println(unCheval.getNom());
                                   out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Sexe</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                    out.println("<td class='align-middle'> ");
                                    out.println(unCheval.getSexe());
                                    out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Prix</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                   out.println("<td class='align-middle'> ");
                                   out.println(unCheval.getPrixDepart());
                                   out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Race</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                    out.println("<td class='align-middle'> ");
                                    out.println(unCheval.getLeTypeDeCheval().getLibelle());
                                    out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th><h5 class=\"card-title\">SIRE</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                   out.println("<td class='align-middle'> ");
                                   out.println(unCheval.getSIRE());
                                   out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Vendeur</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                    out.println("<td class='align-middle'> ");
                                    out.println(unCheval.getUnClient().getNom());
                                    out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Père</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                    if (unCheval.getPere().getId() != 5) {
                                    out.println("<td class='align-middle'> <a href ='../ServletVentes/listerInfosCheval?idCheval="+ unCheval.getPere().getId()+"'>");
                                    out.println(unCheval.getPere().getNom());
                                    out.println("</td class='align-middle'>");
                                    }else{
                                    out.println("<td class='align-middle'>");
                                    out.println(unCheval.getPere().getNom());
                                    out.println("</td class='align-middle'>");
                                    }
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Mère</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                    if (unCheval.getMere().getId() != 5) {
                                    out.println("<td class='align-middle'><a href ='../ServletVentes/listerInfosCheval?idCheval="+ unCheval.getMere().getId()+"'>");
                                    out.println(unCheval.getMere().getNom());
                                    out.println("</td class='align-middle'>");
                                    }else{
                                    out.println("<td class='align-middle'>");
                                    out.println(unCheval.getPere().getNom());
                                    out.println("</td class='align-middle'>");
                                    }
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Entraineur</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                   out.println("<td class='align-middle'> ");
                                   out.println(unCheval.getUnEntraineur().getNom());
                                   out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Liste des courses</h5></th>\r\n");
      out.write("                                <td><p class=\"card-text\">\r\n");
      out.write("                                    ");

                                    out.println("<td class='align-middle'><a href ='../ServletVentes/listerCourseCheval?idCheval="+ unCheval.getId()+"'>");
                                    out.println("<svg class='card-title' width='1em' height='1em' viewBox='0 0 16 16' class='bi bi-flag' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>"
                                            + "<path fill-rule='evenodd' d='M14.778.085A.5.5 0 0 1 15 .5V8a.5.5 0 0 1-.314.464L14.5 8l.186.464-.003.001-.006.003-.023.009a12.435 12.435 0 0 1-.397.15c-.264.095-.631.223-1.047.35-.816.252-1.879.523-2.71.523-.847 0-1.548-.28-2.158-.525l-.028-.01C7.68 8.71 7.14 8.5 6.5 8.5c-.7 0-1.638.23-2.437.477A19.626 19.626 0 0 0 3 9.342V15.5a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 1 0v.282c.226-.079.496-.17.79-.26C4.606.272 5.67 0 6.5 0c.84 0 1.524.277 2.121.519l.043.018C9.286.788 9.828 1 10.5 1c.7 0 1.638-.23 2.437-.477a19.587 19.587 0 0 0 1.349-.476l.019-.007.004-.002h.001M14 1.221c-.22.078-.48.167-.766.255-.81.252-1.872.523-2.734.523-.886 0-1.592-.286-2.203-.534l-.008-.003C7.662 1.21 7.139 1 6.5 1c-.669 0-1.606.229-2.415.478A21.294 21.294 0 0 0 3 1.845v6.433c.22-.078.48-.167.766-.255C4.576 7.77 5.638 7.5 6.5 7.5c.847 0 1.548.28 2.158.525l.028.01C9.32 8.29 9.86 8.5 10.5 8.5c.668 0 1.606-.229 2.415-.478A21.317 21.317 0 0 0 14 7.655V1.222z'/>"
                                            + "</svg>");
                                    out.println("</td class='align-middle'>");
                                    
      out.write("\r\n");
      out.write("                                    </p></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                <th><h5 class=\"card-title\">Description </h5></th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <p class=\"card-text\">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>\r\n");
      out.write("                            <p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
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

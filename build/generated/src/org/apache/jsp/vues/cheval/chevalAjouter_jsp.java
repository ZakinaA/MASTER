package org.apache.jsp.vues.cheval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modele.TypeCheval;
import modele.Client;
import modele.CategVente;
import java.util.ArrayList;
import modele.Pays;
import formulaires.ClientForm;

public final class chevalAjouter_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Client Ajouter</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         ");

                //Client client=(Client)request.getAttribute("client");
                ClientForm form = (ClientForm)request.getAttribute("form");
            
      out.write("\n");
      out.write("        <div class=\"container-lg\">\n");
      out.write("            <h1 class=\"display-3\">NOUVEAU CHEVAL</h1>\n");
      out.write("        <form action=\"ajouterCheval\" method=\"POST\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"nom\">Nom : </label>\n");
      out.write("                <input class=\"form-control\" id=\"nom\" type=\"text\" name=\"nom\"  size=\"30\" maxlength=\"30\" >\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"sexe\">Sexe : </label>\n");
      out.write("                <input class=\"form-control\" id=\"sexe\"  type=\"text\"  name=\"sexe\" size=\"30\" maxlength=\"30\">      \n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"prixDepart\">Prix Départ : </label>\n");
      out.write("                <input class=\"form-control\" id=\"prixDepart\"  type=\"text\"  name=\"prixDepart\" size=\"30\" maxlength=\"50\">\n");
      out.write("            </div>\n");
      out.write("                               \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"sire\">SIRE : </label>\n");
      out.write("                <input class=\"form-control\" id=\"sire\"  type=\"text\"  name=\"sire\" size=\"5\" maxlength=\"5\">\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("            <div class=\"form-group\">    \n");
      out.write("                ");
      out.write("\n");
      out.write("                <label for=\"client\">Client : </label>\n");
      out.write("                <select class=\"form-control\" id=\"id_client\" name =\"client\">\n");
      out.write("                    ");

                        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClients");
                        for (int i=0; i < lesClients.size(); i++){
                            Client c = lesClients.get(i);
                            out.println("<option value='" + c.getId()+"'>" + c.getNom()+"</option>" );
                        } 
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("            </div>          \n");
      out.write("                \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"typeCheval\">Type Cheval : </label>\n");
      out.write("                <select class=\"form-control\" name=\"typeCheval\">\n");
      out.write("                ");

                        ArrayList<TypeCheval> lesTypesDeChevaux = (ArrayList)request.getAttribute("pLesTypesDeChevaux");
                        for (int i=0; i<lesTypesDeChevaux.size();i++){
                            TypeCheval tc = lesTypesDeChevaux.get(i);
                            out.println("<option value ='" + tc.getId() + "'>" + tc.getLibelle() + "</option>"); 
                           
                        }
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("            </div>     \n");
      out.write("                 \n");
      out.write("                \n");
      out.write("                    <button class=\"btn btn-outline-success\" type=\"submit\" name=\"valider\" id=\"valider\" value=\"Valider\">Valider</button> <br>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("              <!-- Optional JavaScript -->\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

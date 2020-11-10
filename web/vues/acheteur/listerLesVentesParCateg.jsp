<%-- 
    Document   : listerLesVentesParCateg
    Created on : 27 oct. 2020, 03:57:42
    Author     : noedu
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Vente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">


        <title>LISTE DES VENTES</title>
    </head>
    <body>
        <!-- NAVBAR -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="#">
                <img src="../vues/Images/black-head-horse-side-view-with-horsehair.png" width="30" height="30" class="d-inline-block align-top"  alt="" loading="lazy">
                Master
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/EquidaWeb20/admin/Accueil">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <a href="<%=request.getContextPath()%>/_deconnexion" class="text-dark px-3 text-decoration-none" type="submit">Se deconnecter</a>
            </div>
        </nav>

        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4"><% out.println("Bienvenue, " + session.getAttribute("acheteur") + "."); %></h1>
            </div>
        </div> 
            

        <div class="container-lg">
            <h1>LISTE DES VENTES</h1>
            <%
                ArrayList<Vente> lesVentes = (ArrayList) request.getAttribute("pLesVentes");
            %>
            <table class="table table-hover table-striped shadow-lg p-3 mb-5 bg-white rounded">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOM</th>
                        <th>DATE DEBUT</th>
                        <th>CATEGORIE</th>
                        <th>VILLE</th>
                        <th>Boxes</th>  
                        <th>LOTS</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <%
                            for (int i = 0; i < lesVentes.size(); i++) {

                                Vente uneVente = lesVentes.get(i);
                                out.println("<tr>");
                                out.println("<th scope='row'>");
                                out.println(uneVente.getId());
                                out.println("</th>");

                                out.println("<td> ");
                                out.println(uneVente.getNom());
                                out.println("</td>");

                                out.println("<td> ");
                                out.println(uneVente.getDateDebutVente());
                                out.println("</td>");

                                out.println("<td> ");
                                out.println(uneVente.getUneCategVente().getLibelle());
                                out.println("</td>");

                                out.println("<td> ");
                                out.println(uneVente.getUnLieu().getVille());
                                out.println("</td>");

                                out.println("<td> ");
                                out.println(uneVente.getUnLieu().getNbBoxes());
                                out.println("</td>");

                                out.println("<td><a href ='../acheteur/lots?idVente=" + uneVente.getId() + "'>");
                                out.println("Lister les lots");
                                out.println("</td>");

                            }
                        %>
                    </tr>
                </tbody>
            </table>

        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
    <div class="container p-5">
        <hr class="featurette-divider p-5">
        <footer>
            <p class="float-right">
                Pablo, Melvyn, Noé.
            </p>
            <p>
                2020 · SIO2 · Lycée Jean Rostand
            </p>
        </footer>
    </div>
</html>

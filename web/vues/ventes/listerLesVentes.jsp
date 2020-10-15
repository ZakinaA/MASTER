<%-- 
    Document   : Lister les Ventes 
    Created on : 22/06/2017, 07:43
    Author     : Zakina
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
        <!-- NAVBAR -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="/MASTER">
                <img src="../Images/black-head-horse-side-view-with-horsehair.png" width="30" height="30" class="d-inline-block align-top"  alt="" loading="lazy">
                Master
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/MASTER">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                    <!-- Item à ajouter
                    <li class="nav-item">
                      <a class="nav-link" href="#">Items</a>
                    </li>
                    -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Servlet (dev)
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/MASTER/ServletVentes/listerLesVentes">Lister les ventes</a>
                            <a class="dropdown-item" href="/MASTER/ServletClient/ajouterClient">Ajouter un client</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/MASTER/ServletCheval/ajouterCheval">Ajouter Cheval</a>
                            <a class="dropdown-item" href="/MASTER/ServletCheval/listerCheval">Lister les chevaux</a>
                        </div>
                    </li>
                </ul>
                <a href="/MASTER/login" class="text-dark px-3 text-decoration-none" type="submit">Se connecter</a>
                <a class="btn btn-outline-success my-2 my-sm-0" type="submit">S'inscrire</a>
            </div>
        </nav>
        <!-- FIN DE LA NAVBAR -->
    </head>
    <body>
     <div class="container-lg">
            <h1>LISTE DES VENTES</h1>
            <%
                ArrayList<Vente> lesVentes = (ArrayList) request.getAttribute("pLesVentes");
            %>
            <table class="table table-hover table-striped shadow-lg p-3 mb-5 bg-white rounded" style=" height:500px; width: 1000px; overflow:auto;">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOM</th>
                        <th>DATE DEBUT</th>
                        <th>CATEGORIE</th>
                        <th>VILLE</th>
                        <th>Boxes</th>  
                        <th>CLIENTS</th>
                        <th>MAILS</th>
                        <th>CHEVAUX</th>
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

                                out.println("<td><a href ='../ServletVentes/listerLesClients?codeCat=" + uneVente.getUneCategVente().getCode() + "'>");
                                out.println("Lister les clients interessés");
                                out.println("</td>");

                                out.println("<td><a href ='../ServletVentes/listerLesCourriels?idVente=" + uneVente.getId() + "'>");
                                out.println("Lister les mails concernés");
                                out.println("</td>");

                                out.println("<td><a href ='../ServletVentes/listerLesChevaux?idVente=" + uneVente.getId() + "'>");
                                out.println("Lister les chevaux en vente");
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
</html>

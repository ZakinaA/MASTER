<%-- 
    Document   : listerLesLots
    Created on : 27 oct. 2020, 04:33:13
    Author     : noedu
--%>

<%@page import="modele.Cheval"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Equida - Accueil</title>
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
                        <a class="nav-link" href="/MASTER/admin/Accueil">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                    <!-- Item à ajouter
                    <li class="nav-item">
                      <a class="nav-link" href="#">Items</a>
                    </li>
                    -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Outils
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
                <a href="#" class="text-info px-3 text-decoration-none">Profil</a>
                <a href="<%=request.getContextPath()%>/_deconnexion" class="text-danger px-3 text-decoration-none" type="submit">Se deconnecter</a>
            </div>
        </nav>
        <!-- FIN DE LA NAVBAR -->

            
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4"><% out.println("Bienvenue, " + session.getAttribute("admin") + "."); %></h1>
                    <p class="lead"><% out.println("Role: " + session.getAttribute("role") + "."); %></p>
                </div>
            </div> 
        
        <%ArrayList<Cheval> lesChevaux = (ArrayList) request.getAttribute("pLesChevaux");%>
        
        <div class="container">
            <div class="row row-cols-md-1">
                <div class="card-deck">
            <% for (int i = 0; i < lesChevaux.size(); i++) {
                Cheval unCheval = lesChevaux.get(i);
                out.println("<div class='col mb-3'>");
                out.println("<div class='card' style='width: 18rem; '>"); //
                out.println("   <img src='../vues/Images/"+ unCheval.getImg_url() +"' class='card-img-top' alt='#' style='height: 10rem;'>");
                //out.println("   <img src='../vues/Images/ete.jpg' class='card-img-top' alt='...'>"); //
                out.println("   <div class='card-body'>");
                out.println("    <h5 class='card-title'>"+ unCheval.getNom() +"</h5>");
                out.println("    <p class='card-text'> Vendeur: "+ unCheval.getUnClient().getNom() +"</p>");
                out.println("    <p class='card-text'> Race: "+ unCheval.getLeTypeDeCheval().getLibelle() +"</p>");
                out.println("    <a href='/MASTER/admin/ficheCheval?idCheval="+ unCheval.getId() +"' class='btn btn-primary'>Plus d'informations</a>");
                out.println("   </div>");
                out.println("</div>");
                out.println("</div>");
                             
                

            }
            %>
            </div>
            </div>
        </div>

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

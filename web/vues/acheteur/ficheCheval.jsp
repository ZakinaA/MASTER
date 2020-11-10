<%-- 
    Document   : ficheCheval
    Created on : 27 oct. 2020, 04:33:13
    Author     : noedu
--%>

<%@page import="modele.Enchere"%>
<%@page import="modele.Lot"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.Clock"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="modele.Vente"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
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
                        <a class="nav-link" href="/EquidaWeb20/acheteur/Accueil">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <a href="#" class="text-info px-3 text-decoration-none">Profil</a>
                <a href="<%=request.getContextPath()%>/_deconnexion" class="text-danger px-3 text-decoration-none" type="submit">Se deconnecter</a>
            </div>
        </nav>
        <!-- FIN DE LA NAVBAR -->

        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4"><% out.println("Bienvenue, " + session.getAttribute("acheteur") + "."); %></h1>
            </div>
        </div> 

    </head>
    <body>
        
        <div class="container-lg">
            <%
                Cheval unCheval = (Cheval) request.getAttribute("pIdCheval");
                Vente uneVente = (Vente) request.getAttribute("pIdVente");
                Lot unLot = (Lot) request.getAttribute("pIdLot");
                Enchere uneEnchere = (Enchere) request.getAttribute("pMontantEnchere");
            
            %>
            <form action="<%=request.getContextPath()%>/acheteur/encherir" method="post">
            <div class="card mb-3" style="max-width: 1110px;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <%
                            out.println("<img src='../vues/Images/" + unCheval.getImg_url() + "' alt='...' class='card-img'>");
                        %>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <table class="table table-borderless">
                                <thead>
                                    <span class='badge badge-danger float-right'> Prix actuel : <% out.println(uneEnchere.getMontant()); %> €</span> 
                                    <tr>
                                        <th><h5 class="card-title">Nom</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'>"+ unCheval.getNom() +"</td>");
                                                %>
                                            </p></td>
                                        <th><h5 class="card-title">Sexe</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'>"+ unCheval.getSexe() +"</td>");
                                                %>
                                            </p></td>
                                    </tr>
                                    <tr>
                                        <th><h5 class="card-title">Prix de départ</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'>"+ unLot.getPrixDepart() +"€</td>");
                                                %>
                                            </p></td>
                                        <th><h5 class="card-title">Race</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'>"+ unCheval.getLeTypeDeCheval().getLibelle() +"</td>");
                                                %>
                                            </p></td>
                                    </tr>
                                    <tr>
                                        <th><h5 class="card-title">SIRE</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'>"+ unCheval.getSIRE() +"</td>");
                                                %>
                                            </p></td>
                                        <th><h5 class="card-title">Vendeur</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'>"+ unCheval.getUnClient().getNom() +"</td>");
                                                %>
                                            </p></td>
                                    </tr>
                                    <tr>
                                        <th><h5 class="card-title">Père</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    if (unCheval.getPere().getId() != 5) {
                                                        out.println("<td class='align-middle'>"+ unCheval.getPere().getNom() +"</td>");
                                                    } else {
                                                        out.println("<td class='align-middle'>"+ unCheval.getPere().getNom() +"</td>");
                                                    }
                                                %>
                                            </p></td>
                                        <th><h5 class="card-title">Mère</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    if (unCheval.getMere().getId() != 5) {
                                                        out.println("<td class='align-middle'>"+ unCheval.getMere().getNom() +"</td>");
                                                    } else {
                                                        out.println("<td class='align-middle'>"+ unCheval.getPere().getNom() +"</td>");
                                                    }
                                                %>
                                            </p></td>
                                    </tr>
                                    <tr>
                                        <th><h5 class="card-title">Entraineur</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'> ");
                                                    //out.println(unCheval.getUnEntraineur().getNom());
                                                    out.println("</td class='align-middle'>");
                                                %>
                                            </p></td>
                                        <th><h5 class="card-title">Liste des courses</h5></th>
                                        <td><p class="card-text">
                                                <%
                                                    out.println("<td class='align-middle'><a href ='../ServletVentes/listerCourseCheval?idCheval=" + unCheval.getId() + "'>");
                                                    out.println("<svg class='card-title' width='1em' height='1em' viewBox='0 0 16 16' class='bi bi-flag' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>"
                                                            + "<path fill-rule='evenodd' d='M14.778.085A.5.5 0 0 1 15 .5V8a.5.5 0 0 1-.314.464L14.5 8l.186.464-.003.001-.006.003-.023.009a12.435 12.435 0 0 1-.397.15c-.264.095-.631.223-1.047.35-.816.252-1.879.523-2.71.523-.847 0-1.548-.28-2.158-.525l-.028-.01C7.68 8.71 7.14 8.5 6.5 8.5c-.7 0-1.638.23-2.437.477A19.626 19.626 0 0 0 3 9.342V15.5a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 1 0v.282c.226-.079.496-.17.79-.26C4.606.272 5.67 0 6.5 0c.84 0 1.524.277 2.121.519l.043.018C9.286.788 9.828 1 10.5 1c.7 0 1.638-.23 2.437-.477a19.587 19.587 0 0 0 1.349-.476l.019-.007.004-.002h.001M14 1.221c-.22.078-.48.167-.766.255-.81.252-1.872.523-2.734.523-.886 0-1.592-.286-2.203-.534l-.008-.003C7.662 1.21 7.139 1 6.5 1c-.669 0-1.606.229-2.415.478A21.294 21.294 0 0 0 3 1.845v6.433c.22-.078.48-.167.766-.255C4.576 7.77 5.638 7.5 6.5 7.5c.847 0 1.548.28 2.158.525l.028.01C9.32 8.29 9.86 8.5 10.5 8.5c.668 0 1.606-.229 2.415-.478A21.317 21.317 0 0 0 14 7.655V1.222z'/>"
                                                            + "</svg>");
                                                    out.println("</td class='align-middle'>");
                                                %>
                                            </p></td>
                                    </tr>
                                </thead>
                            </table>
                           <div class="row">
                               <div class="col-sm-4">
                                   <div class="input-group mb-3">
                                       <div class="input-group-prepend">
                                           <% 
                                               if(uneVente.getTempsRestant(uneVente.getHeureVente()).equals("0")){
                                                   System.out.println("Plus de temps vente !");
                                                   out.println("</div>");
                                               } 
                                               else {
                                                   out.println("<button class='btn btn-outline-success' type='submit' id='encherir' >Enchérir</button>");
                                                   out.println("</div>");
                                                   out.println("<input name='montant' type='text' maxlength='6' class='form-control' placeholder='Montant' required>");
                                               }
                                           %>
                                       <input name = "idLot" type="hidden" value="<% out.println(unLot.getId()); %>">
                                   </div>
                               </div>
                               <div class="col-sm-1"></div>
                                <div class="col-sm-7">
                                    <div class="alert alert-warning float-right" role="alert">
                                        <h5 id="countdown"></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
                          
    </div>
    <!-- Optional JavaScript -->
    
    <!-- Script pour concatenner le temps en secondes, puis le remettre en J/H/M/S -->
    <% System.out.println("Restant:" + uneVente.getTempsRestant(uneVente.getHeureVente())); %>
        <script>
        var upgradeTime = <% out.println(uneVente.getTempsRestant(uneVente.getHeureVente())); %>
        var seconds = upgradeTime;
        function timer() {
          var days        = Math.floor(seconds/24/60/60);
          var hoursLeft   = Math.floor((seconds) - (days*86400));
          var hours       = Math.floor(hoursLeft/3600);
          var minutesLeft = Math.floor((hoursLeft) - (hours*3600));
          var minutes     = Math.floor(minutesLeft/60);
          var remainingSeconds = seconds % 60;
          function pad(n) {
            return (n < 10 ? "0" + n : n);
          }
          
            document.getElementById('countdown').innerHTML = pad(days) + ":" + pad(hours) + ":" + pad(minutes) + ":" + pad(remainingSeconds);
              seconds--;
          }
        if (seconds > 0){
            var countdownTimer = setInterval('timer()', 1000);
        }
        else{
            document.getElementById('countdown').innerHTML = "Cette vente est terminée !";
        }
        </script>
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
<%-- 
    Document   : ClientAjouter
    Created on : 22/06, 16:35:27
    Author     : Zakina
--%>

<%@page import="modele.CategVente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Pays"%>
<%@page import="formulaires.ClientForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Client Ajouter</title>
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
                        <a class="nav-link" href="/MASTER">Accueil <span class="sr-only">(current)</span></a>
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
                <a href="<%=request.getContextPath()%>/_deconnexion" class="text-dark px-3 text-decoration-none" type="submit">Se deconnecter</a>
            </div>
        </nav>

        
         <%
                //Client client=(Client)request.getAttribute("client");
                ClientForm form = (ClientForm)request.getAttribute("form");
            %>
        <div class="container-md">
            <h1 class="display-3">NOUVEAU CLIENT</h1>
        <form action="ajouterClient" method="POST">
            <div class="form-group">
                <label for="nom">Nom : </label>
                <input class="form-control" id="nom" type="text" name="nom"  size="30" maxlength="30" required>
            </div>
                
            <div class="form-group">
                <label for="prenom">Prénom : </label>
                <input class="form-control" id="prenom"  type="text"  name="prenom" size="30" maxlength="30" required>      
            </div>
              
            <div class="form-group">
                <label for="rue">Rue : </label>
                <input class="form-control" id="rue"  type="text"  name="rue" size="30" maxlength="50" required>
            </div>
                               
            <div class="form-group">
                <label for="copos">Code postal : </label>
                <input class="form-control" id="copos"  type="text"  name="copos" size="5" maxlength="5" required>
            </div>
                
            <div class="form-group">    
                <label for="ville">Ville : </label>
                <input class="form-control" id="ville"  type="text"  name="ville" size="40" maxlength="40" required>
            </div>
                
            <div class="form-group">    
                <label for="mail">Mail : </label>
                <input class="form-control" id="mail"  type="email"  name="mail" size="60" maxlength="60" required>
            </div>
                
            <div class="form-group">    
                <%-- Champ Liste des pays --%>
                <label for="pays">Pays : </label>
                <select class="form-control" id="codePays" name ="pays">
                    <%
                        ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pLesPays");
                        for (int i=0; i<lesPays.size();i++){
                            Pays p = lesPays.get(i);
                            out.println("<option value='" + p.getCode()+"'>" + p.getNom()+"</option>" );
                        } 
                    %>
                </select>
            </div>          
                
            <div class="form-group">
                <label for="categVente">Catégorie Vente : </label>
                <select class="form-control" name="categVente">
                <%
                        ArrayList<CategVente> lesCategVente = (ArrayList)request.getAttribute("pLesCategVente");
                        for (int i=0; i<lesCategVente.size();i++){
                            CategVente cv = lesCategVente.get(i);
                            out.println("<option value ='" + cv.getCode() + "'>" + cv.getLibelle() + "</option>"); 
                           
                        }
                    %>
                </select>
            </div>     
                
                
                <%-- Cases à cocher permettant de choisir les différentes catégories de vente auxquelles le client souhaite s'inscrire 
                <label for="categVente">Categories de vente : </label></br>
                 <%
                        ArrayList<CategVente> lesCategVente = (ArrayList)request.getAttribute("pLesCategVente");
                        for (int i=0; i<lesCategVente.size();i++){
                            CategVente cv = lesCategVente.get(i);
                            out.println("<input type='checkbox' id='cb" + i + "' name='" + cv.getCode() + "'>"); 
                            out.println(cv.getLibelle()); 
                            out.println("</label></br>");
                        }
                    %>
                    </br>
                    --%>
                 
                
                    <button class="btn btn-outline-success" type="submit" name="valider" id="valider" value="Valider">Valider</button> <br>
            </form>
        </div>
                
              <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>

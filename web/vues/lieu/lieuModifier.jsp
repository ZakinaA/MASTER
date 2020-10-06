<%-- 
    Document   : lieuModifier
    Created on : 6 oct. 2020, 09:35:16
    Author     : sio2
--%>

<%@page import="formulaires.LieuForm"%>
<%@page import="modele.Lieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Consultation lieu</title>
    </head>
    <body>
        <h1>Infos lieu</h1>
        
         <%
        Lieu unLieu = (Lieu)request.getAttribute("pLieu");
        %>
        <div class="container-lg">
            <h1 class="display-3">NOUVEAU LIEU</h1>
        <form action="ajouterLieu" method="POST">
            <div class="form-group">
                <label for="ville">VILLE : </label>
                <input class="form-control" id="ville" type="text" name="ville"  size="40" maxlength="40" >
            </div>
                
            <div class="form-group">
                <label for="nbBoxes"><%  out.println(unLieu.getNbBoxes());%></label>
                <input class="form-control" id="nbBoxes"  type="number"  name="nbBoxes" size="3" maxlength="3">      
            </div>
            
            <div class="form-group">
                <label for="commentaire"><%  out.println(unLieu.getCommentaire());%></label>
                <input class="form-control" id="commentaire"  type="text"  name="commentaire" size="30" maxlength="30">      
            </div>
            <button class="btn btn-outline-success" type="submit" name="valider" id="valider" value="Valider">Ajouter</button> <br>
        
              <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
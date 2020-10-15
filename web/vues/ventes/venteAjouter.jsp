<%-- 
    Document   : venteAjouter
    Created on : 8 oct. 2020, 09:48:20
    Author     : sio2
--%>

<%@page import="modele.Lieu"%>
<%@page import="modele.CategVente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="formulaires.VenteForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Lieu Ajouter</title>
    </head>
    <body>
        
         <%
                VenteForm form = (VenteForm)request.getAttribute("form");
            %>
        <div class="container-lg">
            <h1 class="display-3">NOUVELLE VENTE</h1>
        <form action="ajouterVente" method="POST">
            <div class="form-group">
                <label for="nom">NOM : </label>
                <input class="form-control" id="nom" type="text" name="nom"  size="40" maxlength="40" >
            </div>
                
            <div class="form-group">
                <label for="dateDebut">DATE DE DEBUT : </label>
                <input class="form-control" id="dateDebut"  type="text"  name="dateDebut" size="10" maxlength="10">      
            </div>
            
            <div class="form-group">    
                <%-- Champ Liste des pays --%>
                <label for="categVente">CATEGORIE : </label>
                <select class="form-control" id="id_CategVente" name ="CategVente">
                    <%
                        ArrayList<CategVente> lesCategVentes = (ArrayList)request.getAttribute("pLesCategVentes");
                        for (int i=0; i < lesCategVentes.size(); i++){
                            CategVente c = lesCategVentes.get(i);
                            out.println("<option value='" + c.getCode()+"'>" + c.getLibelle()+"</option>" );
                        } 
                    %>
                </select>
            </div> 
            <div class="form-group">    
                <%-- Champ Liste des pays --%>
                <label for="lieu">Lieu : </label>
                <select class="form-control" id="id_lieu" name ="lieu">
                    <%
                        ArrayList<Lieu> lesLieux = (ArrayList)request.getAttribute("pLesLieux");
                        for (int i=0; i < lesLieux.size(); i++){
                            Lieu l = lesLieux.get(i);
                            out.println("<option value='" + l.getId()+"'>" + l.getVille()+"</option>" );
                        } 
                    %>
                </select>
            </div> 
                
            <button class="btn btn-outline-success" type="submit" name="valider" id="valider" value="Valider">Ajouter</button> <br>
            
            </form>
        </div>
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>

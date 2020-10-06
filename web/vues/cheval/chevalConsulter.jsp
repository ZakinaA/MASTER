<%-- 
    Document   : consulterCheval
    Author     : DUBOSQ
--%>

<%@page import="modele.Cheval"%>
<%@page import="modele.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Cheval ajouté !</title>
    </head>
    <body>
        
        
         <%
        Cheval unCheval = (Cheval)request.getAttribute("pCheval");
        %>
        
        <div class="container-lg">
         <h1>Infos Cheval</h1>
         <table class="table table-bordered table-striped table-condensed">
            <tr><td>NOM :</td><td><% out.println(unCheval.getNom());%></td></tr>
            <tr><td>SEXE :</td><td><% out.println(unCheval.getSexe());%></td></tr>
            <tr><td>PRIX DEPART :</td><td><% out.println(unCheval.getPrixDepart());%></td></tr>
            <tr><td>SIRE :</td><td><% out.println(unCheval.getSIRE());%></td></tr>
            <tr><td>CLIENT :</td><td><% out.println(unCheval.getUnClient().getId());%></td></tr>
            <tr><td>TYPE CHEVAL :</td><td><% out.println(unCheval.getLeTypeDeCheval().getId());%></td></tr>
            <tr><td>MERE :</td><td><% out.println(unCheval.getMere().getId());%></td></tr>
            <tr><td>PERE :</td><td><% out.println(unCheval.getPere().getId());%></td></tr>


            
              </td></tr>
        </table>
        </div>
              <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>

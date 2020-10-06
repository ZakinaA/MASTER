<%-- 
    Document   : listerLesLieux
    Created on : 1 oct. 2020, 15:32:50
    Author     : sio2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modele.Lieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/015f2278b9.js" crossorigin="anonymous"></script>
        
        <title>LISTE DES LIEUX</title>
    </head>
    <body>
        
    <div class="container-lg">
        <h1>LISTE DES LIEUX</h1>
         <%
        ArrayList<Lieu> lesLieux = (ArrayList)request.getAttribute("pLesLieux");
        %>
        <table class="table table-hover table-striped shadow-lg p-3 mb-5 bg-white rounded">
            <thead>
              <tr>
                    <th>ID</th>
                    <th>VILLE</th>
                    <th>NOMBRE DE BOXES</th>
                    <th>COMMENTAIRE</th>
                    <th>MODIFIER</th>
                    <th>SUPPRIMER</th>
              </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesLieux.size();i++)
                    {
                        
                        Lieu unLieu = lesLieux.get(i); 
                        out.println("<tr>");
                        out.println("<th scope='row'>");
                        out.println(unLieu.getId());
                        out.println("</th>");
                        
                        out.println("<td> ");
                        out.println(unLieu.getVille());
                        out.println("</td>");
                        
                        out.println("<td> ");
                        out.println(unLieu.getNbBoxes());
                        out.println("</td>");
                        
                        out.println("<td> ");
                        out.println(unLieu.getCommentaire());
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVentes/listerLesChevaux?idLieu1="+ unLieu.getId()+"'>");
                        out.println("<center><i class='fas fa-edit text-dark'></i></center>");
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVentes/listerLesChevaux?idLieu2="+ unLieu.getId()+"'>");
                        out.println("<center><i class='fas fa-trash-alt text-dark'></i></center>");
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

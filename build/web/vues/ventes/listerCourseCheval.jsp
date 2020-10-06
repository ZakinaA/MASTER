<%-- 
    Document   : Lister les Ventes 
    Created on : 22/06/2017, 07:43
    Author     : Zakina
--%>

<%@page import="modele.Cheval"%>
<%@page import="modele.Participer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        
        <title>LISTE DES COURSES</title>
    </head>
    <body>
        
    <div class="container-lg">
        
         <%
        ArrayList<Participer> lesParticipations = (ArrayList)request.getAttribute("pIdCheval");
        /*
        if (lesParticipations == null){
            Cheval unChevalNull = new Cheval();
            unChevalNull.setNom("Pas de course!");
            lesParticipations.add(unChevalNull);
        }
        */
        %>
        
        <h1>LISTE DES COURSES DE <% out.print("" + lesParticipations.get(0).getUnCheval().getNom().toUpperCase()); %> </h1> 
        <table class="table table-hover table-striped shadow-lg p-3 mb-5 bg-white rounded">
            <thead>
              <tr>
                    
                    <th>POSITION</th>
                    <th>COURSE</th>


              </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesParticipations.size(); i++)
                    {
                        
                        Participer uneParticipation = lesParticipations.get(i); 

                        out.println("<tr> ");
                        out.println("<th scope='row'>");
                        out.println(uneParticipation.getPlace());
                        out.println("</td>");
                        
                        
                        out.println("<td> ");
                        out.println(uneParticipation.getUneCourse().getLibelle());
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

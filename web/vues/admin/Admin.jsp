<%-- 
    Document   : Accueil
    Created on : 6 oct. 2020, 11:26:54
    Author     : sio2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session.getAttribute("admin") == null){
            session.invalidate();
            request.setAttribute("errMessage", "Déconnexion");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");
            requestDispatcher.forward(request, response);
            System.out.println("------------------ Accès refusé ---------------");
            
        }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! (ADMIN!)</h1>
        <div style="text-align: right"><a href="<%=request.getContextPath()%>/_deconnexion">Deconnexion</a></div>
    </body>
</html>

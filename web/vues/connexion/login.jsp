<%-- 
    Document   : login
    Created on : 6 oct. 2020, 10:25:46
    Author     : DUBOSQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Equida - Se connecter</title>


     <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        

  </head>

  <body class="text-center">
      <form class="form-signin" action="/EquidaWeb20/connexion" method="post">
        <div class="container col-3" style="transform: translateY(50%);">
            <img class="mb-4" src="vues/Images/black-head-horse-side-view-with-horsehair.png" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Bienvenue</h1>
            
            <label for="inputEmail" class="sr-only">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Nom d'utilisateur" required autofocus>
            
            <label for="inputPassword" class="sr-only">Mot de passe</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" required>
            <div class="mb-1"></div>
            <div>
                <div style="color: crimson">
                    <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
                </div>
            </div>
            
            <button class="btn btn-lg btn-outline-success btn-block" type="submit">Se connecter</button>
            <hr class="featurette-divider">
          <p>
              2020 SIO2 · Pablo, Melvyn, Noé.
          </p>

        </div>
    </form>
      
  </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</html>


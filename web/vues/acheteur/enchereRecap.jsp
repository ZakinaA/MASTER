<%-- 
    Document   : enchereRecap
    Created on : 8 nov. 2020, 17:48:02
    Author     : noedu
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

    <title>Merci !</title>


     <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        

  </head>

  <body>
      <div class="container">
          <h1 class="display-4">Equida vous remercie pour cette enchère !</h1>
      </div>
      <div class="text-center p-5">
        <div class="spinner-border text-success" style="width: 8rem; height: 8rem;" role="status">
        </div>
          <span></span>
      </div>
      <h6 class="text-center">Un instant, vous allez être redirigé vers l'accueil.</h6>
  </body>
  <script>
        if(true){
        window.setTimeout(function(){
            window.location.href = "/MASTER/acheteur/Accueil";
        }, 5000);
        }
  </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>



<%@page import="formulaires.ChevalForm"%>
<%@page import="modele.Cheval"%>
<%@page import="modele.TypeCheval"%>
<%@page import="modele.Client"%>
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
        
         <%
                //Client client=(Client)request.getAttribute("client");
                ChevalForm form = (ChevalForm)request.getAttribute("form");
            %>
        <div class="container-lg">
            <h1 class="display-3">NOUVEAU CHEVAL</h1>
            <form action="ajouterCheval" method="POST">
            <div class="form-group">
                <label for="nom">Nom : </label>
                <input class="form-control" id="nom" type="text" name="nom"  size="30" maxlength="30" >
            </div>
            
            Sexe :
            <div class="form-check">
                <input class="form-check-input" type="radio" name="sexe" id="exampleRadios1" value="M" checked>
                <label class="form-check-label" for="sexe">
                  Mâle
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="sexe" id="exampleRadios2" value="F">
                <label class="form-check-label" for="sexe">
                  Femelle
                </label> 
              </div>
              
            <div class="form-group">
                <br>
                <label for="prixDepart">Prix Départ : </label>
                <input class="form-control" id="prixDepart"  type="text"  name="prixDepart" size="30" maxlength="50">
            </div>
                               
            <div class="form-group">
                <label for="sire">SIRE : </label>
                <input class="form-control" id="sire"  type="text"  name="sire" size="5" maxlength="5">
            </div>
              
            <div class="form-group">    
                <%-- Champ Liste des pays --%>
                <label for="client">Client : </label>
                <select class="form-control" id="id_client" name ="client">
                    <%
                        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClients");
                        for (int i=0; i < lesClients.size(); i++){
                            Client c = lesClients.get(i);
                            out.println("<option value='" + c.getId()+"'>" + c.getNom()+"</option>" );
                        } 
                    %>
                </select>
            </div>          
                
            <div class="form-group">
                <label for="typeCheval">Type Cheval : </label>
                <select class="form-control" name="typeCheval">
                <%
                        ArrayList<TypeCheval> lesTypesDeChevaux = (ArrayList)request.getAttribute("pLesTypesDeChevaux");
                        for (int i=0; i<lesTypesDeChevaux.size();i++){
                            TypeCheval tc = lesTypesDeChevaux.get(i);
                            out.println("<option value ='" + tc.getId() + "'>" + tc.getLibelle() + "</option>"); 
                           
                        }
                    %>
                </select>
            </div>
                
            <div class="form-group">
                <label for="mere">Mere : </label>
                <select class="form-control" name="mere">
                <%
                        ArrayList<Cheval> lesChevauxMere = (ArrayList)request.getAttribute("pLesChevauxMere");
                        for (int i=0; i< lesChevauxMere.size();i++){
                            Cheval che = lesChevauxMere.get(i);
                            out.println("<option value ='" + che.getId() + "'>" + che.getNom() + "</option>"); 
                           
                        }
                    %>
                </select>
            </div>
                
            <div class="form-group">
                <label for="pere">Pere : </label>
                <select class="form-control" name="pere">
                <%
                        ArrayList<Cheval> lesChevauxPere = (ArrayList)request.getAttribute("pLesChevauxPere");
                        for (int i=0; i< lesChevauxPere.size();i++){
                            Cheval che = lesChevauxPere.get(i);
                            out.println("<option value ='" + che.getId() + "'>" + che.getNom() + "</option>"); 
                           
                        }
                    %>
                </select>
            </div>
                 
                
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


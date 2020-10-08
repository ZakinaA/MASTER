/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaires;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import modele.CategVente;
import modele.Cheval;
import modele.Client;
import modele.Pays;
import modele.Role;
import modele.TypeCheval;
import modele.Utilisateur;

/**
 *
 * @author sio2
 */
public class LoginForm {
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

//    public void setErreurs(Map<String, String> erreurs) {
//        this.erreurs = erreurs;
//    }
//
//
//    private void setErreur(String champ, String message) {
//    erreurs.put(champ, message);
//    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
    
    public Utilisateur ajouterUtilisateur(HttpServletRequest request) {
      
        Utilisateur unUtilisateur = new Utilisateur();

        String email = getDataForm(request, "mail");
        String username = getDataForm(request, "user");
        String password = getDataForm(request, "password");
        int role = Integer.parseInt(getDataForm(request, "role"));
         
      
        unUtilisateur.setEmail(email);
        unUtilisateur.setUsername(username);
        unUtilisateur.setPassword(password);
        unUtilisateur.setRole(new Role(role));

       
        return unUtilisateur;
    }

}

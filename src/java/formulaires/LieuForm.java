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
import modele.Lieu;

/**
 *
 * @author sio2
 */
public class LieuForm {
        
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

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    //méthode de validation du champ de saisie ville
    private void validationVille( String ville ) throws Exception {
        if ( ville != null && ville.length() < 2   ) {
        throw new Exception( "Le nom d'une ville doit contenir 2 caractères minimum." );
        }
    }

    private void setErreur( String champ, String message ) {
    erreurs.put(champ, message );
    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
    
    
    public Lieu ajouterLieu( HttpServletRequest request ) {
      
        Lieu unLieu  = new Lieu();
         
        String ville = getDataForm( request, "ville" );
        int nbBoxes = Integer.parseInt(getDataForm( request, "nbBoxes"));
        String commentaire = getDataForm( request, "commentaire");
       
        try {
             validationVille( ville );
        } catch ( Exception e ) {
            setErreur( "ville", e.getMessage() );
        }
        unLieu.setVille(ville);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
     
        unLieu.setVille(ville);
        unLieu.setNbBoxes(nbBoxes);
        unLieu.setCommentaire(commentaire);

               
       
        return unLieu;
    }

}

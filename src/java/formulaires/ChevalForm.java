                         /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaires;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import modele.CategVente;
import modele.Cheval;
import modele.Client;
import modele.Pays;
import modele.TypeCheval;

/**
 *
 * @author Zakina
 */
public class ChevalForm {
    
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
    
    //méthode de validation du champ de saisie nom
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 2 ) {
        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
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
    
    
    public Cheval ajouterCheval( HttpServletRequest request ) {
      
        Cheval unCheval  = new Cheval();
         
        String nom = getDataForm( request, "nom" );
        String sexe = getDataForm( request, "sexe" );
        String prixDepart = getDataForm( request, "prixDepart" );
        String SIRE = getDataForm( request, "sire" );
        int client =  Integer.parseInt(getDataForm(request, "client"));
        int typeCheval = Integer.parseInt(getDataForm(request, "typeCheval"));
        int mere = Integer.parseInt(getDataForm(request, "mere"));
        int pere = Integer.parseInt(getDataForm(request, "pere"));
        
 
       
        try {
             validationNom( nom );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
        unCheval.setNom(nom);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unCheval.setNom(nom);
        unCheval.setSexe(sexe);
        unCheval.setPrixDepart(Integer.parseInt(prixDepart));
        unCheval.setSIRE(SIRE);
        unCheval.setUnClient(new Client(client));
        unCheval.setLeTypeDeCheval(new TypeCheval(typeCheval));
        unCheval.setMere(new Cheval(mere));
        unCheval.setPere(new Cheval(pere));
        
               
       
        return unCheval ;
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Entraineur;

/**
 *
 * @author sio2
 */
public class EntraineurDAO {
   Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Entraineur>  getLesEntraineurs(Connection connection){      
        ArrayList<Entraineur> lesEntraineurs = new  ArrayList<Entraineur>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from entraineur");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Entraineur unEntraineur = new Entraineur();
                unEntraineur.setNom(rs.getString("nom"));
                unEntraineur.setPrenom(rs.getString("prenom"));
                lesEntraineurs.add(unEntraineur);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesEntraineurs ;    
    } 
    
      public static Entraineur ajouterEntraineur(Connection connection, Entraineur unEntraineur){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("insert into entraineur ( prenom, nom)\n" +
                    "values (?,?)");
            requete.setString(1, unEntraineur.getNom());
            requete.setString(2, unEntraineur.getPrenom());
            
           /* Exécution de la requête */
            requete.executeUpdate();
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unEntraineur ;    
    } 
}

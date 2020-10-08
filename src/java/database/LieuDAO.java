/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.ClientDAO.requete;
import static database.ClientDAO.rs;
import static database.VenteDAO.requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.CategVente;
import modele.Lieu;

/**
 *
 * @author sio2
 */
public class LieuDAO {
      
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Lieu>  getLesLieux(Connection connection){      
        ArrayList<Lieu> lesLieux = new  ArrayList<Lieu>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from lieu");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Lieu avec les résultats de la requête
            while ( rs.next() ) {  
                Lieu unLieu = new Lieu();
                unLieu.setId(rs.getInt("id"));
                unLieu.setVille(rs.getString("ville"));
                unLieu.setNbBoxes(rs.getInt("nbBoxes"));
                unLieu.setCommentaire(rs.getString("commentaire"));
                lesLieux.add(unLieu);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesLieux ;    
    } 
     
    public static ArrayList<Lieu>  getLeLieu(Connection connection, String idLieu1){      
        ArrayList<Lieu> leLieu = new  ArrayList<Lieu>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from lieu where id = ?");
            requete.setString(1, idLieu1);
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Lieu avec les résultats de la requête
            while ( rs.next() ) {  
                Lieu unLieu = new Lieu();
                unLieu.setId(rs.getInt("id"));
                unLieu.setVille(rs.getString("ville"));
                unLieu.setNbBoxes(rs.getInt("nbBoxes"));
                unLieu.setCommentaire(rs.getString("commentaire"));
                leLieu.add(unLieu);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leLieu ;    
    } 
    
    public static Lieu ajouterLieu(Connection connection, Lieu unLieu){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO lieu ( ville, nbBoxes, commentaire)\n" +
                    "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unLieu.getVille());
            requete.setInt(2, unLieu.getNbBoxes());
            requete.setString(3, unLieu.getCommentaire());
            
            
           /* Exécution de la requête */
            requete.executeUpdate();
            
            
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unLieu.setId(idGenere);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unLieu ;    
    }
}

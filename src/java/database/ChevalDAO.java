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
import modele.Cheval;
import modele.Client;
import modele.TypeCheval;

/**
 *
 * @author Dubosq
 */

public class ChevalDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Cheval>  getLesChevaux(Connection connection){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("SELECT cheval.id, cheval.nom, cheval.sexe, cheval.prixDepart, cheval.SIRE as chevalSire, cheval.img_url, cheval.isActive, typecheval.libelle as Race, chevalPere.nom as pere, chevalMere.nom as mere, client.nom as nomVendeur "
                    + "FROM client, cheval, typecheval, cheval chevalPere, cheval chevalMere "
                    + "WHERE cheval.id_typeCheval = typecheval.id AND cheval.id_pere = chevalPere.id AND cheval.id_mere = chevalMere.id "
                    + "AND cheval.id_client = client.id AND cheval.isActive = 1 order by cheval.id;");
            
            //executer la requete
            rs=requete.executeQuery();
            
            while ( rs.next() ) {
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                unCheval.setPrixDepart(rs.getInt("prixDepart"));
                unCheval.setSIRE(rs.getString("chevalSire"));
                unCheval.setImg_url(rs.getString("img_url"));
                unCheval.setIsActive(rs.getInt("isActive"));
               
                Cheval unChevalPere = new Cheval();
                unChevalPere.setNom(rs.getString("pere"));
                
                Cheval unChevalMere = new Cheval();
                unChevalMere.setNom(rs.getString("mere"));
                
                
                Client unClient = new Client();
                unClient.setNom(rs.getString("nomVendeur"));
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setLibelle(rs.getString("Race"));
                
                
                unCheval.setLeTypeDeCheval(unTypeCheval);
                unCheval.setUnClient(unClient);
                
                unCheval.setPere(unChevalPere);
                unCheval.setMere(unChevalMere);
                
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesChevaux ;    
    } 
    
     public static Cheval ajouterCheval(Connection connection, Cheval unCheval){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO cheval ( nom, sexe, prixDepart, SIRE, id_client, id_typeCheval, id_mere, id_pere)\n" +
                    "VALUES (?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setInt(3, unCheval.getPrixDepart());
            requete.setString(4, unCheval.getSIRE());
            requete.setInt(5, unCheval.getUnClient().getId());
            requete.setInt(6, unCheval.getLeTypeDeCheval().getId());
            requete.setInt(7, unCheval.getMere().getId());
            requete.setInt(8, unCheval.getPere().getId());

           /* Exécution de la requête */
            requete.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            }
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval;    
    }
     
     public void deleteCheval(Connection connection, int idCheval){
         try {
             requete=connection.prepareStatement("DELETE FROM cheval WHERE id = ?");
             requete.setInt(1, idCheval);
             requete.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}

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
import modele.Enchere;
import modele.Lot;


/**
 *
 * @author Dubosq 
 */

public class LotDAO {
        Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static Lot getLotByIdCheval(Connection connection, String idCheval, String idVente){      
        
        Lot unLot = null;
        try
        {
              unLot = new Lot();
            requete=connection.prepareStatement("SELECT * from lot where lot.id_cheval = ? and lot.id_vente = ?");
            requete.setInt(1, Integer.parseInt(idCheval));
            requete.setInt(2, Integer.parseInt(idVente));
            
            System.out.println("requeteLot:" + requete);
            rs=requete.executeQuery();
             
                while ( rs.next() ) {
                System.out.println("Lot =================: " + unLot.getId());
                unLot.setId(rs.getInt("id"));
                unLot.setPrixDepart(rs.getInt("prixDepart"));

                }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return unLot;  
    }
     
     public static Enchere encherirSurUnLot(Connection connection, Enchere uneEnchere){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("insert into enchere (montant, id_lot)\n" +
                    "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, uneEnchere.getMontant());
            requete.setInt(2, uneEnchere.getLot().getId());

           /* Exécution de la requête */
            requete.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                uneEnchere.setId(idGenere);
            }
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return uneEnchere ;    
    }
     
    public static Enchere prixActuel(Connection connection, int idLot){
        Enchere uneEnchere = null;
        try {
            uneEnchere = new Enchere();
            requete = connection.prepareStatement("select enchere.dateEnchere, max(enchere.montant) as montantMax from enchere, lot where enchere.id_lot = lot.id and lot.id = ?");
            requete.setInt(1, idLot);
            
            rs=requete.executeQuery();
            while ( rs.next() ) {
                //System.out.println(":" + uneEnchere.getId());
                uneEnchere.setDateEnchere(rs.getString("dateEnchere"));
                uneEnchere.setMontant(rs.getInt("montantMax"));

                }
        } catch (Exception e) {
        
        }
            return uneEnchere;
    
    }
    
    public int verifEnchere(Connection connection, Enchere uneEnchere, int idLot){
        int montant = uneEnchere.getMontant();
        int montantDB;
        
        try {
            requete = connection.prepareStatement("SELECT MAX(enchere.montant) as maxMontant from enchere, lot where enchere.id_lot = ?");
            requete.setInt(1, idLot);
            rs = requete.executeQuery();
            System.out.println("requete:" + requete);
            
            while (rs.next()) {
                montantDB = rs.getInt("maxMontant");

                if (montant <= montantDB) {
                    System.out.println("montant < montantdb");
                    return 1;    
                }
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("montant: " + montant);
        return montant;
    }
}

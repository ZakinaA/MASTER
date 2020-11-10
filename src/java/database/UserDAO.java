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
import modele.Utilisateur;

/**
 *
 * @author sio2
 */
public class UserDAO {

    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public String authentification(Connection connection, Utilisateur unUtilisateur){
        String username = unUtilisateur.getUsername();
        String password = unUtilisateur.getPassword();
        
        String usernameDB = "";
        String passwordDB = "";
        String roleDB = "";
        
        try {
            requete = connection.prepareStatement("SELECT utilisateur.username, utilisateur.password, role.libelle as role from utilisateur, role where utilisateur.id_role = role.id");
            rs = requete.executeQuery();
            
            while (rs.next()) {
                usernameDB = rs.getString("username");
                passwordDB = rs.getString("password");
                roleDB = rs.getString("role");

                if (username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("admin")) {
                    return "admin";
                } else if (username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("employee")) {
                    return "employee";
                } else if (username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("acheteur")) {
                    return "acheteur";
                } else if (username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("vendeur")) {
                    return "vendeur";
                }
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "Erreur d'authentifcation";
    }
    
    public static Utilisateur ajouterUtilisateur(Connection connection, Utilisateur unUtilisateur){      
        int idGenere = -1;
        try
        {
            requete=connection.prepareStatement("INSERT INTO utilisateur (username, email, password, id_role)\n" +
                    "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getUsername());
            requete.setString(2, unUtilisateur.getEmail());
            requete.setString(3, unUtilisateur.getPassword());
            requete.setInt(4, unUtilisateur.getRole().getId());
            //requete.setInt(5, unUtilisateur.getId_client());

            requete.executeUpdate();
            System.out.println("query:" + requete);
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setId(idGenere);
                //unUtilisateur.setId_client(idGenere);
            }
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return unUtilisateur ;    
    }
}

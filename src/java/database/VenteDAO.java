package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.CategVente;
import modele.Cheval;
import modele.Client;
import modele.Courriel;
import modele.Course;
import modele.Entraineur;
import modele.Lieu;
import modele.Participer;
import modele.Pays;
import modele.TypeCheval;
import modele.Vente;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class VenteDAO {


    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author Zakina - 22/06/2017
    /* Méthode permettant de lister toutes les ventes enregistrées en base, triées par date décroissante.
    /* Pour chaque vente, on récupère aussi sa catégorie.
    /* La liste des vente est stockée dans une ArrayList
    */
    public static ArrayList<Vente>  getLesVentes(Connection connection){      
        ArrayList<Vente> lesVentes = new  ArrayList<Vente>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from vente, categvente, lieu where vente.codeCategVente=categvente.code and lieu.id = vente.id_lieu and vente.isActive = 1 order by vente.id");          
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Vente uneVente = new Vente();
                uneVente.setId(rs.getInt("id"));
                uneVente.setNom(rs.getString("nom"));
                uneVente.setDateDebutVente(rs.getString("dateDebut"));
                
                CategVente uneCateg = new CategVente();
                uneCateg.setCode(rs.getString("code"));  // on aurait aussi pu prendre CodeCateg
                uneCateg.setLibelle(rs.getString("libelle"));
                
                uneVente.setUneCategVente(uneCateg);
                lesVentes.add(uneVente);
                
                Lieu unLieu = new Lieu();
                unLieu.setId(rs.getInt("id"));
                unLieu.setVille(rs.getString("ville"));
                unLieu.setNbBoxes(rs.getInt("nbBoxes"));
                unLieu.setCommentaire(rs.getString("commentaire"));
                
                uneVente.setUnLieu(unLieu);
                
                
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesVentes ;    
    } 
    
    /* @author Zakina - 22/06/2017
    /* Méthode permettant de lister les clients interessés par la catégorie de la vente selectionnée (passée en paramètre de la méthode)
    /* Pour chaque client, on récupère aussi le nom de son pays
    /* La liste des clients est stockée dans une ArrayList
    */
    public static ArrayList<Client>  getLesClients(Connection connection, String codeCateg){      
        ArrayList<Client> lesClients = new  ArrayList<Client>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT c.*, p.nom as nomPays, cv.libelle FROM client c, pays p, clientcategvente cc, categvente cv where c.codePays=p.code and cc.codeClient=c.id and cv.code=cc.codeCategVente and codeCategVente= ? ORDER BY c.id");
            requete.setString(1, codeCateg);
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                
                
                Client unClient = new Client();
                unClient.setId(rs.getInt("id"));
                unClient.setNom(rs.getString("nom"));
                unClient.setPrenom(rs.getString("prenom"));
                unClient.setRue(rs.getString("rue"));
                unClient.setCopos(rs.getString("copos"));
                unClient.setVille(rs.getString("ville"));
                unClient.setMail(rs.getString("mail"));
                
                Pays p = new Pays();
                p.setCode(rs.getString("codePays"));
                p.setNom(rs.getString("nomPays"));
                
                unClient.setUnPays(p);
                /*CategVente uneCateg = new CategVente();
                uneCateg.setCode(rs.getString("code"));  // on aurait aussi pu prendre CodeCateg
                uneCateg.setLibelle(rs.getString("libelle"));*/
                
                lesClients.add(unClient);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesClients ;    
    } 
    
    
    public static ArrayList<Courriel>  getLesCourriels(Connection connection, String idVente){      
        ArrayList<Courriel> lesCourriels = new  ArrayList<Courriel>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("SELECT mail.* FROM vente, mail WHERE vente.id = mail.id_vente AND vente.id = ?");
            requete.setString(1, idVente);
            //executer la requete
            rs=requete.executeQuery();
             
            
            while ( rs.next() ) {  
   
                Courriel unCourriel = new Courriel();
                unCourriel.setId(rs.getInt("id"));
                unCourriel.setObjet(rs.getString("objet"));
                unCourriel.setCorps(rs.getString("corps"));
                unCourriel.setDate(rs.getString("date_mail"));
                
                lesCourriels.add(unCourriel);
                System.out.println(unCourriel);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            
        }
        return lesCourriels ;    
    } 

    
   public static ArrayList<Cheval>  getLesChevaux(Connection connection, String idVente){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
             
            requete=connection.prepareStatement("SELECT cheval.id cheval.nom client.nom as nomVendeur, typecheval.libelle as Race, lot.prixDepart as prixDep, cheval.id_mere as mere, cheval.id_pere as pere, client.nom as nomDuVendeur FROM cheval, lot, vente, typecheval, client WHERE cheval.id = lot.id_cheval AND cheval.id_client = client.id AND cheval.id_typeCheval = typecheval.id AND lot.id_vente = vente.id AND vente.id = ?");
            requete.setString(1, idVente);
            
            System.out.println("requete" + requete);
            rs=requete.executeQuery();
            
            while ( rs.next() ) { 
                
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));

                Client unClient = new Client();
                unClient.setId(rs.getInt("id"));  
                unClient.setNom(rs.getString("nomVendeur"));
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setId(rs.getInt("id"));
                unTypeCheval.setLibelle(rs.getString("race"));
                
                unCheval.setUnClient(unClient);
                unCheval.setLeTypeDeCheval(unTypeCheval);
                
                lesChevaux.add(unCheval);

            }
            System.out.println("lesChevaux" + lesChevaux.size());
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesChevaux;
        
    }
   
    public static Cheval  getInfosCheval(Connection connection, String idCheval){      
        
        Cheval unCheval = null;
        try
        {
              unCheval = new Cheval();
            requete=connection.prepareStatement("SELECT cheval.id, cheval.nom, cheval.sexe, cheval.prixDepart, cheval.SIRE, cheval.img_url as img, typecheval.libelle as Race, chevalPere.nom as pere, chevalMere.nom as mere, client.nom as nomVendeur, chevalPere.id as idpere, chevalMere.id as idmere, entraineur.nom as nomEntraineur FROM client, cheval, typecheval, cheval chevalPere, cheval chevalMere, entraineur WHERE cheval.id_typeCheval = typecheval.id AND cheval.id_pere = chevalPere.id AND cheval.id_mere = chevalMere.id AND cheval.idEntraineur = entraineur.id AND cheval.id_client = client.id AND cheval.id = ?");
            requete.setInt(1, Integer.parseInt(idCheval));
            
            System.out.println("requete" + requete);
            rs=requete.executeQuery();
             
                while ( rs.next() ) {
                //System.out.println("Cheval/1: " + unCheval.getId());
                
                unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                unCheval.setPrixDepart(rs.getInt("prixDepart"));
                unCheval.setSIRE(rs.getString("SIRE"));
                unCheval.setImg_url(rs.getString("img"));
               
                Cheval unChevalPere = new Cheval();
                unChevalPere.setId(rs.getInt("idpere"));
                unChevalPere.setNom(rs.getString("pere"));
                
                Cheval unChevalMere = new Cheval();
                unChevalMere.setId(rs.getInt("idmere"));
                unChevalMere.setNom(rs.getString("mere"));
                
                
                Client unClient = new Client();
                unClient.setNom(rs.getString("nomVendeur"));
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setLibelle(rs.getString("Race"));
                
                Entraineur unEntraineur = new Entraineur();
                unEntraineur.setNom(rs.getString("nomEntraineur"));
                
                
                unCheval.setLeTypeDeCheval(unTypeCheval);
                unCheval.setUnClient(unClient);
                
                unCheval.setPere(unChevalPere);
                unCheval.setMere(unChevalMere);
                unCheval.setUnEntraineur(unEntraineur);
                
                
                }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return unCheval;
        
    }
    
    public static ArrayList<Participer>  getLesCourses(Connection connection, String idCheval){      
        ArrayList<Participer> lesParticipations = new  ArrayList<Participer>();
        try
        {
             
            requete=connection.prepareStatement("SELECT  cheval.id, cheval.nom, participer.id ,course.libelle, participer.place FROM cheval, course, participer WHERE cheval.id = participer.id_cheval AND course.id = participer.id_course AND cheval.id = ? ORDER BY participer.place;");
            requete.setString(1, idCheval);
            
            System.out.println("requete" + requete);
            rs=requete.executeQuery();
            
            while ( rs.next() ) { 
                
                Participer uneParticipation = new Participer();
                uneParticipation.setId(rs.getInt("id"));
                uneParticipation.setPlace(rs.getInt("place"));
                
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));
                
                Course uneCourse = new Course();
                uneCourse.setLibelle(rs.getString("libelle"));
                
                uneParticipation.setUnCheval(unCheval);
                uneParticipation.setUneCourse(uneCourse);
                
                lesParticipations.add(uneParticipation);


            }
            System.out.println("lesChevaux" + lesParticipations.size());
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesParticipations;
        
    }

}

//SELECT COUNT(vente.id), categvente.libelle from categvente, vente WHERE categvente.code = vente.codeCategVente GROUP BY categvente.libelle;
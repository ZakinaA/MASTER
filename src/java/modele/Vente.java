package modele;

import database.VenteDAO;
import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class Vente {
    private int id;
    private String nom;
    private String dateDebutVente;
    private Lieu unLieu ;
    private CategVente uneCategVente;
    private ArrayList<Courriel> lesCourriels ;
    private ArrayList<TypeCheval> lesTypesDeChevaux;
    private Vente uneVente;
    private int NbCourriels;

    public Vente() {
    }

    public Vente(int id, String nom, String dateDebutVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
    }


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public CategVente getUneCategVente() {
        return uneCategVente;
    }

    public void setUneCategVente(CategVente uneCategVente) {
        this.uneCategVente = uneCategVente;
    }

    public Lieu getUnLieu() {
        return unLieu;
    }

    public void setUnLieu(Lieu unLieu) {
        this.unLieu = unLieu;
    }

    public ArrayList<Courriel> getLesCourriels() {
	return lesCourriels;
    }

    public void setLesCourriels(ArrayList<Courriel> lesCourriels) {
	this.lesCourriels = lesCourriels;
    }
    
    public void addUnCourriel(Courriel unCourriel) {
	if(lesCourriels == null) {
            lesCourriels = new ArrayList<Courriel>();
        }
        lesCourriels.add(unCourriel);
    }

    public ArrayList<TypeCheval> getLesTypesDeChevaux() {
        return lesTypesDeChevaux;
    }

    public void setLesTypesDeChevaux(ArrayList<TypeCheval> lesTypesDeChevaux) {
        this.lesTypesDeChevaux = lesTypesDeChevaux;
    }
	
    public void addUnTypeDeCheval(TypeCheval unTypeDeCheval){
        if(lesTypesDeChevaux == null){
            lesTypesDeChevaux = new ArrayList<TypeCheval>();
        }
        lesTypesDeChevaux.add(unTypeDeCheval);
    }

    public Vente getUneVente() {
        return uneVente;
    }

    public void setUneVente(Vente uneVente) {
        this.uneVente = uneVente;
    }
    
    //methode permettant de renvoyer le nb de courriels.
    public int getNbCourriel(){
       NbCourriels = lesCourriels.size();
        return NbCourriels;
    }
    
}

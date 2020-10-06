package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class Client {
    
    private int id;
    private String nom;
    private String prenom ;
    private String rue;
    private String copos ;
    private String ville;
    private String mail;
    private Pays unPays ;
    private ArrayList<CategVente> lesCategVentes ;
    private int NbCateg;
    private int NbVente;

    public Client() {
    }
    
    public Client(int id) {
        this.id = id;
    }

    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCopos() {
        return copos;
    }

    public void setCopos(String copos) {
        this.copos = copos;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Pays getUnPays() {
        return unPays;
    }

    public void setUnPays(Pays unPays) {
        this.unPays = unPays;
    }
    
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

    public ArrayList<CategVente> getLesCategVentes() {
        return lesCategVentes;
    }

    public void setLesCategVentes(ArrayList<CategVente> lesCategVentes) {
        this.lesCategVentes = lesCategVentes;
    }
          
    public void addUneCategVente(CategVente uneCategVente){
        if (lesCategVentes == null){
            lesCategVentes = new ArrayList<CategVente>();
        }
        lesCategVentes.add(uneCategVente);
    }

    //method renvoyant le nb de catégorie par client 
    public int getNbCateg(){
        NbCateg = lesCategVentes.size();
        return NbCateg;
    }
    
    public int getNbVentes(String year){
        for (int i = 0; i < lesCategVentes.size(); i++){
            CategVente cv = lesCategVentes.get(id);
            
            for (int x = 0; x < cv.getLesVentes().size(); x++){    
                Vente v = cv.getLesVentes().get(id);
                if (v.getDateDebutVente() == "2019"){
                    NbVente += 1;
                }
            }
        }
 
        return NbVente;
    }
	
}
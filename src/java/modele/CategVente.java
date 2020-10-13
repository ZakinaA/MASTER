package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class CategVente {
    private String code;
    private String libelle ;
    private ArrayList<Client> lesClient ;
    private ArrayList<Vente> lesVentes;
    private int nbVente;
    private String img_url;

    public CategVente() {
    }

    public CategVente(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
    
	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNbVente() {
        return nbVente;
    }

    public void setNbVente(int nbVente) {
        this.nbVente = nbVente;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    
    
    
    
    
    /* Ajouter par Noé.D */
    public ArrayList<Client> getLesClient() {
		return lesClient;
	}

	public void setLesClient(ArrayList<Client> lesClient) {
		this.lesClient = lesClient;
	}
	
	public ArrayList<Vente> getLesVentes() {
		return lesVentes;
	}

	public void setLesVentes(ArrayList<Vente> lesVentes) {
		this.lesVentes = lesVentes;
	}
        
    
    public void addUnClient(Client unClient){
        if (lesClient == null){
            lesClient = new ArrayList<Client>();
        }
        lesClient.add(unClient);
    }
    
    public void addUneVente(Vente uneVente){
        if (lesVentes == null){
        	lesVentes = new ArrayList<Vente>();
        }
        lesVentes.add(uneVente);
    }

    
	

	
    
}

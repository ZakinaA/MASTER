package modele;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zakina
 */
public class CategVente {
    private String code;
    private String libelle ;
    private ArrayList<Client> lesClient ;
    private ArrayList<Vente> lesVentes;

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

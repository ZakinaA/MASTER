package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class Pays {
    
    private String code ;
    private String nom;
    private ArrayList<Client> lesClients;

    public Pays() {
    }

    public Pays(String code) {
        this.code = code;
    }

    public Pays(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

	public ArrayList<Client> getLesClients() {
		return lesClients;
	}

	public void setLesClients(ArrayList<Client> lesClients) {
		this.lesClients = lesClients;
	}
    
	public void addUnClient(Client unClient) {
		if (lesClients == null) {
			lesClients = new ArrayList<Client>();
		}
		lesClients.add(unClient);
	}
}

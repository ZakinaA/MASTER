package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class Lieu {
    private int id ;
    /* Ajouter par Noé.D */
    private String ville;
    private int nbBoxes;
    private String commentaire;
    /* Ajouter par Noé.D */
    private ArrayList<Vente> lesVentes;
    
    public Lieu() {
    	
    }

    
	public Lieu(int id, String ville) {
		this.id = id;
		this.ville = ville;
	}


	/* Ajouter par Noé.D */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNbBoxes() {
		return nbBoxes;
	}

	public void setNbBoxes(int nbBoxes) {
		this.nbBoxes = nbBoxes;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/* Ajouter par Noé.D */
	public ArrayList<Vente> getLesVentes() {
		return lesVentes;
	}

	public void setLesVentes(ArrayList<Vente> lesVentes) {
		this.lesVentes = lesVentes;
	}
    
    public void addUneVente(Vente uneVente){
        if (lesVentes == null){
        	lesVentes = new ArrayList<Vente>();
        }
        lesVentes.add(uneVente);
    }
}

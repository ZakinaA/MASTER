package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class Courriel {
	private int id;
	private String date;
	private String objet;
	private String corps;
	private Vente uneVente;
	private ArrayList<PieceJointe> lesPiecesJointes;
	
	public Courriel() {
		
	}
	
	public Courriel(int id, String date, String objet, String corps) {
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.corps = corps;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	
	public Vente getUneVente() {
		return uneVente;
	}
	public void setUneVente(Vente uneVente) {
		this.uneVente = uneVente;
	}
	
	public ArrayList<PieceJointe> getLesPiecesJointes() {
		return lesPiecesJointes;
	}
	public void setLesPiecesJointes(ArrayList<PieceJointe> lesPiecesJointes) {
		this.lesPiecesJointes = lesPiecesJointes;
	}
	
	public void addUnePieceJointe(PieceJointe unePieceJointe) {
		if(lesPiecesJointes == null) {
			lesPiecesJointes = new ArrayList<PieceJointe>();
		}
		lesPiecesJointes.add(unePieceJointe);
	}

}

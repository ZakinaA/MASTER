package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class PieceJointe {

	private int id;
	private String cheminAcces;
	private ArrayList<Courriel> lesCourriels;
	
	public PieceJointe() {
		
	}
	
	public PieceJointe(int id, String cheminAcces) {
		this.id = id;
		this.cheminAcces = cheminAcces;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCheminAcces() {
		return cheminAcces;
	}
	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}
	
	public ArrayList<Courriel> getLesCourriels() {
		return lesCourriels;
	}
	public void setLesCourriels(ArrayList<Courriel> lesCourriels) {
		this.lesCourriels = lesCourriels;
	}
	
	public void addUnCourriel(Courriel unCourriel){
		if(lesCourriels == null) {
			lesCourriels = new ArrayList<Courriel>();
		}
		lesCourriels.add(unCourriel);
	}
}

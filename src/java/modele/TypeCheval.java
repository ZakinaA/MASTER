package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class TypeCheval {
    private int id;
    private String libelle;
    private String description;
    private ArrayList<Vente> lesVentes;
    private ArrayList<Cheval> lesChevaux;

    public TypeCheval() {
    }
    
    public TypeCheval(int id) {
        this.id = id;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Vente> getLesVentes() {
        return lesVentes;
    }

    public void setLesVentes(ArrayList<Vente> lesVentes) {
        this.lesVentes = lesVentes;
    }

    
    
    public void addUneVente(Vente uneVente){
        if(lesVentes == null){
            lesVentes = new ArrayList<Vente>();
        }
        lesVentes.add(uneVente);
    }

    public ArrayList<Cheval> getLesChevaux() {
        return lesChevaux;
    }

    public void setLesChevaux(ArrayList<Cheval> lesChevaux) {
        this.lesChevaux = lesChevaux;
    }
    
    public void addUnCheval (Cheval unCheval){
        if(lesChevaux == null){
            lesChevaux = new ArrayList<Cheval>();
        }
        lesChevaux.add(unCheval);
    }
}

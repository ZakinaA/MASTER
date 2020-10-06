package modele;

import java.util.ArrayList;

/**
 * update 01/10/2020
 * @author DUBOSQ
 */
public class Cheval {
    private int id;
    private String nom;
    private String sexe;
    private int prixDepart;
    private String vendeur;
    private String SIRE;
    private String img_url;
    private TypeCheval leTypeDeCheval;
    private Client unClient;
    private Cheval mere;
    private Cheval pere;
    private ArrayList<Lot> lesLots;
    private ArrayList<Participer> lesParticipations;

    public Cheval(){
    }
    
    public Cheval(int id){
        this.id = id;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(int prixDepart) {
        this.prixDepart = prixDepart;
    }

    public String getVendeur() {
        return vendeur;
    }

    public void setVendeur(String vendeur) {
        this.vendeur = vendeur;
    }

    public String getSIRE() {
        return SIRE;
    }

    public void setSIRE(String SIRE) {
        this.SIRE = SIRE;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    
    public TypeCheval getLeTypeDeCheval() {
        return leTypeDeCheval;
    }

    public void setLeTypeDeCheval(TypeCheval leTypeDeCheval) {
        this.leTypeDeCheval = leTypeDeCheval;
    }

    public Client getUnClient() {
        return unClient;
    }

    public void setUnClient(Client unClient) {
        this.unClient = unClient;
    }

    public Cheval getMere() {
        return mere;
    }

    public void setMere(Cheval mere) {
        this.mere = mere;
    }

    public Cheval getPere() {
        return pere;
    }

    public void setPere(Cheval pere) {
        this.pere = pere;
    }

    public ArrayList<Lot> getLesLots() {
        return lesLots;
    }

    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }

    
    public void addUnLot(Lot unLot){
        if(lesLots == null){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(unLot);
    }
    
        public ArrayList<Participer> getLesParticipations() {
        return lesParticipations;
    }

    public void setLesParticipations(ArrayList<Participer> lesParticipations) {
        this.lesParticipations = lesParticipations;
    }
    
    public void addUneParticipation (Participer uneParticiaption){
        if(lesParticipations == null){
            lesParticipations = new ArrayList<Participer>();
        }
        lesParticipations.add(uneParticiaption);
    }
    
}

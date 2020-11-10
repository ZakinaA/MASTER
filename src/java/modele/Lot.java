package modele;

/**
 * 
 * @author DUBOSQ
 */
public class Lot {
    private int id;
    private int prixDepart;
    private Cheval unCheval;
    private Vente uneVente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(int prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Cheval getUnCheval() {
        return unCheval;
    }

    public void setUnCheval(Cheval unCheval) {
        this.unCheval = unCheval;
    }

    public Vente getUneVente() {
        return uneVente;
    }

    public void setUneVente(Vente uneVente) {
        this.uneVente = uneVente;
    }
    
    
}

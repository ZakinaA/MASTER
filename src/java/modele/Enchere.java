/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author noedu
 */
public class Enchere {
    private int id;
    private int montant;
    private Lot lot;
    private String dateEnchere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public String getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(String dateEnchere) {
        this.dateEnchere = dateEnchere;
    }
}

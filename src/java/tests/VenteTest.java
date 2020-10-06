/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Courriel;
import modele.Vente;

/**
 *
 * @author sio2
 */
public class VenteTest {
    public static void main(String[] args) {
        
        Vente uneVente = new Vente(1, "Vente de l'hiver", "20/08/2000");
        
        Courriel unCourriel = new Courriel(1, "20/08/2000", "Vente1", "CorpsCorps");
        Courriel unCourriel2 = new Courriel(2, "20/08/2000", "Vente1", "CorpsCorps");
        Courriel unCourriel3 = new Courriel(3, "20/08/2000", "Vente1", "CorpsCorps");
        
        uneVente.addUnCourriel(unCourriel);
        uneVente.addUnCourriel(unCourriel2);
        uneVente.addUnCourriel(unCourriel3);
        
        System.out.println("Nb courriel:" + uneVente.getNbCourriel());
        
    }
}

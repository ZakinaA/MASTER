/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.CategVente;
import modele.Client;
import modele.Pays;
import modele.Vente;

/**
 *
 * @author Zakina
 */
public class ClientTest {
    
    public static void main(String[] args) {
        
        Client unClient = new Client(1, "dupont", "luc");
        unClient.setUnPays(new Pays("FRA", "FRANCE"));    
        System.out.println(unClient.toString());
        System.out.println(unClient.getNom() + "  " + unClient.getUnPays().getNom());
        
        CategVente uneCategVente = new CategVente("ETTFR", "ETE");
        CategVente uneCategVente2 = new CategVente("ETTFR1", "ETE");
        CategVente uneCategVente3 = new CategVente("ETTFR2", "ETE");
        
        Vente uneVente1 = new Vente(1, "Vente d'été", "2019");
        Vente uneVente2 = new Vente(2, "Vente d'été2", "2019");
        Vente uneVente3 = new Vente(3, "Vente d'été3", "2012");
        Vente uneVente4 = new Vente(4, "Vente d'hiver", "2018");
        
        uneCategVente.addUneVente(uneVente1);
        uneCategVente.addUneVente(uneVente2);
        uneCategVente.addUneVente(uneVente3);
        uneCategVente.addUneVente(uneVente4);
        
        unClient.addUneCategVente(uneCategVente);
        unClient.addUneCategVente(uneCategVente2);
        
        //System.out.println("Nb categ: " + unClient.getNbCateg());
        System.out.println("Nb de vente en 2019" + unClient.getNbVentes("2019"));
        
        
        
    }
    
}

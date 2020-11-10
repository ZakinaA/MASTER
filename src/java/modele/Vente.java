package modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author DUBOSQ
 */
public class Vente {
    private int id;
    private String nom;
    private String dateDebutVente;
    private Lieu unLieu ;
    private CategVente uneCategVente;
    private ArrayList<Courriel> lesCourriels ;
    private ArrayList<TypeCheval> lesTypesDeChevaux;
    private Vente uneVente;
    private int NbCourriels;
    private String heureVente;

    public Vente() {
    }

    public Vente(int id, String nom, String dateDebutVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
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

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public CategVente getUneCategVente() {
        return uneCategVente;
    }

    public void setUneCategVente(CategVente uneCategVente) {
        this.uneCategVente = uneCategVente;
    }

    public Lieu getUnLieu() {
        return unLieu;
    }

    public void setUnLieu(Lieu unLieu) {
        this.unLieu = unLieu;
    }

    public ArrayList<Courriel> getLesCourriels() {
	return lesCourriels;
    }
    
    public void setLesCourriels(ArrayList<Courriel> lesCourriels) {
	this.lesCourriels = lesCourriels;
    }
    
    public void addUnCourriel(Courriel unCourriel) {
	if(lesCourriels == null) {
            lesCourriels = new ArrayList<Courriel>();
        }
        lesCourriels.add(unCourriel);
    }

    public ArrayList<TypeCheval> getLesTypesDeChevaux() {
        return lesTypesDeChevaux;
    }

    public void setLesTypesDeChevaux(ArrayList<TypeCheval> lesTypesDeChevaux) {
        this.lesTypesDeChevaux = lesTypesDeChevaux;
    }
	
    public void addUnTypeDeCheval(TypeCheval unTypeDeCheval){
        if(lesTypesDeChevaux == null){
            lesTypesDeChevaux = new ArrayList<TypeCheval>();
        }
        lesTypesDeChevaux.add(unTypeDeCheval);
    }

    public Vente getUneVente() {
        return uneVente;
    }

    public void setUneVente(Vente uneVente) {
        this.uneVente = uneVente;
    }
    
    //methode permettant de renvoyer le nb de courriels.
    public int getNbCourriel(){
       NbCourriels = lesCourriels.size();
        return NbCourriels;
    }

    public int getNbCourriels() {
        return NbCourriels;
    }

    public void setNbCourriels(int NbCourriels) {
        this.NbCourriels = NbCourriels;
    }

    public String getHeureVente() {
        return heureVente;
    }

    public void setHeureVente(String heureVente) {
        this.heureVente = heureVente;
    }
    
    public String getTempsRestant (String date) throws ParseException{
        
        //final String gameDate = "2020-11-09 19:45:00";
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRENCH);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        final Date dateOfGame = format.parse(date);
        final long millis = dateOfGame.getTime() - System.currentTimeMillis();
        System.out.println(dateOfGame.getTime() - System.currentTimeMillis());
        
        long heuresSec = TimeUnit.MILLISECONDS.toHours(millis) * 3600;
        long minutesSec = (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))) * 60;
        long secondes = (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        long hmsSec = heuresSec + minutesSec + secondes;
        
        if (hmsSec < 0){
            return "0";
        }
        else{
            String secondeRestantes = Long.toString(hmsSec);
            return secondeRestantes;
        }
        
//        System.out.println("Heures:" + TimeUnit.MILLISECONDS.toHours(millis));
//        System.out.println("Minutes:" + (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))));
//        System.out.println("Secondes:" + (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
//        
//        final String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
//                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
//                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class JeuxOlympique {
    private String lieu;
    private int annee;

    private List<Pays>  lesPays;
    private List<Epreuve> lesEpreuve;
    private List<Sport> lesSports;
    
    public JeuxOlympique(String lieu, int annee) {
        this.lieu = lieu;
        this.annee = annee;
    }
    
    public String getLieu() {
        return lieu;
    }


    public void setLieu(String lieu) {
        this.lieu = lieu;
    }


    public int getAnnee() {
        return annee;
    }


    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void ajouteSport(Sport sport) {
        this.lesSports.add(sport);

    }

    public void ajouteEpreuve(Epreuve epreuve) {
        this.lesEpreuve.add(epreuve);

    }

    public void retireSport(Sport sport) {
        this.lesSports.remove(sport);

    }

    public void retireEpreuve(Epreuve epreuve) {
        this.lesEpreuve.remove(epreuve);

    }

    public void ajoutePays(Pays pays) {
        this.lesPays.add(pays);

    }

    
    public void retirePays(Pays pays) {
        this.lesPays.add(pays);

    }

    public void simulJO() {
        for (Epreuve epreuve : this.lesEpreuve) {
            epreuve.lanceEpreuve();
        }
    }


    /*@return une liste des pays */
    public void classement() {


    }


    @Override
    public String toString() {
        return "les JO de" + this.lieu + "de" + this.annee;
    }



}

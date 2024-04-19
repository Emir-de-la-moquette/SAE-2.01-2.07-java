import java.util.ArrayList;
import java.util.List;


public class JeuxOlympique {
    private String lieu;
    private int annee;
    
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

    public void ajouteSport() {

    }

    public boolean simulJO() {
        return true;
    }


    /*@return une liste des pays */
    public void classement() {

    }


    @Override
    public String toString() {
        return "les JO de" + this.lieu + "de" + this.annee;
    }



}

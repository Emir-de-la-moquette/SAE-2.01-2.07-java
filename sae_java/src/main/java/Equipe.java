import java.util.*;

public class Equipe {

    private int taille;
    private Pays lePays;

    private int nbMedailleOr =0;
    private int nbMedailleArgent =0;
    private int nbMedailleBronze =0;

    private List<Athlete> lesAthletes;
    

    public Equipe(int taille, Pays pays) {
        this.taille = taille;
        this.lePays = pays;
        this.lesAthletes = new ArrayList<>();
    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    
    public int getTaille() {
        return this.taille;
    }

    public Pays getPays() {
        return this.lePays;
    }

    public void ajouteAthletes(Athlete athlete) { // sécurité a revoir
        this.lesAthletes.add(athlete);
    }

    public void retireAthletes(Athlete athlete) { // sécurité a revoir
        this.lesAthletes.remove(athlete);
    }
    
    
    public int getNbMedailleOr() {
        return nbMedailleOr;
    }
    public void setNbMedailleOr(int nbMedailleOr) {
        this.nbMedailleOr = nbMedailleOr;
    }
    public int getNbMedailleArgent() {
        return nbMedailleArgent;
    }
    public void setNbMedailleArgent(int nbMedailleArgent) {
        this.nbMedailleArgent = nbMedailleArgent;
    }
    public int getNbMedailleBronze() {
        return nbMedailleBronze;
    }
    public void setNbMedailleBronze(int nbMedailleBronze) {
        this.nbMedailleBronze = nbMedailleBronze;
    }

    @Override
    public String toString() {
        return "l'équipe du "+ this.lePays;
    }
}  

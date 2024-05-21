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
    public void ajouteMedailleOr() {
        this.nbMedailleOr += 1;
    }
    public int getNbMedailleArgent() {
        return nbMedailleArgent;
    }
    public void ajouteMedailleArgent() {
        this.nbMedailleArgent += 1;
    }
    public int getNbMedailleBronze() {
        return nbMedailleBronze;
    }
    public void ajouteMedailleBronze() {
        this.nbMedailleBronze += 1;
    }

    @Override
    public String toString() {
        return "l'équipe de "+ this.lePays;
    }
}  

import java.util.*;
import java.util.Objects;

public class Equipe implements Participation<Athlete>{

    private int taille;
    private Pays lePays;

    private int nbMedailleOr =0;
    private int nbMedailleArgent =0;
    private int nbMedailleBronze =0;

    private List<Athlete> lesAthletes;

    private char sexeEquipe;
    

    public Equipe(int taille, Pays pays, char sexeEquipe) {
        this.sexeEquipe = sexeEquipe;
        this.taille = taille;
        this.lePays = pays;
        this.lesAthletes = new ArrayList<>();
    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    public boolean estALaBonneTaille(){
        if (this.lesAthletes.size() == this.taille)
            return true;
        else{return false;}
    }


    public int getTaille() {
        return this.taille;
    }

    public Pays getPays() {
        return this.lePays;
    }

    public void participer(Athlete athlete) {
        if(athlete.getSexeA() == this.sexeEquipe) this.lesAthletes.add(athlete);
        else System.err.println("Pas le bon sexe, transitionne stp");
        
    }

    public void retirer(Athlete athlete) throws NoSuchElementException{ // pensez à try catch
        this.lesAthletes.remove(athlete);
    }
    
    public char getSexeEquipe(){
        return sexeEquipe;
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
        return 
        "l'équipe de "+ this.lePays;
        //+ " possède medaille d'or : " + this.getNbMedailleOr()
        //+ " possède medaille d'argent : " + this.getNbMedailleArgent()
        //+ " possède medaille de bronze : " + this.getNbMedailleBronze();
    }
    
}  

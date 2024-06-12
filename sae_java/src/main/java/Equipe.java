import java.util.*;

public class Equipe implements Participation<Athlete> {

    private static List<Integer> lesID;

    private int taille;

    private int nbMedailleOr = 0;
    private int nbMedailleArgent = 0;
    private int nbMedailleBronze = 0;
    private int IDequipe;

    private List<Athlete> lesAthletes;

    private char sexeEquipe;

    public Equipe(int id, int taille) {
        this.taille = taille;
        this.IDequipe = id;
        this.lesAthletes = new ArrayList<>();
    }

    public void setID(int id) {
        this.IDequipe = id;
    }

    public int getID() {
        return IDequipe;
    }

    public static int getNewId() {
        int i = 20000;
        while (lesID.contains(i))
            i++;
        System.out.println("nouvel ID : " + i);
        return i;
    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    public boolean estALaBonneTaille() {
        if (this.lesAthletes.size() == this.taille)
            return true;
        else {
            return false;
        }
    }

    public int getTaille() {
        return this.taille;
    }

    public void participer(Athlete athlete) {
        if (athlete.getSexeA() == this.sexeEquipe)
            this.lesAthletes.add(athlete);
        else
            System.err.println("Pas le bon sexe, transitionne stp");
    }

    public void retirer(Athlete athlete) throws NoSuchElementException { // pensez à try catch
        this.lesAthletes.remove(athlete);
    }

    public char getSexeEquipe() {
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
        return "l'équipe numéro " + this.getID()
                + " possède medaille d'or : " + this.getNbMedailleOr()
                + " possède medaille d'argent : " + this.getNbMedailleArgent()
                + " possède medaille de bronze : " + this.getNbMedailleBronze();
    }

}

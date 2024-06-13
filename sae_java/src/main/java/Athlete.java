import java.util.List;
import java.util.ArrayList;

public class Athlete {

    private static List<Integer> lesID = new ArrayList<>();

    private String nomA;
    private String prenomA;
    private char sexeA;
    private int agilite;
    private int endurance;
    private int force;
    private int IDathlete;

    public Athlete(int id, String nomA, String prenomA, char sexeA, int agilite, int endurance, int force)
            throws IDdejaExistantException {
        if (lesID.contains(id))
            throw new IDdejaExistantException("cet id est déjà utilisé");
        lesID.add(id);
        this.nomA = nomA;
        this.prenomA = prenomA;
        this.sexeA = sexeA;
        this.agilite = agilite;
        this.endurance = endurance;
        this.force = force;
        this.IDathlete = id;
    }

    public int getID() {
        return IDathlete;
    }

    public static int getNewId() {
        int i = 20000;
        while (lesID.contains(i))
            i++;
        System.out.println("nouvel ID : " + i);
        return i;
    }

    public String getNomA() {
        return nomA;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public String getPrenomA() {
        return prenomA;
    }

    public void setPrenomA(String prenomA) {
        this.prenomA = prenomA;
    }

    public char getSexeA() {
        return sexeA;
    }

    public void setSexeA(char sexeA) {
        this.sexeA = sexeA;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override

    public String toString() {
        return this.nomA + " " + this.prenomA + " est un "+((this.sexeA == 'H')? "Homme" : "Femme")+" avec : " + this.agilite + " d'agilité, "
                    + this.endurance + " d'endurance, et " + this.force + " de force.";
    }
}

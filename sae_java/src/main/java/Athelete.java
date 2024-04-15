public class Athelte {

    private String nomA;
    private String prenomA;
    private String sexeA;
    private int agilite;
    private int endurance;
    private int force;

    public Athlete( String nomA, String prenomA, String sexeA, int agilite, int endurance, int force){
        this.nomA = nomA;
        this.prenomA = prenomA;
        this.sexeA = sexeA;
        this.agilite = agilite;
        this.endurance = endurance;
        this.force = force;
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

    public String getSexeA() {
        return sexeA;
    }

    public void setSexeA(String sexeA) {
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
    public String toString(){
        if (this.sexeA == "H"){
            return this.nomA + this.prenomA + " est un homme avec : " + this.agilite + " d'agilité, " + this.endurance + " d'endurance, et " + this.force + " de force.";
        }
        else {
            return this.nomA + this.prenomA + " est une femme avec : " + this.agilite + " d'agilité, " + this.endurance + " d'endurance, et " + this.force + " de force.";
        }
    }

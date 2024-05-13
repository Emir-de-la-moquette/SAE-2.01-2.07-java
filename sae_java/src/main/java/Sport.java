public class Sport {
    private String nomSport;
    private int nbJoueur;
    private Double valeurAgilite;
    private Double valeurEndurance;
    private Double valeurForce;
    private Double moyenneAthletique;
    private int nbdePointmax;

    public Sport(String nomSport, int nbJoueur, Double valeurAgilite, Double valeurEndurance, Double valeurForce, Double moyenneAthletique, int nbdePointmax){
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;
        this.moyenneAthletique = moyenneAthletique;
        this.nbdePointmax = nbdePointmax;
    }

    public int getpoint() {
        return RandomNumberInRange.getRandomInt(1, this.nbdePointmax);
    }
    
    public Double getMoyenneAthletique() {
        return this.moyenneAthletique;
    }

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public Double getValeurAgilite() {
        return valeurAgilite;
    }

    public void setValeurAgilite(Double valeurAgilite) {
        this.valeurAgilite = valeurAgilite;
    }

    public Double getValeurEndurance() {
        return valeurEndurance;
    }

    public void setValeurEndurance(Double valeurEndurance) {
        this.valeurEndurance = valeurEndurance;
    }

    public Double getValeurForce() {
        return valeurForce;
    }

    public void setValeurForce(Double valeurForce) {
        this.valeurForce = valeurForce;
    }


    public boolean hasReglePersonalisee(){
        return false ; // à definir
    }


    public boolean conditionVictoire(Double a, Double b){
        return false; //à définir
    }

    @Override
    public String toString(){
        /*String textAgilite;
        switch (this.valeurAgilite) {
            case valeurAgilite<0.33:
                textAgilite= "très peu demandant en agilite";
                break;
            case valeurAgilite>0.33 && valeurAgilite<0.66:
                textAgilite = "assez demandant en agilite";
                break;
            default:
                text = "ne demande pas d'agilite";
                break;*/
                return "a";

    }
}


public class Sport {
    private String nomSport;
    private int nbJoueur;
    private Double valeurAgilite;
    private Double valeurEndurance;
    private Double valeurForce;
    private Double moyenneAthletique;

    public Sport(String nomSport, int nbJoueur, Double valeurAgilite, Double valeurEndurance, Double valeurForce, Double moyenneAthletique){
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;
        this.moyenneAthletique = moyenneAthletique;
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


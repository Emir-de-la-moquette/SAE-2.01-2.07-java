public class Sport {
    private String nomSport;
    private int nbJoueur;
    private Double valeurAgilite;
    private Double valeurEndurance;
    private Double valeurForce;
    private Double moyenneAthletique;
    private Double recordMondial;
    private int nbdePointmax;

    // REGLE PERSONALISE
    private boolean hasregle;
    private int nbPointVictoireTotale;
    private int nbPointMiniPourVictoire;
    private int ecartDePointMini;

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


    public boolean reglePersonalisee(){
        return hasregle ; // à definir
    }


    public boolean conditionVictoire(Double a, Double b){
        return false; //à définir (voir attributs)
    }

    public void setRegle(int nbPointVictoireTotale, int nbPointMiniPourVictoire, int ecartDePointMini){
        
    }


    @Override
    public String toString(){
        String textAgilite;
        String textForce;
        String textEndurance;
        
            if (valeurAgilite<0.33)
                textAgilite= " est très demandant en agilite";
                
            else if(valeurAgilite<0.66)
                textAgilite = " est assez demandant en agilite";
        
            else textAgilite = " ne demande pas d'agilite";


            if (valeurForce<0.33)
                textForce= " est très demandant en force";
                
            else if(valeurForce<0.66)
                textForce = " est assez demandant en force";
        
            else textForce = " ne demande pas de force";


            if (valeurEndurance<0.33)
                textEndurance= " est très demandante en endurance";
                
            else if(valeurEndurance<0.66)
                textEndurance = " est assez demandant en endurance";
        
            else textEndurance = " ne demande pas d'endurence";

            return "la catégorie " + nomSport + textAgilite + " , aussi elle " + textEndurance + " , et enfin elle " + textForce; 

    }
}


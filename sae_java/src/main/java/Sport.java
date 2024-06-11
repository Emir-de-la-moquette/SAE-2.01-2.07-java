public class Sport {
    private String nomSport;
    private int nbJoueur;
    private Double valeurAgilite;
    private Double valeurEndurance;
    private Double valeurForce;
    private int nbdePointmax;

    // REGLE PERSONALISE
    private boolean hasregle;
    private Integer nbPointVictoireTotale;
    private Integer nbPointMiniPourVictoire;
    private Integer ecartDePointMini;


    //Sport sans points
    public Sport(String nomSport, int nbJoueur, Double valeurAgilite, Double valeurEndurance, Double valeurForce){
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;
    }

    //Sport avec points
    public Sport(String nomSport, int nbJoueur, Double valeurAgilite, Double valeurEndurance, Double valeurForce, int nbdePointmax){
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;
        this.nbdePointmax = nbdePointmax;
    }

    public int getpoint() {
        return RandomNumberInRange.getRandomInt(1, this.nbdePointmax);
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
        return hasregle ; 
    }


    public boolean conditionVictoire(Double a, Double b){
        if((a>=nbPointVictoireTotale || b>=nbPointVictoireTotale) && nbPointVictoireTotale != null)
            return true;
        if(ecartDePointMini != null)
        {
            if(a>=nbPointMiniPourVictoire && (a-b)>=ecartDePointMini )
                return true;
            if(b>=nbPointMiniPourVictoire && (b-a)>=ecartDePointMini)
                return true;
        }
        return false;
    }

    public void setRegle(int nbPointVictoireTotale, int nbPointMiniPourVictoire, int ecartDePointMini){
        this.nbPointVictoireTotale = nbPointVictoireTotale;
        this.nbPointMiniPourVictoire = nbPointMiniPourVictoire;
        this.ecartDePointMini = ecartDePointMini;
        this.hasregle = true;
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


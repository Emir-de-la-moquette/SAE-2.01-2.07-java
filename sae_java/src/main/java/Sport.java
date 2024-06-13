import java.util.ArrayList;
import java.util.List;

public class Sport {

    protected static List<String> lesID = new ArrayList<>();

    private String nomSport;
    private int nbJoueur;
    private Double valeurAgilite;
    private Double valeurEndurance;
    private Double valeurForce;
    // private Double moyenneAthletique = 1.0;
    // private Double recordMondial = 1.0;

    private int nbdePointmax;

    // REGLE PERSONALISE
    protected boolean hasregle;
    protected Integer nbPointVictoireTotale;
    protected Integer nbPointMiniPourVictoire;
    protected Integer ecartDePointMini;

    // Sport sans points
    public Sport(String nomSport, int nbJoueur, Double valeurAgilite, Double valeurEndurance, Double valeurForce)
            throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;
    }

    // Sport avec points
    public Sport(String nomSport, int nbJoueur, Double valeurAgilite, Double valeurEndurance, Double valeurForce,
            int nbdePointmax) throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
        this.nbJoueur = nbJoueur;
        this.valeurAgilite = valeurAgilite;
        this.valeurEndurance = valeurEndurance;
        this.valeurForce = valeurForce;
        this.nbdePointmax = nbdePointmax;
    }

    /*
    *retourne le nombre de point max d'un sport
    *@return int nbdePointmax
    */
    public int getpoint() {
        return RandomNumberInRange.getRandomInt(1, this.nbdePointmax);
    }

    /*
    *retourne le nom du sport
    *@return String nomSport
    */
    public String getNomSport() {
        return nomSport;
    }

    /*
    *modifie le nom du sport
    *@param String nomSport
    */
    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    /*
    *retourne le nombre de joueur pour un sport
    *@return int nbJoueur
    */
    public int getNbJoueur() {
        return nbJoueur;
    }

    /*
    *modifie le nombre de joueur pour un sport
    *@param int nbJoueur
    */
    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    /*
    *retourne la valeur Agilite pour un sport
    *@return Double valeurAgilite
    */
    public Double getValeurAgilite() {
        return valeurAgilite;
    }

     /*
    *modifie la valeur Agilite pour un sport
    *@param Double valeurAgilite
    */
    public void setValeurAgilite(Double valeurAgilite) {
        this.valeurAgilite = valeurAgilite;
    }

    /*
    *retourne la valeur Endurance pour un sport
    *@return Double valeurEndurance
    */
    public Double getValeurEndurance() {
        return valeurEndurance;
    }

    /*
    *modifie la valeur Endurance pour un sport
    *@param Double valeurEndurance
    */
    public void setValeurEndurance(Double valeurEndurance) {
        this.valeurEndurance = valeurEndurance;
    }

    /*
    *retourne la valeur Force pour un sport
    *@return Double valeurForce
    */
    public Double getValeurForce() {
        return valeurForce;
    }

    /*
    *modifie la valeur Force pour un sport
    *@param Double valeurForce
    */
    public void setValeurForce(Double valeurForce) {
        this.valeurForce = valeurForce;
    }

    /*
    *retourne vrai ou faux si lees regles special son respecter pour un sport
    *@return boolean hasregle
    */
    public boolean hasReglePersonalisee() {
        return hasregle;
    }

    /*
    *retourne vrai ou faux pour la conditionVictoire si elle est respecter pour un sport
    *@param Double a, Double b
    *@return boolean si la condition de victoire est valider
    */
    public boolean conditionVictoire(Double a, Double b) {
        if ((a >= nbPointVictoireTotale || b >= nbPointVictoireTotale) && nbPointVictoireTotale != null)
            return true;
        if (ecartDePointMini != null) {
            if (a >= nbPointMiniPourVictoire && (a - b) >= ecartDePointMini)
                return true;
            if (b >= nbPointMiniPourVictoire && (b - a) >= ecartDePointMini)
                return true;
        }
        return false;
    }

    /*
    *modifie les regle pour un sport
    *@param int nbPointVictoireTotale int nbPointMiniPourVictoire int ecartDePointMini
    */
    public void setRegle(int nbPointVictoireTotale, int nbPointMiniPourVictoire, int ecartDePointMini) {
        this.nbPointVictoireTotale = nbPointVictoireTotale;
        this.nbPointMiniPourVictoire = nbPointMiniPourVictoire;
        this.ecartDePointMini = ecartDePointMini;
        this.hasregle = true;
    }

    @Override
    public String toString() {
        String textAgilite;
        String textForce;
        String textEndurance;

        if (valeurAgilite < 0.33)
            textAgilite = " est très demandant en agilite";

        else if (valeurAgilite < 0.66)
            textAgilite = " est assez demandant en agilite";

        else
            textAgilite = " ne demande pas d'agilite";

        if (valeurForce < 0.33)
            textForce = " est très demandant en force";

        else if (valeurForce < 0.66)
            textForce = " est assez demandant en force";

        else
            textForce = " ne demande pas de force";

        if (valeurEndurance < 0.33)
            textEndurance = " est très demandante en endurance";

        else if (valeurEndurance < 0.66)
            textEndurance = " est assez demandant en endurance";

        else
            textEndurance = " ne demande pas d'endurence";

        return "la catégorie " + nomSport + textAgilite + " , aussi elle " + textEndurance + " , et enfin elle "
                + textForce;

    }
}

import java.util.ArrayList;
import java.util.List;

public class Sport {

    protected static List<String> lesID = new ArrayList<>();

    private String nomSport;
    private int nbdePointmax;



    // Sport sans points
    public Sport(String nomSport)
            throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
    }

    // Sport avec points
    public Sport(String nomSport, int nbdePointmax) throws IDdejaExistantException {
        if (lesID.contains(nomSport))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomSport);
        this.nomSport = nomSport;
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
    *retourne le nombre de point max d'un sport
    *@return int nbdePointmax
    */
    public int getNbdePointmax() {
        return nbdePointmax;
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





    @Override
    public String toString() {
        return "le sport " + nomSport;

    }
}

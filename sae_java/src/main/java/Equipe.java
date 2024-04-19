public class Equipe {

    private int taille;


    private int nbMedailleOr =0;
    private int nbMedailleArgent =0;
    private int nbMedailleBronze =0;
    
    public Equipe(int taille) {
        this.taille = taille;
    }
    
    public int getNbMedailleOr() {
        return nbMedailleOr;
    }
    public void setNbMedailleOr(int nbMedailleOr) {
        this.nbMedailleOr = nbMedailleOr;
    }
    public int getNbMedailleArgent() {
        return nbMedailleArgent;
    }
    public void setNbMedailleArgent(int nbMedailleArgent) {
        this.nbMedailleArgent = nbMedailleArgent;
    }
    public int getNbMedailleBronze() {
        return nbMedailleBronze;
    }
    public void setNbMedailleBronze(int nbMedailleBronze) {
        this.nbMedailleBronze = nbMedailleBronze;
    }
}  

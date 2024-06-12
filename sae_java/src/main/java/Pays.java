
import java.util.ArrayList;
import java.util.List;

public class Pays implements Participation<Equipe> {

    private static List<String> lesID = new ArrayList<>();

    private String Nompays;
    private List<Equipe> lesEquipes;

    public Pays(String nomPays) throws IDdejaExistantException {
        if (lesID.contains(nomPays))
            throw new IDdejaExistantException("ce nom est déjà utilisé");
        lesID.add(nomPays);
        this.Nompays = nomPays;
        this.lesEquipes = new ArrayList<>();
    }

    public List<Equipe> afficheLesEquipes() {
        return this.lesEquipes;
    }

    @Override
    public void participer(Equipe equip) {
        lesEquipes.add(equip);

    }

    @Override
    public void retirer(Equipe equip) {
        lesEquipes.remove(equip);
    }

    public String getNompays() {
        return Nompays;
    }

    public void setNompays(String nompays) {
        Nompays = nompays;
    }

    public int getmedailles_or() {
        int nbmedaille_or = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille_or += groupes.getNbMedailleOr();
        }
        return nbmedaille_or;
    }

    public int getmedailles_argent() {
        int nbmedaille_Argent = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille_Argent += groupes.getNbMedailleArgent();
        }
        return nbmedaille_Argent;
    }

    public int getmedailles_bronze() {
        int nbmedaille_bronze = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille_bronze += groupes.getNbMedailleBronze();
        }
        return nbmedaille_bronze;
    }

    public int getmedailles_total() {
        int nbmedaille = 0;
        for (Equipe groupes : this.lesEquipes) {
            nbmedaille += groupes.getNbMedailleBronze();
            nbmedaille += groupes.getNbMedailleArgent();
            nbmedaille += groupes.getNbMedailleOr();
        }
        return nbmedaille;
    }

    public String toString()  {
        return this.Nompays;
        //+ " possede " 
        //+ String.valueOf(this.getmedailles_bronze()) +" de medailles bronze , "
        //+ String.valueOf(this.getmedailles_argent()) + " de medailles argent et " 
        //+ String.valueOf(this.getmedailles_or()) + " de medailles d'Or" ;
    }

}

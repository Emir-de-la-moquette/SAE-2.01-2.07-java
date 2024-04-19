
import java.util.List;


public class Pays {
    private String Nompays;

    private List<Athlete> lesathelete;
    private List<Equipe> lesEquipes;

    public Pays(String NomPays) {
        this.Nompays = NomPays;
    }

    public boolean ajouterAthelete(Athlete athelete){
        return lesathelete.add(athelete);
        
    }
    
    public boolean retirerAthelete(Athlete athelete){
        return lesathelete.remove(athelete);
    }

    public String getNompays() {
        return Nompays;
    }

    public void setNompays(String nompays) {
        Nompays = nompays;
    }



    public int getmedailles_or(){
        int nbmedaille_or=0;
        for (Equipe groupes : lesEquipes){
            nbmedaille_or += groupes.getNbMedailleOr();
        }
        return nbmedaille_or;
    }

    public int getmedailles_argent(){
        int nbmedaille_Argent=0;
        for (Equipe groupes : lesEquipes){
            nbmedaille_Argent += groupes.getNbMedailleArgent();
    }
    return nbmedaille_Argent;
    }
    
    public int getmedailles_bronze(){
        int nbmedaille_bronze=0;
        for (Equipe groupes : lesEquipes){
            nbmedaille_bronze += groupes.getNbMedailleBronze();
    }
    return nbmedaille_bronze;
    }

    public String toString()  {
        return this.Nompays;
    }

}

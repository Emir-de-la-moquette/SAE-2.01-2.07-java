
import java.util.List;


public class Pays {
    private String pays;
    private List<Athelete> lesathelete;
    private List<Equipes> lesEquipes;

    public Pays(String pays) {
        this.pays = pays;
    }

    public boolean ajouterAthelete(Athelete athelete){
        return lesathelete.add(athelete);
        
    }
    
    public boolean retirerAthelete(Athelete athelete){
        return lesathelete.remove(athelete);
    }

    public String getPays() {
        return pays;
            somme += getmedailles_or() +getmedailles_argent() + getmedailles_bronze();
        return somme ;
    }

    

    public int getmedailles_or(){
        int nbmedaille_or=0;
        for (Equipes groupes : lesEquipes){
            nbmedaille_or += groupes.getMedaillesOr();
        }
        return nbmedaille_or;
    }

    public int getmedailles_argent(){
        int nbmedaille_Argent=0;
        for (Equipes groupes : lesEquipes){
            nbmedaille_Argent += groupes.getMedaillesArgent();
    }
    return nbmedaille_Argent;
    }
    
    public int getmedailles_bronze(){
        int nbmedaille_bronze=0;
        for (Equipes groupes : lesEquipes){
            nbmedaille_bronze += groupes.getMedaillesBronze();
    }
    return nbmedaille_bronze;
    }

    public String toString()  {
        return this.pays + "a" ;
    }

}

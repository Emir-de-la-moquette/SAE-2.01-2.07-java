
import java.util.ArrayList;
import java.util.List;


public class Pays {
    private String Nompays;

    private List<Equipe> lesEquipes;



    public Pays(String NomPays) {
        this.Nompays = NomPays;
        this.lesEquipes = new ArrayList<>(); 
    }

    public List<Equipe> afficheLesEquipes() {
        return this.lesEquipes;
    }

    public boolean ajouterEquipe(Equipe equip){
        return lesEquipes.add(equip);
        
    }
    
    public boolean retirerEquipe(Equipe equip){
        return lesEquipes.remove(equip);
    }

    public String getNompays() {
        return Nompays;
    }

    public void setNompays(String nompays) {
        Nompays = nompays;
    }



    public int getmedailles_or(){
        int nbmedaille_or=0;
        for (Equipe groupes : this.lesEquipes){
            nbmedaille_or += groupes.getNbMedailleOr();
        }
        return nbmedaille_or;
    }

    public int getmedailles_argent(){
        int nbmedaille_Argent=0;
        for (Equipe groupes : this.lesEquipes){
            nbmedaille_Argent += groupes.getNbMedailleArgent();
    }
    return nbmedaille_Argent;
    }
    
    public int getmedailles_bronze(){
        int nbmedaille_bronze=0;
        for (Equipe groupes : this.lesEquipes){
            nbmedaille_bronze += groupes.getNbMedailleBronze();
    }
    return nbmedaille_bronze;
    }

    public String toString()  {
        return this.Nompays; //+ " possede" + String.valueOf(this.getmedailles_bronze()) +" de medailles bronze , " + String.valueOf(this.getmedailles_argent()) + " de medailles argent et " + String.valueOf(this.getmedailles_or()) + "de medailles argent" ;
    }

}

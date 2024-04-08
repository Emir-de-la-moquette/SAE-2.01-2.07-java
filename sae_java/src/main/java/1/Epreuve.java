import java.util.ArrayList;
import java.util.List;

public class Epreuve {

    private String nomEpreuve;
    private String sexeEpreuve;
    private String categorieEpreuve;
    private String typeEpreuve;

    private List<Pair<Equipe, Integer>> scoreDesEquipes;

    private List<Equipe> lesEquipes;
    private Sport leSport;

    

    public Epreuve(String nomEpreuve, String sexeEpreuve, String categorieEpreuve, String typeEpreuve, Sport sport) {
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;

        this.sport = sport;

        this.scoreDesEquipes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();

    }

    public String getNomEpreuve() {
        return nomEpreuve;
    }

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    public String getSexeEpreuve() {
        return sexeEpreuve;
    }

    public void setSexeEpreuve(String sexeEpreuve) {
        this.sexeEpreuve = sexeEpreuve;
    }

    public String getCategorieEpreuve() {
        return categorieEpreuve;
    }

    public void setCategorieEpreuve(String categorieEpreuve) {
        this.categorieEpreuve = categorieEpreuve;
    }

    public String getTypeEpreuve() {
        return typeEpreuve;
    }

    public void setTypeEpreuve(String typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }


    public Sport getLesSports() {
        return lesSports;
    }

    public void setLesSports(Sport lesSports) {
        this.lesSports = lesSports;
    }
    
    // @param : une équipe
    // fait participer une équipe à l'épreuve
    public void participer(Equipe equipe) {
        if (equipe.size() == leSport.getNomSport())
            this.lesEquipes.add(equipe);

    }

    // @param : une équipe
    // retire une équipe à l'épreuve
    public void retirer(Equipe equipe) {
        this.lesEquipes.remove(equipe);

    }

    // affiche les équipes participant à l'épreuve       
    public List<Equipe> AfficheLesEquipes() {
        return lesEquipes;
    }


    public void lanceEpreuve() {


        typeEpreuve = getTypeEpreuve();

        if(typeEpreuve == "Duel") {

        }

        if(typeEpreuve == "Score") {
            
        }


    }

    @Override
    public String ToString() {
        return getCategorieEpreuve() + getNomEpreuve() + getSexeEpreuve();
    }
}

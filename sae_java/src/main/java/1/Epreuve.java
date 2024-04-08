import java.util.ArrayList;
import java.util.List;

public class Epreuve {

    private String nomEpreuve;
    private String sexeEpreuve;
    private String categorieEpreuve;
    private String typeEpreuve;
    // private  scoreEquipes

    private List<Equipe> lesEquipes;

    
    
    public Epreuve(String nomEpreuve, String sexeEpreuve, String categorieEpreuve, String typeEpreuve) {
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;
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
    
}

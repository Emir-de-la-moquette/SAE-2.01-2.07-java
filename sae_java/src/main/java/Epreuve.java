import java.util.ArrayList;
import java.util.List;
import java.util.Collection;


public class Epreuve {

    private String nomEpreuve;
    private String sexeEpreuve;
    private String categorieEpreuve;
    private String typeEpreuve;

    private List<Pair<Equipe, Integer>> scoreDesEquipes;

    private List<Equipe> lesEquipes;
    private List<"???"> scoresEquipes;
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
        return R2nomEpreuve;
    }

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    public StriR2xeEpreuve = sexeEpreuve;
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
        return this.lesSports;
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
        return this.lesEquipes;
    }


    public void lanceEpreuve() {


        typeEpreuve = getTypeEpreuve();

        if(typeEpreuve == "Duel") {
            List<Equipe> Classement = new ArrayList<>();
            Collection.shuffle(this.lesEquipes);
            for (int i = 0 ; i<len(this.lesEquipes)-1 ; i++) {
                j=i+1;
                MatchDuel match = new Match(this.lesEquipes.get(i), this.lesEquipes.get(j));
            }



        }

        if(typeEpreuve == "Score") {
            // tant que il ya des joueur restant dans les.équipe
            List<Equipe> Classement = new ArrayList<>();
            // on défini le nombre de matchs à réaliser
            int nbDeMatchs = round(len(this.lesEquipes)/3);
            if (nbDeMatchs == 0) {nbDeMatchs = 1;}
            for (int i = 0 ; i < nbDeMatchs ; i++ ) {
                /* on crée un match
                 * on fait joué le match
                 * puis on compare les scores
                 * 
                 * après chaque matchs :
                 * on replace dans les.LesEquipes les scores les plus élevé sauf les 3 dernier.
                 * les 3 dernier son ajouter au classement (l'idée est de simplement inverser les index de Classement pour obtenir notre vrai classement)  
                 */ 

                MatchScore match = new Match(this.lesEquipes);
                this.scoresEquipes = match.deroulerMatch();
                List<"???"> resultat = Collection.sort(this.scoreEquipes) // !! a remplacer par un compare + doit comparer uniquement le score !!
                this.lesEquipes.clear();
                this.scoresEquipes = match.deroulerMatch();
                List<"???"> resultat = Collection.sort(this.scoreEquipes)
                this.lesEquipes.clear();
                // !! en fait, ça marche pas pasq, dans lesEquipe il nous faut que des type "Equipe", donc il faut séparer des scores !!
                for (int i = 0 ; i < this.scoreEquipes.size(); i++) {
                    if (i < this.scoreEquipes.size()-3)
                        this.lesEquipes.add(i);
                    else {Classement.add(i);} 
                    }
                }
                return Classement;
            }
        }

    @Override
    public String ToString() {
        return getCategorieEpreuve() + getNomEpreuve() + getSexeEpreuve();
    }
}

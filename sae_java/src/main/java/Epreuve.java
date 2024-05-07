import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Math;



public class Epreuve {

    private String nomEpreuve;
    private String sexeEpreuve;


    private String categorieEpreuve;
    private String typeEpreuve;

    private List<Equipe> lesEquipes;
    //private List<Match> scoresEquipes;
    private Sport leSport;

    

    public Epreuve(String nomEpreuve, String sexeEpreuve, String categorieEpreuve, String typeEpreuve, Sport sport) {
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;

        this.leSport = sport;

        //this.scoresEquipes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();

    }

    public String getSexeEpreuve() {
        return sexeEpreuve;
    }

    public String getNomEpreuve() {
        return this.nomEpreuve;
    }

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
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


    public Sport getLeSports() {
        return this.leSport;
    }

    public void setLeSports(Sport lesSports) {
        this.leSport = lesSports;
    }
    
    // @param : une équipe
    // fait participer une équipe à l'épreuve
    public void participer(Equipe equipe) {
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


    public List<Equipe> reverse(List<Equipe> Classement){
        for (int k = 0, j = Classement.size() - 1; k < j; k++) 
        {
            Classement.add(k, Classement.remove(j));
        }
        return Classement;
        
    }

    public List<Equipe> lanceEpreuve() {
        List<Equipe> Classement = new ArrayList<>();

        /*if(typeEpreuve == "Duel") {
            List<Equipe> Classement = new ArrayList<>();
            Collection.shuffle(this.lesEquipes);
            for (int i = 0 ; i<len(this.lesEquipes)-1 ; i++) {
                j=i+1;
                MatchDuel match = new Match(this.lesEquipes.get(i), this.lesEquipes.get(j));
            }



        }*/

        if(typeEpreuve == "Score") {
            System.out.println(this.lesEquipes);

            // tant que il ya des joueur restant dans les.équipe
            List<MatchScore> scoresEquipes = new ArrayList<>();
            // on défini le nombre de matchs à réaliser
            int nbDeMatchs = Math.round((this.lesEquipes.size())/3);
            System.out.println(nbDeMatchs);
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
                for (int j = 0 ; j < this.lesEquipes.size() ; j++){
                    MatchScore match = new MatchScore(this.leSport ,this.lesEquipes.get(j));
                    match.deroulerMatch();
                    scoresEquipes.add(match);

                    System.out.println(scoresEquipes+"\n\n");
                    System.out.println(lesEquipes.size()+"\n");
                }
                Comparator<MatchScore> compare = new CompareMatchScore();
                Collections.sort(scoresEquipes, compare); // !! a remplacer par un compare + doit comparer uniquement le score !!
                this.lesEquipes.clear();

                

                for (int posMatch = 0 ; posMatch < scoresEquipes.size(); posMatch++) {
                    if (posMatch < scoresEquipes.size()-3)
                        this.lesEquipes.add(scoresEquipes.get(posMatch).getEquipe());
                        if (i-1 == nbDeMatchs) {
                            Classement.add(this.lesEquipes.get(posMatch));
                        }
                    else {Classement.add(scoresEquipes.get(posMatch).getEquipe());}

                    System.out.println(reverse(Classement)+"\n\n\n");
                    System.out.println(scoresEquipes.size()+"\n\n");
                    

                }
            }
                return reverse(Classement);
        }

        else {return Classement;}
    }

    @Override
    public String toString() {
        return this.categorieEpreuve + " " + this.nomEpreuve + " " + this.sexeEpreuve;
    }
}

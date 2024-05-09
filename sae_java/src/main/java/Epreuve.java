import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Math;
import java.lang.reflect.Array;
import java.util.HashMap;



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

        if(typeEpreuve == "Duel") {
            boolean resteDesMatch=true;
            Collections.shuffle(this.lesEquipes);
            HashMap<Integer, List<Equipe>> pallierEquipe = new HashMap<Integer, List<Equipe>>();
            HashMap<Integer, List<MatchDuel>> pallierMatch = new HashMap<Integer, List<MatchDuel>>();
            pallierEquipe.put(0, this.lesEquipes);
            while (resteDesMatch){
                for (Map.Entry<Integer, List<Equipe>> entry : pallierEquipe.entrySet()) {
                    Integer cleEqip = entry.getKey();
                    List<Equipe> valeursEqip = entry.getValue();                                                       // CREE LES MATCHDUEL
                    if (valeursEqip.size()!=0){
                        List<MatchDuel> listematchs = new ArrayList<>();
                        for (int i=0 ; i<valeursEqip.size() ; i+=2) {                          
                            if(valeursEqip.size()%2==0){
                                MatchDuel match = new MatchDuel(this.leSport, valeursEqip.get(i), valeursEqip.get(i+1));
                                listematchs.add(match);
                            } else { 
                                if(valeursEqip.size() != i+1){
                                MatchDuel match = new MatchDuel(this.leSport, valeursEqip.get(i), valeursEqip.get(i+1));
                                listematchs.add(match);
                                }
                            }         
                        }
                        pallierMatch.put(cleEqip,listematchs);
                    }    
                }
                pallierEquipe.clear();


                List<Integer> clePallierEquipe = new ArrayList<>(pallierEquipe.keySet());
                Collections.sort(clePallierEquipe);

                
                for (Map.Entry<Integer, List<MatchDuel>> entryMatch : pallierMatch.entrySet()) {
                    Integer cleMatch = entryMatch.getKey();
                    List<MatchDuel> valeursMatch = entryMatch.getValue();
                    if (valeursMatch.size()!=0){                                                           // MODIFIE LE PALLIER DES EQUIPE EN FONCTION DES MATCH
                        List<Equipe> equipe = new ArrayList<>();
                        for (MatchDuel resMatch : valeursMatch) {
                            List<Equipe> listeMatchDessus = new ArrayList<>();
                            List<Equipe> listeMatchDessous = new ArrayList<>();
                            if (resMatch.getScoreEquipe1() < resMatch.getScoreEquipe2()){

                                listeMatchDessous.add(resMatch.getEquipe1()); // a finir

                            }


                        }
                    }

                }
                resteDesMatch=false;
                for (Integer cle : clePallierEquipe){                                                          // VERIFIE SI LA BOUCLE EST FINI ET CREE LE CLASSEMENT
                    List<Equipe> listeEquipe = pallierEquipe.get(cle);
                    for (Equipe equipe : listeEquipe){
                        if(listeEquipe.size() == 1){
                            Classement.add(equipe);
                        }
                        else {resteDesMatch=true;}
                    }
                }
                if (resteDesMatch=true)
                    Classement.clear();
                    
            }
            Classement.get(1).ajouteMedailleOr();
            Classement.get(2).ajouteMedailleArgent();
            Classement.get(3).ajouteMedailleBronze();
            return Classement;
        }
                


        if(typeEpreuve == "Score") {
            //System.out.println(this.lesEquipes);

            // tant que il ya des joueur restant dans les.équipe
            List<MatchScore> scoresEquipes = new ArrayList<>();
            // on défini le nombre de matchs à réaliser
            int nbDeMatchs = Math.round((this.lesEquipes.size())/3);
            //System.out.println(nbDeMatchs);
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
                scoresEquipes.clear();
                for (int j = 0 ; j < this.lesEquipes.size() ; j++){
                    MatchScore match = new MatchScore(this.leSport ,this.lesEquipes.get(j));
                    match.deroulerMatch();
                    scoresEquipes.add(match);

                    //System.out.println(scoresEquipes+"\n\n");
                    //System.out.println(lesEquipes.size()+"\n");
                }
                Comparator<MatchScore> compare = new CompareMatchScore();
                Collections.sort(scoresEquipes, compare); 
                //System.out.println("score tri = "+scoresEquipes+"\n\n");
                this.lesEquipes.clear();


                for (int posMatch = 0 ; posMatch < scoresEquipes.size(); posMatch++) {
                    if (posMatch < 3){
                        Classement.add(scoresEquipes.get(posMatch).getEquipe());
                    } else {this.lesEquipes.add(scoresEquipes.get(posMatch).getEquipe());}

                    //System.out.println("le classement est "+Classement+"\n\n\n");
                    //System.out.println("E contient"+this.lesEquipes+"\n\n");
                    
                }
                //System.out.println("il reste " + i + "sur " + nbDeMatchs);
                if (this.lesEquipes.size() != 0 && i+1 == nbDeMatchs) {
                    //System.out.println("oui je passe dans la boucle");
                    for (Equipe EquipeRestente : this.lesEquipes) {
                        Classement.add(EquipeRestente);
                    }
                }
            }
            Classement = reverse(Classement);
            Classement.get(1).ajouteMedailleOr();
            Classement.get(2).ajouteMedailleArgent();
            Classement.get(3).ajouteMedailleBronze();
            return Classement;
        }

        else {return Classement;}
    }

    @Override
    public String toString() {
        return this.categorieEpreuve + " " + this.nomEpreuve + " " + this.sexeEpreuve;
    }
}

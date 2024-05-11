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
            HashMap<Integer, Equipe> pallierEquipeSansMatch = new HashMap<Integer, Equipe>();
            HashMap<Integer, List<MatchDuel>> pallierMatch = new HashMap<Integer, List<MatchDuel>>();            
            pallierEquipe.put(0, this.lesEquipes);
            int l=0;
            while (l==0){
                l+=1;
                System.out.println(l);
                for (Map.Entry<Integer, List<Equipe>> entry : pallierEquipe.entrySet()) {
                    Integer cleEqip = entry.getKey();
                    List<Equipe> valeursEqip = entry.getValue();                                                       // CREE LES MATCHDUEL
                    if (valeursEqip.size()!=0){
                        List<MatchDuel> listematchs = new ArrayList<>();
                        for (int i=0 ; i<valeursEqip.size() ; i+=2) {                          
                            if(valeursEqip.size()%2==0){
                                MatchDuel match = new MatchDuel(this.leSport, valeursEqip.get(i), valeursEqip.get(i+1));
                                match.deroulerMatch();
                                listematchs.add(match);
                            } else { 
                                if(valeursEqip.size() != i+1){
                                MatchDuel match = new MatchDuel(this.leSport, valeursEqip.get(i), valeursEqip.get(i+1));
                                match.deroulerMatch();
                                listematchs.add(match);
                                } else { if (valeursEqip.size() == i)
                                    pallierEquipeSansMatch.put(cleEqip, valeursEqip.get(i));
                                }
                            }         
                        }
                        pallierMatch.put(cleEqip,listematchs);
                    }    
                }

                List<Integer> clePallierEquipe = new ArrayList<>(pallierEquipe.keySet());
                List<Integer> clePallierMatch = new ArrayList<>(pallierMatch.keySet());
                Collections.sort(clePallierEquipe);
                Collections.sort(clePallierMatch);

                System.out.println("pallier match: "+pallierMatch+"\n");

                pallierEquipe.clear();

                List<MatchDuel> valeurMatchPallier0 = new ArrayList<>();
                List<MatchDuel> valeurMatchPallier1 = new ArrayList<>();
                List<Equipe> listePallier = new ArrayList<>();

                for (Integer cleMatch : clePallierMatch){                                                          
                    valeurMatchPallier0 = pallierMatch.get(cleMatch);
                    valeurMatchPallier1 = pallierMatch.get(cleMatch+1);

                    
                    
                    // debut
                    if (cleMatch==clePallierMatch.get(0)){
                        for (MatchDuel resMatchPallier0 : valeurMatchPallier0){
                            if (resMatchPallier0.getScoreEquipe1() < resMatchPallier0.getScoreEquipe2()){ // on ajoute le perdant du pallier
                                listePallier.add(resMatchPallier0.getEquipe2());
                            } else {
                                    listePallier.add(resMatchPallier0.getEquipe1());
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch) != null)
                            listePallier.add(pallierEquipeSansMatch.get(cleMatch));
                        System.out.println("liste pallier: "+listePallier+"\n");
                        System.out.println("aled");
                        pallierEquipe.put(cleMatch, listePallier);
                        System.out.println("pallier Equipe lors du début: "+pallierEquipe+"\n");
                        listePallier.clear();
                        
                    }

                        // milieu
                    for (MatchDuel resMatchPallier0 : valeurMatchPallier0){
                        if (resMatchPallier0.getScoreEquipe1() < resMatchPallier0.getScoreEquipe2()){ // on ajoute le gagnant
                            listePallier.add(resMatchPallier0.getEquipe2());
                        } else {listePallier.add(resMatchPallier0.getEquipe1());}    
                        System.out.println(listePallier);
                    }
                    if (valeurMatchPallier1 != null) {                                                                                      // AFFECTE LES EQUIPE A LEUR PALLIER SELON LES MATCH
                        for (MatchDuel resMatchPallier1 : valeurMatchPallier1){
                            if (resMatchPallier1.getScoreEquipe1() < resMatchPallier1.getScoreEquipe2()){ // on ajoute le perdant
                                listePallier.add(resMatchPallier1.getEquipe1());
                            } else {listePallier.add(resMatchPallier1.getEquipe2());}               
                        }
                        if (pallierEquipeSansMatch.get(cleMatch+1) != null)
                            listePallier.add(pallierEquipeSansMatch.get(cleMatch+1));
                        
                    }
                    pallierEquipe.put(cleMatch+1, listePallier);



                    listePallier.clear();
                    valeurMatchPallier0.clear();

                        //fin

                    if (valeurMatchPallier1 != null)    
                        valeurMatchPallier1.clear();

                    if (cleMatch+1 == clePallierMatch.size()){
                        if (valeurMatchPallier1 != null) {
                            for (MatchDuel resMatchPallier1 : valeurMatchPallier1){
                                if (resMatchPallier1.getScoreEquipe1() < resMatchPallier1.getScoreEquipe2()){ // on ajoute le gagnant
                                    listePallier.add(resMatchPallier1.getEquipe2());
                                } else {
                                        listePallier.add(resMatchPallier1.getEquipe1());
                                }
                            } 
                        }
                        if (pallierEquipeSansMatch.get(cleMatch+2) != null)
                            listePallier.add(pallierEquipeSansMatch.get(cleMatch+2));

                        pallierEquipe.put(cleMatch+2, listePallier);
                        listePallier.clear();
                        break;
                    }     
                }
                
                System.out.println("pallier Equipe: "+pallierEquipe+"\n");

                pallierMatch.clear();
                
                resteDesMatch=false;
                for (Integer cleEquipe : clePallierEquipe){                                                    // VERIFIE SI LA BOUCLE EST FINI ET CREE LE CLASSEMENT
                    List<Equipe> listeEquipe2 = pallierEquipe.get(cleEquipe);
                    for (Equipe equipe : listeEquipe2){
                        if(listeEquipe2.size() == 1){
                            Classement.add(equipe);
                        }
                        else {resteDesMatch=true;}
                    }
                }
                if (resteDesMatch=true)
                    Classement.clear();

                //System.out.println("Equipe: "+pallierEquipe);          
            }
            if (Classement.size()>1)
                Classement.get(1).ajouteMedailleOr();
            if (Classement.size()>2)
                Classement.get(2).ajouteMedailleArgent();
            if (Classement.size()>3)
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
            if (Classement.size()>1)
                Classement.get(1).ajouteMedailleOr();
            if (Classement.size()>2)
                Classement.get(2).ajouteMedailleArgent();
            if (Classement.size()>3)
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

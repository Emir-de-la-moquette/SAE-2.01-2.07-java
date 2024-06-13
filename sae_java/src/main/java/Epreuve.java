import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Math;
import java.util.HashMap;

public class Epreuve implements Participation<Equipe> {

    private static List<Integer> lesID = new ArrayList<>();

    private String nomEpreuve;
    private char sexeEpreuve;

    private String categorieEpreuve;
    private String typeEpreuve;

    private List<Equipe> lesEquipes;

    // Liste de match/liste d'équipe/
    private List<Match> lesMatchs;
    private HashMap<Integer, List<MatchDuel>> pallierMatch;

    // private List<Match> scoresEquipes;
    private Sport leSport;

    private double moyenneAthletique = 1.0;
    private double recordMondial = 1.0;

    private int IDepreuve;

    private List<Equipe> classement;

    public Epreuve(int id, String nomEpreuve, char sexeEpreuve, String categorieEpreuve, String typeEpreuve,
            Sport sport) throws IDdejaExistantException {
        if (lesID.contains(id))
            throw new IDdejaExistantException("cet id est déjà utilisé");
        lesID.add(id);
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;
        this.classement = new ArrayList<>();

        this.leSport = sport;

        // this.scoresEquipes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();
        this.lesMatchs = new ArrayList<>();

    }

    public Epreuve(int id, String nomEpreuve, char sexeEpreuve, String categorieEpreuve, String typeEpreuve,
            Sport sport, double moy, double rec) throws IDdejaExistantException {
        if (lesID.contains(id))
            throw new IDdejaExistantException("cet id est déjà utilisé");
        lesID.add(id);
        this.nomEpreuve = nomEpreuve;
        this.sexeEpreuve = sexeEpreuve;
        this.categorieEpreuve = categorieEpreuve;
        this.typeEpreuve = typeEpreuve;
        this.moyenneAthletique = moy;
        this.recordMondial = rec;
        this.IDepreuve = id;
        this.leSport = sport;

        // this.scoresEquipes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();
        this.lesMatchs = new ArrayList<>();

    }


    public int getID() {
        return IDepreuve;
    }


    public static int getNewId() {
        int i = 20000;
        while (lesID.contains(i))
            i++;
        System.out.println("nouvel ID : " + i);
        return i;
    }


    // @return classement
    public List<Equipe> getClassement() {
        return classement;
    }

    // @return sexeEpreuve
    public char getSexeEpreuve() {
        return sexeEpreuve;
    }

    // @return nomEpreuve
    public String getNomEpreuve() {
        return this.nomEpreuve;
    }

    //set le nomEpreuve
    // @param String nomEpreuve
    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    // @return moyenneAthletique
    public double getMoyenneAthlet() {
        return this.moyenneAthletique;
    }

    // @return recordMondial
    public double getRecordMondil() {
        return this.recordMondial;
    }

    // @return lesMatchs
    public List<Match> getLesMatchs() {
        return lesMatchs;
    }

    //set la moyenneAthletique
    // @param double moye
    public void setMoyenneAthlet(double moye) {
        this.moyenneAthletique = moye;
    }


    //set le recordMondial
    // @param double rec
    public void setRecordMondil(double rec) {
        this.recordMondial = rec;
    }

    // @return categorieEpreuve
    public String getCategorieEpreuve() {
        return categorieEpreuve;
    }

    //set le categorieEpreuve
    // @param String categorieEpreuve
    public void setCategorieEpreuve(String categorieEpreuve) {
        this.categorieEpreuve = categorieEpreuve;
    }

    // @return typeEpreuve
    public String getTypeEpreuve() {
        return typeEpreuve;
    }

    // set le typeEpreuve
    // @param String typeEpreuve
    public void setTypeEpreuve(String typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    // @return leSport
    public Sport getLeSports() {
        return this.leSport;
    }

    //set leSport
    // @param Sport lesSports
    public void setLeSports(Sport lesSports) {
        this.leSport = lesSports;
    }

    // @param : une équipe
    // fait participer une équipe à l'épreuve
    @Override

    public void participer(Equipe equipe) throws Exception {
        if (equipe.estALaBonneTaille())
            if (equipe.getSexeEquipe() == this.sexeEpreuve)
                this.lesEquipes.add(equipe);
            else
                throw new PasLeBonSexeException("Le sexe des athletes ne correspond pas au type de l'épreuve");
        else
            throw new PasALaBonneTailleException("l'équipe n'a pas la bonne taille");

    }

    // @param : une équipe
    // retire une équipe à l'épreuve
    @Override
    public void retirer(Equipe equipe) throws NoSuchElementException {
        this.lesEquipes.remove(equipe);

    }

    // affiche les équipes participant à l'épreuve
    // @return lesEquipes
    public List<Equipe> afficheLesEquipes() {
        return this.lesEquipes;
    }

    // affiche les matchs de l'épreuve
    // @return lesMatchs
    public List<Match> afficheLesMatchs() {
        return this.lesMatchs;
    }

    /* 
     * inverse le classement
     * @param List<Equipe> Classement
     * @return le List<Equipe> Classement finale
     */
    public List<Equipe> reverse(List<Equipe> Classement) {
        for (int k = 0, j = Classement.size() - 1; k < j; k++) {
            Classement.add(k, Classement.remove(j));
        }
        return Classement;

    }

    public List<Equipe> lanceEpreuve() {
        List<Equipe> Classement = new ArrayList<>();

        if (this.lesEquipes.size() == 0)
            return null;
        // System.out.println(this.lesEquipes);

        if (typeEpreuve == "Duel") {
            boolean resteDesMatch = true;
            Collections.shuffle(this.lesEquipes);
            HashMap<Integer, List<Equipe>> pallierEquipe = new HashMap<Integer, List<Equipe>>();
            pallierMatch = new HashMap<Integer, List<MatchDuel>>();
            pallierEquipe.put(0, this.lesEquipes);

            while (resteDesMatch == true) {
                HashMap<Integer, Equipe> pallierEquipeSansMatch = new HashMap<Integer, Equipe>();
                for (Map.Entry<Integer, List<Equipe>> entry : pallierEquipe.entrySet()) {
                    Integer cleEqip = entry.getKey();
                    List<Equipe> valeursEqip = entry.getValue(); // CREE LES MATCHDUEL
                    if (valeursEqip.size() != 0) {
                        List<MatchDuel> listematchs = new ArrayList<>();
                        for (int i = 0; i < valeursEqip.size(); i += 2) {
                            if (valeursEqip.size() == i + 1) {
                                pallierEquipeSansMatch.put(cleEqip, valeursEqip.get(i));
                                break;
                            }
                            MatchDuel match = new MatchDuel(this.leSport, valeursEqip.get(i), valeursEqip.get(i + 1));
                            match.deroulerMatch();
                            lesMatchs.add(match);
                            listematchs.add(match);
                        }
                        pallierMatch.put(cleEqip, listematchs);
                    }
                }
                List<Integer> clePallierEquipe = new ArrayList<>(pallierEquipe.keySet());
                List<Integer> clePallierMatch = new ArrayList<>(pallierMatch.keySet());
                Collections.sort(clePallierEquipe);
                Collections.sort(clePallierMatch);

                pallierEquipe.clear();

                List<MatchDuel> valeurMatchPallier0 = new ArrayList<>();
                List<MatchDuel> valeurMatchPallier1 = new ArrayList<>();

                for (Integer cleMatch : clePallierMatch) {
                    valeurMatchPallier0 = pallierMatch.get(cleMatch);
                    valeurMatchPallier1 = pallierMatch.get(cleMatch + 1);

                    // System.out.println("la cle" +cleMatch);
                    // System.out.println("m0 " +valeurMatchPallier0);
                    // System.out.println("m1 " +valeurMatchPallier1);

                    // DEBUT
                    if (cleMatch == clePallierMatch.get(0)) {
                        List<Equipe> newPallier1 = new ArrayList<>();
                        for (MatchDuel resMatchPallier0 : valeurMatchPallier0) {
                            if (resMatchPallier0.getScoreEquipe1() < resMatchPallier0.getScoreEquipe2()) { // on ajoute
                                                                                                           // le perdant
                                                                                                           // du pallier
                                newPallier1.add(resMatchPallier0.getEquipe1());
                            } else {
                                newPallier1.add(resMatchPallier0.getEquipe2());
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch) != null)
                            newPallier1.add(pallierEquipeSansMatch.get(cleMatch));
                        // System.out.println("aled");
                        pallierEquipe.put(cleMatch, newPallier1);

                    }

                    // MILIEU
                    List<Equipe> newPallier2 = new ArrayList<>();
                    for (MatchDuel resMatchPallier0 : valeurMatchPallier0) {
                        if (resMatchPallier0.getScoreEquipe1() < resMatchPallier0.getScoreEquipe2()) { // on ajoute le
                                                                                                       // gagnant
                            newPallier2.add(resMatchPallier0.getEquipe2());
                        } else {
                            newPallier2.add(resMatchPallier0.getEquipe1());
                        }
                    }
                    if (valeurMatchPallier1 != null) { // AFFECTE LES EQUIPE A LEUR PALLIER SELON LES MATCH
                        for (MatchDuel resMatchPallier1 : valeurMatchPallier1) {
                            if (resMatchPallier1.getScoreEquipe1() < resMatchPallier1.getScoreEquipe2()) { // on ajoute
                                                                                                           // le perdant
                                newPallier2.add(resMatchPallier1.getEquipe1());
                            } else {
                                newPallier2.add(resMatchPallier1.getEquipe2());
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch + 1) != null)
                            newPallier2.add(pallierEquipeSansMatch.get(cleMatch + 1));

                    }
                    pallierEquipe.put(cleMatch + 1, newPallier2);

                    // FIN

                    List<Equipe> newPallier3 = new ArrayList<>();
                    if (cleMatch + 1 == clePallierMatch.size()) {
                        if (valeurMatchPallier1 != null) {
                            for (MatchDuel resMatchPallier1 : valeurMatchPallier1) {
                                if (resMatchPallier1.getScoreEquipe1() < resMatchPallier1.getScoreEquipe2()) { // on
                                                                                                               // ajoute
                                                                                                               // le
                                                                                                               // gagnant
                                    newPallier3.add(resMatchPallier1.getEquipe2());
                                } else {
                                    newPallier3.add(resMatchPallier1.getEquipe1());
                                }
                            }
                        }
                        if (pallierEquipeSansMatch.get(cleMatch + 2) != null)
                            newPallier3.add(pallierEquipeSansMatch.get(cleMatch + 2));

                        pallierEquipe.put(cleMatch + 2, newPallier3);
                        break;
                    }
                }

                pallierMatch.clear();
                // VERIFIE SI LA BOUCLE EST FINI ET CREE LE CLASSEMENT
                resteDesMatch = false;
                for (Integer cleEquipe : clePallierEquipe) { 
                    List<Equipe> listeEquipe2 = pallierEquipe.get(cleEquipe);
                    for (Equipe equipe : listeEquipe2) {
                        if (listeEquipe2.size() == 1) {
                            Classement.add(equipe);
                        } else {
                            resteDesMatch = true;
                        }
                    }
                }

                if (resteDesMatch) {
                    Classement.clear();
                }

            }
            //* distribue les medailles */
            Classement = reverse(Classement);
            if (Classement.size() > 1)
                Classement.get(0).ajouteMedailleOr();
            if (Classement.size() > 2)
                Classement.get(1).ajouteMedailleArgent();
            if (Classement.size() > 3)
                Classement.get(2).ajouteMedailleBronze();

            this.classement = Classement;
            return Classement;
        }

        if (typeEpreuve == "Score") {
            // System.out.println(this.lesEquipes);

            // tant que il ya des joueur restant dans les.équipe
            List<MatchScore> scoresEquipes = new ArrayList<>();
            // on défini le nombre de matchs à réaliser
            int nbDeMatchs = Math.round((this.lesEquipes.size()) / 3);
            // System.out.println(nbDeMatchs);
            if (nbDeMatchs == 0) {
                nbDeMatchs = 1;
            }
            for (int i = 0; i < nbDeMatchs; i++) {
                /*
                 * on crée un match
                 * on fait jouer le match
                 * puis on compare les scores
                 * 
                 * après chaque matchs :
                 * on replace dans this.LesEquipes les scores les plus élevés sauf les 3
                 * dernier.
                 * les 3 dernier son ajouter au classement (l'idée est de simplement inverser
                 * les index de Classement pour obtenir notre vrai classement)
                 */
                scoresEquipes.clear();
                for (int j = 0; j < this.lesEquipes.size(); j++) {
                    MatchScore match = new MatchScore(this.leSport, this.lesEquipes.get(j), this.moyenneAthletique,
                            this.recordMondial);
                    match.deroulerMatch();
                    lesMatchs.add(match);
                    scoresEquipes.add(match);

                    if (match.getScore() > this.recordMondial) {
                        //* option de record mondial si record mondial battu */
                        System.out.println("NOUVEAU RECORD MONDIAL !!!!!!!!!");
                        this.recordMondial = match.getScore();
                    }

                    // System.out.println(scoresEquipes+"\n\n");
                    // System.out.println(lesEquipes.size()+"\n");
                }
                Comparator<MatchScore> compare = new CompareMatchScore();
                Collections.sort(scoresEquipes, compare);
                // System.out.println("score tri = "+scoresEquipes+"\n\n");
                this.lesEquipes.clear();

                for (int posMatch = 0; posMatch < scoresEquipes.size(); posMatch++) {
                    if (posMatch < 3) {
                        Classement.add(scoresEquipes.get(posMatch).getEquipe());
                    } else {
                        this.lesEquipes.add(scoresEquipes.get(posMatch).getEquipe());
                    }

                    // System.out.println("le classement est "+Classement+"\n\n\n");
                    // System.out.println("E contient"+this.lesEquipes+"\n\n");

                }
                // System.out.println("il reste " + i + "sur " + nbDeMatchs);
                if (this.lesEquipes.size() != 0 && i + 1 == nbDeMatchs) {
                    // System.out.println("oui je passe dans la boucle");
                    for (Equipe EquipeRestente : this.lesEquipes) {
                        Classement.add(EquipeRestente);
                    }
                }
            }
            //* distribue les medailles */
            Classement = reverse(Classement);
            if (Classement.size() > 0)
                Classement.get(0).ajouteMedailleOr();
            if (Classement.size() > 1)
                Classement.get(1).ajouteMedailleArgent();
            if (Classement.size() > 2)
                Classement.get(2).ajouteMedailleBronze();
            this.classement = Classement;
            return Classement;
        }

        else {
            System.out.println("l'épreuve à rencontrer un problème, et n'a pas pu avoir lieu");
            return Classement;
        }
    }

    @Override
    public String toString() {
        return this.categorieEpreuve + " " + this.nomEpreuve + " " + this.sexeEpreuve;
    }
}

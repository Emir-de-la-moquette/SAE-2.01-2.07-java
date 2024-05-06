import main.java.RandomNumberInRange;

public class MatchScore extends Match{
    private double score1 = 0;
    private double score2 = 0;
    private Equipe equipe1;
    private Equipe equipe2;

    public MatchScore(Sport sport, Equipe equip1, Equipe equip2){
        super(sport);
        this.equipe1 = equip1;
        this.equipe2 = equip2;
    }

    public double getScore(){return this.score;}

    /* A faire (voir le calcul du score pour chaaque sport) */

    @Override
    public void deroulerMatch(Integer tentatives){
        if (this.equipe1.size() >= 1 && this.equipe2.size() >= 1){
            if (this.sport.aReglePersonalisee()){
                while (!this.sport.conditionVictoire(score1, score2)){      // AJOUTER LES 2 METHODES UTILISEE A SPORT 
                    scoreBase();
                }
            }
            else{
                deroulementDefault();
            }
        }
    }

    private void deroulementDefault(){
        for (int i = 0; i<Math.round(RandomNumberInRange.getRandom(4, 12)); i++){
            scoreBase();
        }
        if (score1-score2 == 0){

            // Mort subite du match, point de la victoire

            double actionFinaleEquipe1 = 0;
            double actionFinaleEquipe2 = 0;
            for (Athelete athelete : this.equipe1){
                actionFinaleEquipe1 += (this.getCoefficientAgilite()*athlete.getAgilite() + this.sport.getCoefficientEndurance()*athlete.getEndurance() + this.sport.CoefficientForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
            }
            for (Athelete athelete : this.equipe2){
                actionFinaleEquipe2 += (this.getCoefficientAgilite()*athlete.getAgilite() + this.sport.getCoefficientEndurance()*athlete.getEndurance() + this.sport.CoefficientForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
            }
            double res = actionFinaleEquipe1-actionFinaleEquipe2;
            switch (true) {
                case res < 0:
                    this.score2 += this.sport.getpoint();
                    break;
                case res > 0:
                    this.score1 += this.sport.getpoint();
                    break;
                default:
                    break;
            }
        }
    }

    private void scoreBase(){

        // Test des équipes pour ajouter le point

        double actionEquipe1 = 0;
        double actionEquipe2 = 0;
        for (Athelete athelete : this.equipe1){
            actionEquipe1 += (this.getCoefficientAgilite()*athlete.getAgilite() + this.sport.getCoefficientEndurance()*athlete.getEndurance() + this.sport.CoefficientForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
        }
        for (Athelete athelete : this.equipe2){
            actionEquipe2 += (this.getCoefficientAgilite()*athlete.getAgilite() + this.sport.getCoefficientEndurance()*athlete.getEndurance() + this.sport.CoefficientForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
        }
        double res = actionEquipe1-actionEquipe2;
        switch (true) {

            // Afin de laisser une chance de défense, il y a un pallier de 10% afin de marquer le point, l'obtention du nombre de point est définie dans sport

            case res < 0-(actionEquipe1/10):
                this.score2 += this.sport.getpoint();   // AJOUTER LA METHODE GETPOINT A SPORT (c'est une liste de score possible selon le sport donné, si il y en a plusieurs cela en renvoit un random/ ou presque)
                break;
            case res > 0+(actionEquipe2/10):
                this.score1 += this.sport.getpoint();
                break;
            default:
                break;
        }
    }

    @Override
    public String toString(){
        String text;
        text = "Le match " + this.nomMatch;
        text += ", fait participer l'équipe : " + this.equipe.getNom();
        text += " et cette à réalisé un score de " + this.score;
    }


}
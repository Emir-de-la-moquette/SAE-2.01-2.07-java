import main.java.RandomNumberInRange;

public class MatchScore extends Match{
    double score1 = 0;
    double score2 = 0;
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
                for (Athelete athelete : this.equipe1){
                    double scoretp = (this.sport.getMoyenneAthletique() + this.getCoefficientAgilite()*athlete.getAgilite() + this.sport.getCoefficientEndurance()*athlete.getEndurance() + this.sport.CoefficientForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
                    if (score < scoretp){score = scoretp;}
                }
                score = score/equipe.size();
                
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
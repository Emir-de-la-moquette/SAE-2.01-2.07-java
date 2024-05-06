import main.java.RandomNumberInRange;

public class MatchScore extends Match{
    double score = 0;
    private Equipe equipe;

    public MatchScore(Sport sport, Equipe equip){
        super(sport);
        this.equipe = equip;
    }

    public double getScore(){return this.score;}

    @Override
    public void deroulerMatch(Integer tentatives){
        tentatives = tentatives != null ? tentatives : 1;
        if (this.equipe.size() >= 1){
                for (Athelete athelete : this.equipe){
                    for (int i; i<tentatives; i++){
                    double scoretp = (this.sport.getMoyenneAthletique() + this.getCoefficientAgilite()*athlete.getAgilite() + this.sport.getCoefficientEndurance()*athlete.getEndurance() + this.sport.CoefficientForce()*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
                    if (score < scoretp){score = scoretp;}
                    }
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

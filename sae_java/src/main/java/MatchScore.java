import main.java.RandomNumberInRange;

public class MatchScore extends Match{
    double score = 0;

    public MatchScore(Sport sport){
        super(sport);
    }

    @Override
    public EquipeScore<Equipe,Double> deroulerMatch(Equipe equipe){
        if (equipe.size() >= 1){
                for (Athelete athelete : equipe){
                    score += (this.moyenneAthletique + this.coefficientAgilite*athlete.agilite + this.coefficientEndurance*athlete.endurance + this.coefficientForce*athlete.force)*RandomNumberInRange.getRandom(0.6, 1.2);
                }
                score = score/equipe.size();
                return new EquipeScore<>(equipe, score);
                
        }
        
        return new EquipeScore<>(equipe, 0);
    }

    /*     Rajouter le toString()      */

}

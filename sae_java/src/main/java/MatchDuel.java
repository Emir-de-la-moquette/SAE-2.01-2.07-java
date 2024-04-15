import main.java.RandomNumberInRange;

public class MatchDuel extends Match{
    double score = 0;

    public MatchDuel(Sport sport){
        super(sport);
    }


/*
 *    A réaliser
 */

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
}

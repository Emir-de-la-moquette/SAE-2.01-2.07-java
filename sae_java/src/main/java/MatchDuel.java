import main.java.RandomNumberInRange;

public class MatchDuel extends Match{
    double score = 0;

    public MatchDuel(Sport sport, Equipe equip){
        super(sport, equip);
    }


/*
 *    A réaliser (c'est juste un copier collé de matchscore)
 */

    @Override
    public void deroulerMatch(Equipe equipe){
        if (equipe.size() >= 1){
                for (Athelete athelete : equipe){
                    score += (this.moyenneAthletique + this.coefficientAgilite*athlete.getAgilite() + this.coefficientEndurance*athlete.getEndurance() + this.coefficientForce*athlete.getForce())*RandomNumberInRange.getRandom(0.6, 1.2);
                }
                score = score/equipe.size();
                
        }
    }
    
    /*     Rajouter le toString()      */

}

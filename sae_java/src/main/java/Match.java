public class Match {
    double coefficientAgilite = 0.33;
    double coefficientEndurance = 0.33;
    double coefficientForce = 0.33;
    double moyenneAthletique = 0;

    public Match(Sport sport){
        this.coefficientAgilite = sport.agilite;
        this.coefficientEndurance = sport.endurance;
        this.coefficientForce = sport.force;
        this.moyenneAthletique = sport.moyenneAthletique;
    }

    public EquipeScore<Equipe,Integer> deroulerMatch(Equipe equipe){
        return new EquipeScore<>(equipe, 0);
    }
}

public class Match {
    double coefficientAgilite = 0.33;
    double coefficientEndurance = 0.33;
    double coefficientForce = 0.33;

    public Match(Sport sport){
        this.coefficientAgilite = sport.agilite;
        this.coefficientEndurance = sport.endurance;
        this.coefficientForce = sport.force;
    }

    public EquipeScore<Equipe,Integer> deroulerMatch(Equipe equipe){
        return new EquipeScore<>(equipe, 0);
    }
}

public class Match {
    protected Sport sport;

    protected String nomMatch;

    private static int numMatch;

    public Match(Sport sport){
        this.sport = sport;

        Match.numMatch+=1;

        this.nomMatch = this.sport.getNomSport() + " Match n°" + numMatch;
    }

    public static void clearNum(){ Match.numMatch=0;};

    public EquipeScore<Equipe,Integer> deroulerMatch(Equipe equipe){
        return new EquipeScore<>(equipe, 0);
    }
}

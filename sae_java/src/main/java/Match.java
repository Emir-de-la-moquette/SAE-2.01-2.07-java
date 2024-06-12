public class Match {
    protected Sport sport;

    protected String nomMatch;

    private static int numMatch;

    protected double moyenneAthletique = 1;
    protected double recordMondial = 1;

    public Match(Sport sport, double moy, double rec){
        this.sport = sport;
        this.moyenneAthletique = moy;
        this.recordMondial = rec;

        Match.numMatch+=1;

        this.nomMatch = this.sport.getNomSport() + " Match n°" + numMatch;
    }

    public Match(Sport sport){
        this.sport = sport;

        Match.numMatch+=1;

        this.nomMatch = this.sport.getNomSport() + " Match n°" + numMatch;
    }

    public static void clearNum(){ Match.numMatch=0;};

    public void deroulerMatch(){}
}

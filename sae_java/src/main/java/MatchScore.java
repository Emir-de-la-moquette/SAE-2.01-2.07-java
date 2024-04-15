public class MatchScore extends Match{
    double score = 0;

    public MatchScore(Sport sport){
        super(sport);
    }

    @Override
    public EquipeScore<Equipe,Integer> deroulerMatch(Equipe equipe){
        int x = equipe.size();
        switch (x) {
            case x = 1:
                
                break;
            
            case x > 1:

                break;
        
            default:
                return new EquipeScore<>(null, null);
        }
        if (equipe.size() < 1) {
            
        }
        
        return new EquipeScore<>(equipe, 0);
    }

}

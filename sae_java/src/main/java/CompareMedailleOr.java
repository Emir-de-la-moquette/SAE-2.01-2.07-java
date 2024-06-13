import java.util.Comparator;

public class CompareMedailleOr implements Comparator<Pays>{
    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_or();
        int m2 = p2.getmedailles_or();
        return m2-m1;
    }
    }
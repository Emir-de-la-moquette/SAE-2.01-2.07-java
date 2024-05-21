import java.util.Comparator;

public class CompareMedailleTotal implements Comparator<Pays>{

    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_total();
        int m2 = p2.getmedailles_total();
        return m2-m1;
    }
}
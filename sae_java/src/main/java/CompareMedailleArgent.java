import java.util.Comparator;
    
public class CompareMedailleArgent implements Comparator<Pays>{

    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_argent();
        int m2 = p2.getmedailles_argent();
        return m2-m1;
    }
}

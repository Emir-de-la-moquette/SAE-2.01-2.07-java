import java.util.Comparator;

public class CompareMedaillePays implements Comparator<Pays>{

    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_bronze();
        int m2 = p2.getmedailles_bronze();
        return m1-m2;
    }
    }
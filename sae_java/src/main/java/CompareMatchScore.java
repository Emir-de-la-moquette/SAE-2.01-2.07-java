import java.util.Comparator;
public class CompareMatchScore implements Comparator<MatchScore> {

@Override
public int compare(MatchScore m1, MatchScore m2) {
double malo1 = m1.getScore()*1000;
double malo2 = m2.getScore()*1000;
return (int)(malo1 - malo2);
}

}


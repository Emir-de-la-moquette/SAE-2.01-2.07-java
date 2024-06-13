import java.util.Comparator;
    
public class CompareMedailleArgent implements Comparator<Pays>{

    /*
    *retourne la diffence entre deux pays en terme de medailles dargent 
    *@return int (si positif p1 (pay1) est au dessus de p2 (pays2) sinon p1 est au dessous de p2 si p1 et p2 sont egale a eux meme representer par 0  on place par ordre d'arriver
    */
    @Override
    public int compare(Pays p1, Pays p2){
        int m1 = p1.getmedailles_argent();
        int m2 = p2.getmedailles_argent();
        return m2-m1;
    }
}

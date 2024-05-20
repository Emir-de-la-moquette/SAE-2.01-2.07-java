/* au cas ou :

 * compiler : javac -d bin src/main/java/*.java
 * executer : java -cp bin Executable
 * 
 * jusqu'au jour ou on fera de l'IHM
 */

public class Executable {
    public static void main(String [] args) {
        Sport chifoumi = new Sport("chifoumi", 1, 0.7, 0.1, 0.1, 1.0,2);

        Pays b = new Pays("b");
        Pays c = new Pays("c");
        Pays d = new Pays("d");
        Pays e = new Pays("e");
        Pays f = new Pays("f");
        Pays g = new Pays("g");

        Athlete atl2 = new Athlete("b", "c", "H", 15, 6, 6);
        Athlete atl3 = new Athlete("c", "d", "H", 15, 6, 6);
        Athlete atl4 = new Athlete("d", "e", "H", 15, 6, 6);
        Athlete atl21 = new Athlete("b", "c", "H", 15, 6, 6);
        Athlete atl31 = new Athlete("c", "d", "H", 15, 6, 6);
        Athlete atl41 = new Athlete("d", "e", "H", 15, 6, 6);

        Epreuve chifoumimi = new Epreuve("chifoumimi", "Homme" , "junior", "Duel", chifoumi);
        for (int i = 0 ; i < 5 ; i++){
            Pays a = new Pays("pays: " + i);
            Athlete atl1 = new Athlete("a", "b", "H", 17, 5, 7);
            Equipe e1 = new Equipe(1, a);
            a.ajouterEquipe(e1);
            e1.ajouteAthletes(atl1);
            chifoumimi.participer(e1);
        }
        chifoumimi.lanceEpreuve();
        
    }
    
}

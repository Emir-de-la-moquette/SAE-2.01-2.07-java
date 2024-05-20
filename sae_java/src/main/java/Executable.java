/* au cas ou :

 * compiler : javac -d bin src/main/java/*.java
 * executer : java -cp bin Executable
 * 
 * jusqu'au jour ou on fera de l'IHM
 */

public class Executable {
    public static void main(String [] args) {
        Sport chifoumi = new Sport("chifoumi", 1, 0.7, 0.1, 0.1, 1.0,2);

        Pays a = new Pays("a");
        Pays b = new Pays("b");
        Pays c = new Pays("c");
        Pays d = new Pays("d");
        Pays e = new Pays("e");
        Pays f = new Pays("f");
        Pays g = new Pays("g");


        Athlete atl1 = new Athlete("a", "b", "H", 17, 5, 7);
        Athlete atl2 = new Athlete("b", "c", "H", 15, 6, 6);
        Athlete atl3 = new Athlete("c", "d", "H", 15, 6, 6);
        Athlete atl4 = new Athlete("d", "e", "H", 15, 6, 6);
        Athlete atl21 = new Athlete("b", "c", "H", 15, 6, 6);
        Athlete atl31 = new Athlete("c", "d", "H", 15, 6, 6);
        Athlete atl41 = new Athlete("d", "e", "H", 15, 6, 6);


        Equipe e1 = new Equipe(1, a);
        Equipe e2 = new Equipe(1, b);
        Equipe e3 = new Equipe(1, c);
        Equipe e4 = new Equipe(1, d);
        Equipe e5 = new Equipe(1, e);
        Equipe e6 = new Equipe(1, f);
        Equipe e7 = new Equipe(1, g);
        Equipe e8 = new Equipe(1, a);
        Equipe e9 = new Equipe(1, b);
        Equipe e10 = new Equipe(1, c);
        Equipe e11 = new Equipe(1, d);
        Equipe e12 = new Equipe(1, e);
        Equipe e13 = new Equipe(1, f);
        Equipe e14 = new Equipe(1, g);


        a.ajouterEquipe(e1);
        b.ajouterEquipe(e2);
        c.ajouterEquipe(e3);
        d.ajouterEquipe(e4);
        e.ajouterEquipe(e5);
        f.ajouterEquipe(e6);
        g.ajouterEquipe(e7);
        a.ajouterEquipe(e8);
        b.ajouterEquipe(e9);
        c.ajouterEquipe(e10);
        d.ajouterEquipe(e11);
        e.ajouterEquipe(e12);
        f.ajouterEquipe(e13);
        g.ajouterEquipe(e14);


        e1.ajouteAthletes(atl4);
        e2.ajouteAthletes(atl3);
        e3.ajouteAthletes(atl2);
        e4.ajouteAthletes(atl1);
        e5.ajouteAthletes(atl21);
        e6.ajouteAthletes(atl31);
        e7.ajouteAthletes(atl41);
        e8.ajouteAthletes(atl4);
        e9.ajouteAthletes(atl3);
        e10.ajouteAthletes(atl2);
        e11.ajouteAthletes(atl1);
        e12.ajouteAthletes(atl21);
        e13.ajouteAthletes(atl31);
        e14.ajouteAthletes(atl41);

        Epreuve chifoumimi = new Epreuve("chifoumimi", "Homme" , "junior", "Duel", chifoumi);
        chifoumimi.participer(e1);
        chifoumimi.participer(e2);
        chifoumimi.participer(e3);
        chifoumimi.participer(e4);
        chifoumimi.participer(e5);
        chifoumimi.participer(e6);
        chifoumimi.participer(e7);
        chifoumimi.participer(e8);
        chifoumimi.participer(e9);
        chifoumimi.participer(e10);
        chifoumimi.participer(e11);
        chifoumimi.participer(e12);
        chifoumimi.participer(e13);
        chifoumimi.participer(e14);
        chifoumimi.lanceEpreuve();
        
    }
    
}

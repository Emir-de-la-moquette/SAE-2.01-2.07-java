/* au cas ou :

 * compiler : javac -d bin src/main/java/*.java
 * executer : java -cp bin Executable
 * 
 * jusqu'au jour ou on fera de l'IHM
 */

public class Executable {
    public static void main(String [] args) {
        Sport chifoumi = new Sport("chifoumi", 1, 0.7, 0.1, 0.1, 1.0,2);

        Pays dadakistan = new Pays("datakistan");
        Pays titikistan = new Pays("titikistan");
        Pays an1 = new Pays("1an");
        Pays an2 = new Pays("2an");
        Pays an3 = new Pays("3an");


        Athlete atl1 = new Athlete("a", "b", "H", 17, 5, 7);
        Athlete atl2 = new Athlete("b", "c", "H", 15, 6, 6);
        Athlete atl3 = new Athlete("c", "d", "H", 15, 6, 6);
        Athlete atl4 = new Athlete("d", "e", "H", 15, 6, 6);
        Athlete atl21 = new Athlete("b", "c", "H", 15, 6, 6);
        Athlete atl31 = new Athlete("c", "d", "H", 15, 6, 6);
        Athlete atl41 = new Athlete("d", "e", "H", 15, 6, 6);


        Equipe e1 = new Equipe(1, dadakistan);
        Equipe e2 = new Equipe(1, an2);
        Equipe e3 = new Equipe(1, titikistan);
        Equipe e4 = new Equipe(1, dadakistan);
        Equipe e5 = new Equipe(1, an1);
        Equipe e6 = new Equipe(1, dadakistan);
        Equipe e7 = new Equipe(1, an3);


        dadakistan.ajouterEquipe(e1);
        an2.ajouterEquipe(e2);
        titikistan.ajouterEquipe(e3);
        dadakistan.ajouterEquipe(e4);
        an1.ajouterEquipe(e5);
        dadakistan.ajouterEquipe(e6);
        an3.ajouterEquipe(e7);
        System.out.println(dadakistan.afficheLesEquipes());


        e1.ajouteAthletes(atl4);
        e2.ajouteAthletes(atl3);
        e3.ajouteAthletes(atl2);
        e4.ajouteAthletes(atl1);
        e5.ajouteAthletes(atl21);
        e6.ajouteAthletes(atl31);
        e7.ajouteAthletes(atl41);

        Epreuve chifoumimi = new Epreuve("chifoumimi", "Homme" , "junior", "Duel", chifoumi);
        chifoumimi.participer(e1);
        chifoumimi.participer(e2);
        chifoumimi.participer(e3);
        chifoumimi.participer(e4);
        chifoumimi.participer(e5);
        chifoumimi.participer(e6);
        chifoumimi.participer(e7);
        chifoumimi.lanceEpreuve();
        System.out.println(dadakistan.getmedailles_bronze());
        
    }
    
}

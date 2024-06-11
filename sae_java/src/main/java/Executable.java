/* au cas ou :

 * compiler : javac -d bin src/main/java/*.java
 * executer : java -cp bin Executable
 * 
 * jusqu'au jour ou on fera de l'IHM
 */

import java.util.Comparator;

public class Executable {
    public static void main(String [] args) {

        JeuxOlympique JO2024 = new JeuxOlympique("France", 2024);

        Sport chifoumi = new Sport("chifoumi", 1, 0.7, 0.1, 0.1, 1.0,2);
        Sport ppc = new Sport("pierrepapierciseaux", 1, 0.7, 0.1, 0.1, 1.0,2);
        Sport tennis = new Sport("tennis", 2, 0.4, 0.4, 0.2, 1.0,6);


        Epreuve chifoumimi = new Epreuve("chifoumimi", "Homme" , "junior", "Duel", chifoumi);
        Epreuve pierrepapierciseaux = new Epreuve("pierrepapierciseaux", "Homme" , "junior", "Duel", ppc);
        Epreuve Tennis = new Epreuve("teniis", "F", "senior", "Score", tennis);


        JO2024.ajouteSport(chifoumi);
        JO2024.ajouteEpreuve(chifoumimi);

        
        Pays france = new Pays("France");
        Pays allemagne = new Pays("Allemagne");
        Pays italie = new Pays("Italie");
        Pays pologne = new Pays("Pologne");
        Pays chine = new Pays("Chine");
        Pays etats_unis = new Pays("Etats-Unis");

        JO2024.ajoutePays(etats_unis);
        JO2024.ajoutePays(france);
        JO2024.ajoutePays(pologne);
        JO2024.ajoutePays(italie);
        JO2024.ajoutePays(chine);
        JO2024.ajoutePays(allemagne);


// Hommes
        Athlete atl1 = new Athlete("John", "Doe", "M", 20, 20, 20);
        Athlete atl2 = new Athlete("Mike", "Johnson", "M", 10, 10, 10);

        Athlete atl3 = new Athlete("Luke", "Brown", "M", 10, 10, 10);
        Athlete atl4 = new Athlete("Chris", "Evans", "M", 0, 0, 0);

        Athlete atl5 = new Athlete("David", "Garcia", "M", 9, 7, 8);
        Athlete atl6 = new Athlete("James", "Smith", "M", 17, 15, 13);

        Athlete atl7 = new Athlete("Robert", "Wilson", "M", 6, 9, 12);
        Athlete atl8 = new Athlete("Michael", "Martinez", "M", 20, 18, 19);

        Athlete atl9 = new Athlete("William", "Lopez", "M", 11, 14, 10);
        Athlete atl10 = new Athlete("Thomas", "Anderson", "M", 12, 13, 15);

        Athlete atl11 = new Athlete("Charles", "Perez", "M", 8, 16, 14);
        Athlete atl12 = new Athlete("Daniel", "Thompson", "M", 19, 17, 20);



// Femmes
        Athlete atl13 = new Athlete("Jane", "Smith", "F", 18, 16, 17);
        Athlete atl14 = new Athlete("Emily", "Davis", "F", 19, 20, 18);

        Athlete atl15 = new Athlete("Anna", "Wilson", "F", 12, 14, 13);
        Athlete atl16 = new Athlete("Laura", "Martinez", "F", 16, 17, 15);

        Athlete atl17 = new Athlete("Sophia", "Anderson", "F", 11, 10, 9);
        Athlete atl18 = new Athlete("Isabella", "Thomas", "F", 14, 15, 16);

        Athlete atl19 = new Athlete("Olivia", "Jackson", "F", 13, 11, 12);
        Athlete atl20 = new Athlete("Mia", "White", "F", 17, 18, 19);

        Athlete atl21 = new Athlete("Ava", "Harris", "F", 10, 12, 14);
        Athlete atl22 = new Athlete("Abigail", "Clark", "F", 8, 9, 11);

        Athlete atl23 = new Athlete("Madison", "Rodriguez", "F", 15, 14, 13);
        Athlete atl24 = new Athlete("Charlotte", "Lewis", "F", 20, 19, 18);



        Equipe equipeUSchiffoumi = new Equipe(1, etats_unis);
        Equipe equipeFRchiffoumi = new Equipe(1, france);
        Equipe equipePLchiffoumi = new Equipe(1, pologne);
        Equipe equipeCNchiffoumi = new Equipe(1, chine);


        france.participer(equipeFRchiffoumi);
        pologne.participer(equipePLchiffoumi);
        chine.participer(equipeCNchiffoumi);
        etats_unis.participer(equipeUSchiffoumi);



        equipeFRchiffoumi.ajouteAthletes(atl1);
        equipePLchiffoumi.ajouteAthletes(atl2);
        equipeCNchiffoumi.ajouteAthletes(atl3);
        equipeUSchiffoumi.ajouteAthletes(atl4);

        chifoumimi.participer(equipeFRchiffoumi);
        chifoumimi.participer(equipePLchiffoumi);
        chifoumimi.participer(equipeCNchiffoumi);
        chifoumimi.participer(equipeUSchiffoumi);

        pierrepapierciseaux.participer(equipeFRchiffoumi);
        pierrepapierciseaux.participer(equipePLchiffoumi);
        pierrepapierciseaux.participer(equipeCNchiffoumi);

        
        JO2024.simulJO();
        CompareMedailleOr compOr = new CompareMedailleOr();
        System.out.print(JO2024.classement(compOr));
        






       
    }
    
}

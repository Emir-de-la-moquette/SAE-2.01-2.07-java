/* au cas ou :

 * compiler : javac -d bin src/main/java/*.java
 * executer : java -cp bin Executable
 * 
 * jusqu'au jour ou on fera de l'IHM
 */

import java.util.*;

public class Executable {
    public static void main(String [] args) throws IDdejaExistantException , Exception{

        JeuxOlympique JO2024 = new JeuxOlympique("France", 2024);

        Sport chifoumi = new Sport("chifoumi", 1, 0.7, 0.1, 0.1, 2);
        Sport ppc = new Sport("pierrepapierciseaux", 1, 0.7, 0.1, 0.1, 2);
        Sport tennis = new Sport("tennis", 2, 0.4, 0.4, 0.2, 6);


        Epreuve chifoumimi = new Epreuve(1,"chifoumimi", 'H' , "junior", "Score", chifoumi);
        Epreuve pierrepapierciseaux = new Epreuve(2,"pierrepapierciseaux", 'H' , "junior", "Duel", ppc);
        Epreuve tennnis = new Epreuve(3,"teniis", 'H', "senior", "Score", tennis);


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
        Athlete atl1 = new Athlete(1,"John", "Doe", 'H', 20, 20, 20);
        Athlete atl2 = new Athlete(2,"Mike", "Johnson", 'H', 10, 10, 10);

        Athlete atl3 = new Athlete(3,"Luke", "Brown", 'H', 10, 10, 10);
        Athlete atl4 = new Athlete(4,"Chris", "Evans", 'H', 0, 0, 0);

        Athlete atl5 = new Athlete(5,"David", "Garcia", 'H', 9, 7, 8);
        Athlete atl6 = new Athlete(6,"James", "Smith", 'H', 17, 15, 13);

        Athlete atl7 = new Athlete(7,"Robert", "Wilson", 'H', 6, 9, 12);
        Athlete atl8 = new Athlete(8,"Michael", "Martinez", 'H', 20, 18, 19);

        Athlete atl9 = new Athlete(9,"William", "Lopez", 'H', 11, 14, 10);
        Athlete atl10 = new Athlete(10,"Thomas", "Anderson", 'H', 12, 13, 15);

        Athlete atl11 = new Athlete(11,"Charles", "Perez", 'H', 8, 16, 14);
        Athlete atl12 = new Athlete(12,"Daniel", "Thompson", 'H', 19, 17, 20);



// Femmes
/*         Athlete atl13 = new Athlete("Jane", "Smith", "F", 18, 16, 17);
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
*/


        Equipe equipeUSchiffoumi = new Equipe(1, 1, 'H');
        Equipe equipeFRchiffoumi = new Equipe(2, 1, 'H');
        Equipe equipePLchiffoumi = new Equipe(3,1, 'H');
        Equipe equipeCNchiffoumi = new Equipe(4, 1, 'H');


        france.participer(equipeFRchiffoumi);
        pologne.participer(equipePLchiffoumi);
        chine.participer(equipeCNchiffoumi);
        etats_unis.participer(equipeUSchiffoumi);



        equipeFRchiffoumi.participer(atl1);
        equipePLchiffoumi.participer(atl2);
        equipeCNchiffoumi.participer(atl3);
        equipeUSchiffoumi.participer(atl4);

        chifoumimi.participer(equipeFRchiffoumi);
        chifoumimi.participer(equipePLchiffoumi);
        chifoumimi.participer(equipeCNchiffoumi);
        chifoumimi.participer(equipeUSchiffoumi);

        pierrepapierciseaux.participer(equipeFRchiffoumi);
        pierrepapierciseaux.participer(equipePLchiffoumi);
        pierrepapierciseaux.participer(equipeCNchiffoumi);




        /*List<Equipe> resultchifoumi = chifoumimi.lanceEpreuve();
        for(Equipe equip : resultchifoumi){
            System.out.println(equip.toString());
        }
        System.out.println(resultchifoumi);*/
        //JO2024.simulJO();
        //System.out.println(chifoumimi.getLesMatchs());


        //Comparator compOr = new CompareMedailleOr();


        
        //JO2024.simulJO();
        //CompareMedailleOr compOr = new CompareMedailleOr();

        //System.out.print(JO2024.classement(compOr));
        //System.out.println(chifoumimi.getLesMatchs());

        System.out.println(chifoumimi.lanceEpreuve());






       
    }
    
}

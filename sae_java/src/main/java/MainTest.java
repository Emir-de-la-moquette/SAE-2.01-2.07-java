
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
class MainTest {
    public static void main(String [] args) {

        JeuxOlympique JO2024 = new JeuxOlympique("France", 2024);

        Sport chifoumi = new Sport("chifoumi", 1, 0.7, 0.1, 0.1, 2);
        Sport ppc = new Sport("pierrepapierciseaux", 1, 0.7, 0.1, 0.1, 2);
        Sport tennis = new Sport("tennis", 2, 0.4, 0.4, 0.2, 6);


        Epreuve chifoumimi = new Epreuve("chifoumimi", 'H' , "junior", "Score", chifoumi);
        Epreuve pierrepapierciseaux = new Epreuve("pierrepapierciseaux", 'H' , "junior", "Duel", ppc);
        Epreuve tennnis = new Epreuve("teniis", 'F', "senior", "Score", tennis);


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

        Athlete atl1 = new Athlete("John", "Doe", 'M', 1, 2, 3);
        Athlete atl2 = new Athlete("Mike", "Johnson", 'M', 10, 10, 10);

        Athlete atl3 = new Athlete("Luke", "Brown", 'M', 500, 500, 500);
        Athlete atl4 = new Athlete("Chris", "Evans", 'M', 0, 0, 0);

        Athlete atl21 = new Athlete("Chris", "Evans", 'F', 0, 0, 0);



        Equipe equipeUSchiffoumi = new Equipe(1, etats_unis, 'M');
        Equipe equipeFRchiffoumi = new Equipe(1, france, 'M');
        Equipe equipePLchiffoumi = new Equipe(1, pologne, 'M');
        Equipe equipeCNchiffoumi = new Equipe(1, chine, 'M');
        Equipe equipeFEMMEchiffoumi = new Equipe(1, allemagne, 'F');


        france.participer(equipeFRchiffoumi);
        pologne.participer(equipePLchiffoumi);
        chine.participer(equipeCNchiffoumi);
        etats_unis.participer(equipeUSchiffoumi);
        allemagne.participer(equipeUSchiffoumi);



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
        pierrepapierciseaux.participer(equipeUSchiffoumi);

    
        System.out.println("\nGetter\n");

        
        if (atl1.getAgilite() == 1)
            System.out.print("test getAgilite pass\n");
        else System.out.println("test fail\n");

        if (atl1.getEndurance() == 2)
            System.out.print("test getEndurance pass\n");
        else System.out.println("test getEndurence fail\n");
    
        if (atl1.getForce() == 3)
            System.out.print("test getForce pass\n");
        else System.out.println("test getForce fail\n");

        if (atl1.getNomA().equals("John"))
            System.out.print("test getNomA pass\n");
        else System.out.println("test getNomA fail\n");


        System.out.println("\nScore\n");

        if (chifoumimi.getLeSports().equals(chifoumi))
            System.out.print("test getLeSports pass\n");
        else System.out.println("test getLeSports fail\n");

        if (chifoumimi.afficheLesEquipes().size() == 4)
            System.out.print("test afficheLesEquipes pass\n");
        else System.out.println("test afficheLesEquipes fail\n");


        if (chifoumimi.lanceEpreuve().size() == 4)
            System.out.print("test lanceEpreuve classement pass\n");
        else System.out.println("test lanceEpreuve classement fail\n");

        if (chifoumimi.lanceEpreuve().get(0).equals(equipeCNchiffoumi))
            System.out.print("test lanceEpreuve 1er pass\n");
        else System.out.println("test lanceEpreuve 1er fail\n");

        //if (chifoumimi.lanceEpreuve().get(0).getPays().getmedailles_or() == 1)
        //    System.out.print("test getmedailles_or pass\n");
        //else System.out.println("test getmedailles_or fail\n");

        
        System.out.println("\nDuel\n");

        if (pierrepapierciseaux.getLeSports().equals(ppc))
            System.out.print("test getLeSports pass\n");
        else System.out.println("test getLeSports fail\n");

        if (pierrepapierciseaux.afficheLesEquipes().size() == 4)
            System.out.print("test afficheLesEquipes pass\n");
        else System.out.println("test afficheLesEquipes fail\n");


        if (pierrepapierciseaux.lanceEpreuve().size() == 4)
            System.out.print("test lanceEpreuve classement pass\n");
        else System.out.println("test lanceEpreuve classement fail\n");

        if (pierrepapierciseaux.lanceEpreuve().get(0).equals(equipeCNchiffoumi))
            System.out.print("test lanceEpreuve 1er pass\n");
        else System.out.println("test lanceEpreuve 1er fail\n");

        //if (pierrepapierciseaux.lanceEpreuve().get(0).getPays().getmedailles_or() == 1)
        //    System.out.print("test getmedailles_or pass\n");
        //else System.out.println("test getmedailles_or fail\n");

    






    }
}



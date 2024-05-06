
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void PréparerLesEquipe() {
        Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
        Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
        
        assertEquals(1, 1);
    }





    /**
     * Athelete.
     */

    @Test
    public void testgetNomA() {
    
    Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
    Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
        
    assertEquals(bertrand.getNomA(), "Bertrand");
    //assertEquals(ginette.getNomA(), "Gynette");
    assertEquals(ginette.getNomA(), "Ginette");

    }

    @Test
    public void testgetPrenomA() {
        Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
        Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
            
        assertEquals(bertrand.getPrenomA(), "Richard");
       // assertEquals(ginette.getPrenomA(), "Dubais");
        assertEquals(ginette.getPrenomA(), "Dubois");

    }
    
    @Test
    public void testgetSexeA() {

        Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
        Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
            
        assertEquals(bertrand.getSexeA(), "H");
       // assertEquals(ginette.getSexeA(), "H");
        assertEquals(ginette.getSexeA(), "F");

    }

    @Test
    public void testgetgetAgilite() {

        Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
        Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
            
        assertEquals(bertrand.getAgilite(), 12);
       // assertEquals(ginette.getAgilite(), 22);
        assertEquals(ginette.getAgilite(), 21);

    }

    @Test
    public void testgetEndurance() {

        Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
        Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
            
        assertEquals(bertrand.getEndurance(), 5);
       // assertEquals(ginette.getEndurance(), 6);
        assertEquals(ginette.getEndurance(), 7);

    }

    @Test
    public void testgetForce() {

        Athlete bertrand = new Athlete("Bertrand", "Richard", "H", 12, 5, 30);
        Athlete ginette = new Athlete("Ginette", "Dubois", "F", 21, 7, 3);
            
        assertEquals(bertrand.getForce(), 30);
     //   assertEquals(ginette.getForce(), 1);
        assertEquals(ginette.getForce(), 3);

    }


}


//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculateurTVATest {
//    private  CalculateurTVA calc;
//    @BeforeEach
//    public void setUp() {
//        calc = new CalculateurTVA();
//        System.out.println("Creating calculator object");
//    }
//    @Test
//    public void testTVAMaroc() {
//        double resultat = calc.CalculerTVA(100, "Maroc");
//        assertEquals(20, resultat);
//    }
//    @Test
//    public void testTVAFrance() {
//        double resultat = calc.CalculerTVA(500, "France");
//        assertEquals(150, resultat);
//    }
//    @Test
//    public void testTVAEspagne() {
//        double resultat = calc.CalculerTVA(2000, "Espagne");
//        assertEquals(300, resultat);
//
//    }
//    @Test
//    public void testTVAEspagne1() {
//        double resultat = calc.CalculerTVA(900, "Espagne");
//        assertEquals(0, resultat);
//    }
//    @Disabled
//    @Test
//    public void testTVANonPrisEnCharge() {
//        IllegalArgumentException italie = assertThrows(IllegalArgumentException.class, () -> {
//            calc.CalculerTVA(1000, "Italie");
//        });
//    }
//    @Test
//    public void testTVANonPrisEnCharge2() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            calc.CalculerTVA(1000, "Italie");
//        });
//        assertEquals("Pays non pris en charge ", exception.getMessage());
//    }
//
//    @AfterEach
//    public void tearDown() {  // Libère après chaque test
//        calc = null;  // Set à null pour GC
//        System.out.println("Calculator object released");
//        System.out.flush();  // Force affichage
//    }
//}
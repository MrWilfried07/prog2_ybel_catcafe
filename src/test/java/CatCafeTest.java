import org.junit.Before;
import org.junit.Test;
import catcafe.CatCafe;
import catcafe.FelineOverLord;

import java.util.Optional;

import static org.junit.Assert.*;

public class CatCafeTest
{
    private CatCafe catCafe;

    @Before
    public void setUp()
    {
        catCafe = new CatCafe();
        catCafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        catCafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        catCafe.addCat(new FelineOverLord("Morticia", 3));
        catCafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));
    }

    @Test
    public void testCatCount()
    {
        // Überprüft, ob die Anzahl der hinzugefügten Katzen 4 beträgt
        // erwartetes Ergebnis: 4
        assertEquals(4, catCafe.getCatCount());
    }

    @Test
    public void testGetCatByExistingName() {
        // Sucht eine Katze mit einem existierenden Namen
        // Soll ein Optional mit der Katze zurückgeben
        // erwartetes Ergebnis: Optional ist vorhanden mit Namen "Miss Chief Sooky"
        Optional<FelineOverLord> cat = catCafe.getCatByName("Miss Chief Sooky");
        assertTrue(cat.isPresent());
        assertEquals("Miss Chief Sooky", cat.get().name());
    }

    @Test
    public void testGetCatByNonExistingName() {
        // Sucht eine Katze mit einem nicht existierenden Namen
        // Soll ein leeres Optional zurückgeben
        // erwartetes Ergebnis: Optional ist leer (isPresent == false)
        Optional<FelineOverLord> cat = catCafe.getCatByName("Unknown");
        assertFalse(cat.isPresent());
    }

    @Test
    public void testGetCatByWeightInRange() {
        // Sucht eine Katze mit Gewicht zwischen 3 und 4 (inklusive)
        // Soll ein Optional mit einer Katze mit Gewicht 3 oder 4 zurückgeben
        // erwartetes Ergebnis: Optional ist vorhanden mit Gewicht 3
        Optional<FelineOverLord> cat = catCafe.getCatByWeight(3, 4);
        assertTrue(cat.isPresent());
        assertEquals(3, cat.get().weight());
    }

    @Test
    public void testGetCatByWeightOutOfRange() {
        // Sucht eine Katze mit Gewicht zwischen 6 und 10 (inklusive)
        // keine Katze hat dieses Gewicht, daher leeres optional erwartet
        // erwartetes Ergebnis: Optional ist leer
        Optional<FelineOverLord> cat = catCafe.getCatByWeight(6, 10);
        assertFalse(cat.isPresent());
    }

    @Test
    public void testGetCatByWeightNegativeMin() {
        // Sucht eine Katze mit negativem Mindestgewicht (ungültig)
        // Soll leeres Optional zurückgeben, da Bereich ungültig ist
        // erwartetes Ergebnis: Optional ist leer
        Optional<FelineOverLord> cat = catCafe.getCatByWeight(-1, 5);
        assertFalse(cat.isPresent());
    }

    @Test
    public void testGetCatByWeightInvalidRange() {
        // Sucht eine Katze mit min > max (ungültiger Bereich)
        // Soll leeres Optional zurückgeben
        // Erwartetes Ergebnis: Optional ist leer
        Optional<FelineOverLord> cat = catCafe.getCatByWeight(5, 2);
        assertFalse(cat.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullCatThrowsException() {
        // Versucht, eine null-Katze hinzuzufügen
        // Soll eine NullPointerException werfen
    }

    @Test
    public void testGetCatByNullNameReturnsEmpty() {
        // Sucht eine Katze mit null als Name
        // Soll leeres Optional zurückgeben, ohne Ausnahme zu werfen
        // Erwartetes Ergebnis: Optional ist leer
        Optional<FelineOverLord> cat = catCafe.getCatByName(null);
        assertFalse(cat.isPresent());
    }

}

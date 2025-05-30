import catcafe.CatCafe;
import catcafe.FelineOverLord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CatCafeWeightTest {

    private final int minWeight;
    private final int maxWeight;
    private final boolean expectedPresent;

    private CatCafe cafe;

    public CatCafeWeightTest(int minWeight, int maxWeight, boolean expectedPresent) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.expectedPresent = expectedPresent;
    }

    @Before
    public void setUp() {
        cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));
    }

    @Parameterized.Parameters(name = "min={0}, max={1} → expectedPresent={2}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
            {1, 3, true},   // Match: weight = 2
            {3, 4, true},   // Match: weight = 3
            {4, 5, false},  // No match
            {5, 6, true},   // Match: weight = 5
            {-1, 2, false}, // Invalid minWeight
            {6, 4, false},  // Invalid range
            {0, 1, false}   // No cats that light
        });
    }

    @Test
    public void testGetCatByWeightRange() {
        Optional<FelineOverLord> result = cafe.getCatByWeight(minWeight, maxWeight);
        assertEquals(expectedPresent, result.isPresent());
    }
}

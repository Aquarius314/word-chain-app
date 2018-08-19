package algorithm;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlgoUtilsTest {

    @Test
    public void testCanBeNeighboursMethod() {
        String neighbour1 = "adam";
        String neighbour2 = "edam";
        String neighbour3 = "etam";
        assertTrue(AlgoUtils.canBeNeighbours(neighbour1, neighbour2));
        assertTrue(AlgoUtils.canBeNeighbours(neighbour2, neighbour1));
        assertTrue(AlgoUtils.canBeNeighbours(neighbour2, neighbour3));
        assertFalse(AlgoUtils.canBeNeighbours(neighbour1, neighbour3));
    }

    @Test
    public void testScoreMethod() {
        String word =   "abcde";
        String target = "aabbe";
        assertTrue(AlgoUtils.score(word, target) == 2);
    }
}

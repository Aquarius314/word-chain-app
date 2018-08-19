package algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphsContainerTest {

    private GraphsContainer graphsContainer;

    @Before
    public void setup() {
        graphsContainer = new GraphsContainer();
    }

    @Test
    public void testGraphsContainerAddIdenticalWords() {
        String word = "abc";
        graphsContainer.addWord(word);
        graphsContainer.addWord(word);
        assertFalse(graphsContainer.getWordNeighbours(word).contains(word));
        assertTrue(graphsContainer.getWordNeighbours(word).isEmpty());
    }

    @Test
    public void testGraphsContainerAddWord() {
        List<String> words = Arrays.asList("ada", "aba", "abd", "abd");
        words.forEach(graphsContainer::addWord);
        assertTrue(graphsContainer.getWordNeighbours("ada").contains("aba"));
        assertTrue(graphsContainer.getWordNeighbours("ada").contains("aba"));
        assertFalse(graphsContainer.getWordNeighbours("ada").contains("abd"));
        assertFalse(graphsContainer.getWordNeighbours("abd").contains("abd"));
    }

}

package algorithm;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordChainSolverTest {

    private WordChainSolver solver;

    @Before
    public void setup() throws IOException {
        File wordsTestFile = new File("src/test/resources/wordstest.txt");
        solver = WordChainSolverBuilder.build(wordsTestFile);
    }

    @Test
    public void testSolverGraphCreation() {
        assertTrue(solver.getGraphsContainer().getWordNeighbours("cat").contains("cot"));
        assertFalse(solver.getGraphsContainer().getWordNeighbours("cat").contains("cat"));
    }

    @Test
    public void testSolverOutput() {
        List<String> wordChain = solver.getWordChain("cat", "dog");
        List<String> expectedChain = Arrays.asList("cat", "cot", "cog", "dog");
        assertTrue(wordChain.equals(expectedChain));
    }

    @Test
    public void testSolverReversibleInput() {
        assertFalse(solver.getWordChain("cat", "dog")
                .equals(solver.getWordChain("dog", "cat")));
        List<String> solution1 = solver.getWordChain("cat", "dog");
        solution1.sort(Comparator.naturalOrder());
        List<String> solution2 = solver.getWordChain("dog", "cat");
        solution2.sort(Comparator.naturalOrder());
        assertTrue(solution1.equals(solution2));
    }

    @Test
    public void testSolverTimeEquality() {
        long firstStartTime = System.currentTimeMillis() - 1;
        solver.getWordChain("cat", "dog");
        long firstExecutionTime = System.currentTimeMillis() - firstStartTime;
        long secondStartTime = System.currentTimeMillis() - 1;
        solver.getWordChain("dog", "cat");
        long secondExecutionTime = System.currentTimeMillis() - secondStartTime;
        assertTrue(firstExecutionTime / secondExecutionTime < 1.4);
        assertTrue(0.6 < firstExecutionTime / secondExecutionTime);
    }

}

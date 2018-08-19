package algorithm;

import java.util.Arrays;
import java.util.List;

public class WordChainSolver {

    private GraphsContainer graphsContainer;

    WordChainSolver(GraphsContainer graphsContainer) {
        this.graphsContainer = graphsContainer;
    }

    public List<String> getWordChain(String start, String end) {

        return Arrays.asList(start, end);
    }

    public GraphsContainer getGraphsContainer() {
        return graphsContainer;
    }

}

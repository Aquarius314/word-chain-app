package algorithm;

import java.util.*;

public class WordChainSolver {

    private GraphsContainer graphsContainer;

    WordChainSolver(GraphsContainer graphsContainer) {
        this.graphsContainer = graphsContainer;
    }

    public List<String> getWordChain(String start, String end) {
        return solveWithWavePropagationAlgorithm(start, end);
    }

    private List<String> solveWithWavePropagationAlgorithm(String start, String end) {
        Set<String> checkedWords = new HashSet<>();
        LinkedList<LinkedList<String>> iterations = new LinkedList<>();
        iterations.add(new LinkedList<>());
        iterations.get(0).add(start);
        for(int i = 0; i < 100; i++) {
            iterations.add(new LinkedList<>());
            for(String node : iterations.get(i)) {
                checkedWords.add(node);
                for(String neighbour : graphsContainer.getWordNeighbours(node)) {
                    if (!checkedWords.contains(neighbour)) {
                        iterations.get(i + 1).add(neighbour);
                    }
                }
            }
            if (iterations.get(i + 1).contains(end)) {
                return reversedPath(iterations, end);
            }
        }
        System.out.println("Couldn't find solution in less than 100 iterations!");
        return new LinkedList<>();
    }

    private List<String> reversedPath(LinkedList<LinkedList<String>> iterations, String end) {
        Collections.reverse(iterations);
        LinkedList<String> path = new LinkedList<>();
        path.add(end);
        iterations.remove(0);
        for(LinkedList<String> iteration : iterations) {
            Set<String> currentNeighbours = graphsContainer.getWordNeighbours(end);
            for(String node : iteration) {
                if (currentNeighbours.contains(node)) {
                    end = node;
                    path.add(end);
                    break;
                }
            }
        }
        Collections.reverse(path);
        return path;
    }

    public GraphsContainer getGraphsContainer() {
        return graphsContainer;
    }

}

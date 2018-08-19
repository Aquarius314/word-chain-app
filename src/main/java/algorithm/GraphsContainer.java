package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphsContainer {

    Map<Integer, HashMap<String, Set<String>>> mapOfGraphs = new HashMap<>();

    public void addWord(String word) {
        int len = word.length();
        mapOfGraphs.putIfAbsent(len, new HashMap<>());
        HashSet<String> neighbours = getNewNeighbours(word);
        updateNeighbours(neighbours, word);
        mapOfGraphs.get(len).putIfAbsent(word, neighbours);
    }

    public Set<String> getWordNeighbours(String word) {
        return mapOfGraphs.get(word.length()).get(word);
    }

    private HashSet<String> getNewNeighbours(String word) {
        return mapOfGraphs
                .get(word.length())
                .keySet()
                .stream()
                .filter(w -> AlgoUtils.canBeNeighbours(w, word))
                .collect(Collectors.toCollection(HashSet::new));
    }

    private void updateNeighbours(HashSet<String> neighbours, String newWord) {
        neighbours.forEach(w -> mapOfGraphs.get(w.length())
                .get(w)
                .add(newWord)
        );
    }

}

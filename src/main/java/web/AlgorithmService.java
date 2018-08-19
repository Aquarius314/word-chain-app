package web;

import algorithm.WordChainSolver;
import algorithm.WordChainSolverBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class AlgorithmService {

    private final Map<Integer, WordChainSolver> differentLengthSolvers = new HashMap<>();

    public AlgorithmService() {
        System.out.println("Starting algo service");
        for(int i = 1; i < 30; i++) {
            try {
                File inputFile = new File("src/main/resources/separated/words-len-" + i + ".txt");
                WordChainSolver solver = WordChainSolverBuilder.build(inputFile);
                differentLengthSolvers.put(i, solver);
            } catch (IOException e) {
                System.out.println("No file for " + i + "-letters long words!");
            }
        }
    }

    public List<String> getSolution(String startWord, String endWord) {
        if (startWord.length() != endWord.length()) {
            return Collections.singletonList("Invalid input! Please provide 2 words of same length!");
        }
        return differentLengthSolvers.get(startWord.length()).getWordChain(startWord, endWord);
    }

}

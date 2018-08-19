package web;

import algorithm.WordChainSolver;
import algorithm.WordChainSolverBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class AlgorithmService {

    private static final int MIN_WORDS_LENGTH = 2;
    private static final int MAX_WORDS_LENGTH = 5;
    private final Map<Integer, WordChainSolver> differentLengthSolvers = new HashMap<>();

    public AlgorithmService() {
        System.out.println("Starting algo service");
        for(int i = MIN_WORDS_LENGTH; i <= MAX_WORDS_LENGTH; i++) {
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
            throw new IllegalArgumentException("Invalid input! Please provide 2 words of same length!");
        }
        if (startWord.length() > MAX_WORDS_LENGTH || startWord.length() < MIN_WORDS_LENGTH) {
            throw new IllegalArgumentException("Invalid input! Words must be between " +
                    MIN_WORDS_LENGTH + " and " + MAX_WORDS_LENGTH + " letters length!");
        }
        return differentLengthSolvers.get(startWord.length()).getWordChain(startWord, endWord);
    }

}

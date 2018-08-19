package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordChainSolverBuilder {

    private WordChainSolverBuilder() {}

    public static WordChainSolver build(File wordListFile) throws IOException {
        GraphsContainer graphsContainer = new GraphsContainer();

        BufferedReader b = new BufferedReader(new FileReader(wordListFile));
        String readLine;
        while ((readLine = b.readLine()) != null) {
            graphsContainer.addWord(readLine.toLowerCase());
        }
        System.out.println("Finished reading dictionary: " + wordListFile.getName());

        return new WordChainSolver(graphsContainer);
    }
}

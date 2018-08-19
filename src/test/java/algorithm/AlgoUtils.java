package algorithm;

public class AlgoUtils {

    public static boolean canBeNeighbours(String word1, String word2) {
        return score(word1, word2) == 1;
    }

    public static int score(String word, String target) {
        if (word.length() != target.length()) {
            throw new IllegalArgumentException("Cannot calculate score for different length words!");
        }
        int differentChars = 0;
        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                differentChars++;
            }
        }
        return differentChars;
    }

}

package util;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class FilePreparator {

    public static void prepareFiles(String inputFile, String destination) throws IOException {
        HashMap<Integer, LinkedList<String>> listsOfWords = new HashMap<>();

        File f = new File(inputFile);
        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine;
        while ((readLine = b.readLine()) != null) {
            int len = readLine.length();
            if (!listsOfWords.containsKey(len)) {
                listsOfWords.put(len, new LinkedList<>());
            }
            listsOfWords.get(len).add(readLine);
        }

        System.out.println("Finished reading dictionary");

        listsOfWords.keySet().forEach( key -> {
            try {
                File fout = new File(destination + "/words-len-" + key + ".txt");
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                listsOfWords.get(key).forEach( word -> {
                    try {
                        bw.write(word);
                        bw.newLine();
                    } catch (IOException e) {e.printStackTrace();}
                });
                System.out.println("Finished saving " + key + "-long words.");
            } catch (FileNotFoundException e) {e.printStackTrace();}
        });
    }

}

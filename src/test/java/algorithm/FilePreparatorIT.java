package algorithm;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.After;
import org.junit.Test;
import util.FilePreparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class FilePreparatorIT {

    @Test
    public void testFilePreparatorOutputFiles() throws IOException {
        FilePreparator.prepareFiles("resources/wordlist.txt", "src/test/resources/filepreparator");
        File f = new File("src/test/resources/filepreparator/words-len-3.txt");
        checkFileWordsLength(f);
    }

    private void checkFileWordsLength(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int recordsLimit = 100;
        int i = 0;
        String readLine = br.readLine();
        while (readLine != null && i < recordsLimit) {
            int len = readLine.length();
            assertTrue(len == 3);
            i++;
            readLine = br.readLine();
        }
    }

    @After
    public void cleanCreatedFiles() throws IOException {
        FileUtils.cleanDirectory(new File("src/test/resources/filepreparator"));
    }

}

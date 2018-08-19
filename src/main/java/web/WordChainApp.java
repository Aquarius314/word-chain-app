package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import util.FilePreparator;

import java.io.IOException;

@SpringBootApplication
@ComponentScan("web/")
public class WordChainApp {

    public static void main(String[] args) {
        try {
            FilePreparator.prepareFiles("src/main/resources/wordlist.txt", "src/main/resources/separated");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(WordChainApp.class, args);
    }

}
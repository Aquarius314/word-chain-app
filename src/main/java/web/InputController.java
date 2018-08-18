package web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class InputController {

    @RequestMapping("/{startWord}/{endWord}")
    public String getWordChain(@PathVariable String startWord, @PathVariable String endWord) {
        return startWord + " -> " + endWord;
    }

}
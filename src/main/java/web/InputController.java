package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class InputController {

    @Autowired
    private AlgorithmService algorithmService;

    @RequestMapping("/{startWord}/{endWord}")
    public List<String> getWordChain(@PathVariable String startWord, @PathVariable String endWord) {
        return algorithmService.getSolution(startWord, endWord);
    }

}
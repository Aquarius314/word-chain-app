package web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=InputController.class)
@AutoConfigureMockMvc
public class InputControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testInputControllerResponseStatus() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/word1/word2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testInputControllerEmptyUrlResponseStatus() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().is4xxClientError());
    }
}
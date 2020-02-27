package fr.webnet.test.exposition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWebnetIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_welcome_to_the_jungle_when_call_hello() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/hello"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        assertThat(result.getResponse().getContentAsString()).isEqualTo("Welcome to the Webnet jungle");
    }
}

package fr.webnet.test.exposition.language;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.webnet.test.exposition.language.dto.LanguageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class LanguageApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_return_welcome_to_the_jungle_when_call_hello() throws Exception {
        LanguageDTO javaLanguage = new LanguageDTO("Java", "The master language !");
        LanguageDTO dotnetLanguage = new LanguageDTO(".NET", "The master language !");
        LanguageDTO javascriptLanguage = new LanguageDTO("Javascript", "The master language !");
        LanguageDTO phpLanguage = new LanguageDTO("Php", "The master language !");
        List<LanguageDTO> expectedList = Arrays.asList(javaLanguage, dotnetLanguage, javaLanguage, phpLanguage);
        MvcResult result = this.mockMvc.perform(get("/languages"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        List<LanguageDTO> languages = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<LanguageDTO>>(){});
        assertThat(languages).isNotNull();
        assertThat(languages).containsAll(expectedList);
    }
}

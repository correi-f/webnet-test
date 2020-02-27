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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LanguageApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_return_welcome_to_the_jungle_when_call_hello() throws Exception {
        LanguageDTO javaLanguage = new LanguageDTO("Java", "Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.");
        LanguageDTO dotnetLanguage = new LanguageDTO(".NET", ".NET Framework is a software framework developed by Microsoft that runs primarily on Microsoft Windows.");
        LanguageDTO javascriptLanguage = new LanguageDTO("Javascript", "JavaScript, often abbreviated as JS, is an interpreted programming language that conforms to the ECMAScript specification.");
        LanguageDTO phpLanguage = new LanguageDTO("Php", "PHP is a popular general-purpose scripting language that is especially suited to web development.");
        List<LanguageDTO> expectedList = Arrays.asList(javaLanguage, dotnetLanguage, javascriptLanguage, phpLanguage);
        MvcResult result = this.mockMvc.perform(get("/languages"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        List<LanguageDTO> languages = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<LanguageDTO>>(){});
        assertThat(languages).isNotNull();
        assertThat(languages).containsAnyElementsOf(expectedList);
    }


}

package ${customPackage}.controller;

import ${customPackage}.domain.SampleDomain;
import ${customPackage}.dto.InputDTO;
import ${customPackage}.dto.OutputDTO;
import ${customPackage}.exception.ValidateRegisterException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class auto-generated by archetype-spring project
 * Repository: http://californio.keynet.com.br:8089/java/archetype/archetype-spring
 */
@WebMvcTest(SampleController.class)
class SampleControllerTest {

    private static final String DEFAULT_NAME = "Guilherme Biff Zarelli";
    private static final int DEFAULT_AGE = 28;
    private static final int DEFAULT_ID_OUTPUT_DTO = 100;
    private static final String MESSAGE_VALIDATE_EXCEPTION = "invalid age";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleDomain sampleDomain;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void should_return_default_message_on_home_page() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString(SampleController.HOME_MESSAGE)));
    }

    @Test
    void test_post_method_with_success() throws Throwable {
        InputDTO inputDTO = new InputDTO(DEFAULT_NAME, DEFAULT_AGE);
        OutputDTO outputDTO = new OutputDTO(DEFAULT_ID_OUTPUT_DTO);
        Mockito.when(sampleDomain.process(inputDTO)).thenReturn(outputDTO);
        this.mockMvc.perform(post("/")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(inputDTO)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(outputDTO)));
    }

    @Test
    void test_bad_request_with_validate_register_exception() throws Throwable {
        InputDTO inputDTO = new InputDTO(DEFAULT_NAME, DEFAULT_AGE);
        Mockito.when(sampleDomain.process(inputDTO)).thenThrow(new ValidateRegisterException(MESSAGE_VALIDATE_EXCEPTION));
        this.mockMvc.perform(post("/")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(inputDTO)))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString(MESSAGE_VALIDATE_EXCEPTION)))
                .andExpect(content().string(Matchers.containsString(ValidateRegisterException.class.getSimpleName())));
    }
}

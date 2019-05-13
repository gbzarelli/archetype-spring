package ${customPackage}.domain;

import ${customPackage}.dto.InputDTO;
import ${customPackage}.dto.OutputDTO;
import ${customPackage}.exception.ValidateRegisterException;
import ${customPackage}.model.entity.SampleEntity;
import ${customPackage}.service.SampleService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Class auto-generated by archetype-spring project
 * Repository: http://californio.keynet.com.br:8089/java/archetype/archetype-spring
 */
@SpringBootTest
@AutoConfigureMockMvc
class SampleDomainTest {

    private static final SampleEntity SAMPLE_ENTITY = new SampleEntity(1, "Guilherme Biff Zarelli", 28);

    @Autowired
    private SampleDomain sampleDomain;

    @MockBean
    private SampleService sampleService;

    @Test
    void contextLoad() {
        Assertions.assertNotNull(sampleDomain);
    }

    @Test
    void test_if_register_method_returns_the_correct_OutputDTO() throws Throwable {
        InputDTO inputDTO = Mockito.mock(InputDTO.class);
        Mockito.when(sampleService.register(ArgumentMatchers.any())).thenReturn(SAMPLE_ENTITY);
        OutputDTO outputDTO = sampleDomain.process(inputDTO);
        Assertions.assertEquals(outputDTO.getId(), SAMPLE_ENTITY.getId());
    }

    @Test
    void assert_ValidateRegisterException_on_return_method_and_log() throws Throwable {
        Mockito.when(sampleService.register(ArgumentMatchers.any())).thenThrow(new ValidateRegisterException());
        Assertions.assertThrows(ValidateRegisterException.class, () -> sampleDomain.process(Mockito.mock(InputDTO.class)));
    }

}

package ${customPackage};

import ${customPackage}.settings.bean.AppConfigurationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Properties;

import static ${customPackage}.settings.bean.AppConfigurationTest.BEAN_TEST;
import static ${customPackage}.util.ApplicationConst.*;
import static ${customPackage}.util.SystemPropertiesConst.SPRING_PROFILES_ACTIVE;

/**
 * Class auto-generated by archetype-spring project
 * Repository: http://californio.keynet.com.br:8089/java/archetype/archetype-spring
 * <p>
 * Classe de teste responsável em testar a geração da estrutura do projeto pelo archetype.
 * Realiza tetes de beens de testes, properties para versão gerada e profile de teste;
 */
@AutoConfigureMockMvc
@SpringBootTest(classes = {AppConfigurationTest.class})
@ActiveProfiles(PROFILE_TEST)
class PropertiesTest {

    private static final String FILENAME_TEST_PROPERTIES = "${artifactIdLower}-test.properties";

    @Autowired
    @Qualifier(BEAN_TEST)
    private String stringTest;

    @Autowired
    private Properties systemProperties;

    @Value(KEY_SYSTEM_PROPERTIES_PATH)
    private String systemPropertiesPath;

    @Value(KEY_APPLICATION_VERSION)
    private String applicationVersion;

    @Test
    void verify_if_AppConfigurationTests_has_been_successfully_loaded() {
        Assertions.assertEquals(stringTest, AppConfigurationTest.BEAN_TEST_DEFAULT_VALUE);
    }

    @Test
    void verify_if_application_properties_has_been_loaded_with_test_profile() {
        Assertions.assertTrue(systemPropertiesPath.endsWith(applicationVersion + "/" + FILENAME_TEST_PROPERTIES));
    }

    @Test
    void verify_if_external_system_properties_has_been_successfully_loaded() {
        Assertions.assertEquals(systemProperties.getProperty(SPRING_PROFILES_ACTIVE), PROFILE_TEST);
    }
}

package ${customPackage};

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Properties;

import static ${customPackage}.util.AppConsts.*;

@AutoConfigureMockMvc
@SpringBootTest(classes = {AppConfigurationTest.class})
@ActiveProfiles(PROFILE_TEST)
class ${artifactId}Test {

    @Autowired
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
        Assertions.assertTrue(systemPropertiesPath.endsWith(applicationVersion + "/${artifactIdLower}-test.properties"));
    }

    @Test
    void verify_if_external_system_properties_has_been_successfully_loaded() {
        Assertions.assertEquals(systemProperties.getProperty("spring.profiles.active"), PROFILE_TEST);
    }
}

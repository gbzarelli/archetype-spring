package ${customPackage};

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AppConfigurationTest {
    static final String BEAN_TEST = "stringTest";
    static final String BEAN_TEST_DEFAULT_VALUE = "Bean Test AppConfigurationsTest";

    @Bean(BEAN_TEST)
    public String loadBeanTest() {
        return BEAN_TEST_DEFAULT_VALUE;
    }
}

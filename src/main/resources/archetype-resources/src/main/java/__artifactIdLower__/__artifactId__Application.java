package ${customPackage};

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static ${customPackage}.util.AppConsts.*;

@SpringBootApplication
public class ${artifactId}Application {

    public static void main(String[] args) {
        SpringApplication.run(${artifactId}Application.class, args);
    }

    @Value(KEY_APPLICATION_VERSION)
    private String applicationVersion;

    @Value(KEY_SYSTEM_PROPERTIES_PATH)
    private String systemPropertiesPath;

    @Bean(BEAN_SYSTEM_PROPERTIES)
    @Primary
    public Properties loadSystemProperties() throws IOException{
        Properties properties=new Properties();
        properties.load(new FileInputStream(new File(Objects.requireNonNull(systemPropertiesPath))));
        return properties;
    }

}

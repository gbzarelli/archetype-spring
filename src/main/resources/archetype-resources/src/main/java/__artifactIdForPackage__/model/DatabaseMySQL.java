package ${customPackage}.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DatabaseMySQL {
    public static final String PROPERTIES_KEY_URL = "url";
    public static final String PROPERTIES_KEY_DATABASE = "database";
    public static final String PROPERTIES_KEY_USER = "user";
    public static final String PROPERTIES_KEY_PASSWORD = "password";
    public static final String PROPERTIES_KEY_TIME_ZONE = "time_zone";
    public static final String PROPERTIES_KEY_TIMEOUT_CONNECTION = "connectTimeout";
    public static final String PROPERTIES_KEY_TIMEOUT_SOCKET = "socketTimeout";

    private Properties config;

    public DatabaseMySQL(Properties config) {
        this.config = config;
    }

    public Connection getConnection() throws Exception {
        String url = config.getProperty("url");
        int timeoutConnectionValue = Integer.valueOf(config.getProperty("connectTimeout", "10000"));
        if (!url.contains("connectTimeout")) {
            String concat = "connectTimeout=" + timeoutConnectionValue;
            if (!url.contains("?")) {
                url = url + "?" + concat;
            } else {
                url = url + "&" + concat;
            }
        }

        int timeoutSocketValue = Integer.valueOf(config.getProperty("socketTimeout", "20000"));
        if (!url.contains("socketTimeout")) {
            String concat = "socketTimeout=" + timeoutSocketValue;
            if (!url.contains("?")) {
                url = url + "?" + concat;
            } else {
                url = url + "&" + concat;
            }
        }

        return DriverManager.getConnection(url, config.getProperty("user"), config.getProperty("password"));
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }
}

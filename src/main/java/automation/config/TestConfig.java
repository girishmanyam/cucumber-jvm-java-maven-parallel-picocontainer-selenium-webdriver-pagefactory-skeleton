package automation.config;

import java.io.*;
import java.util.Properties;

public class TestConfig {
    private static TestConfig testConfig;
    private static String requiredEnvironmentName;
    private static Properties properties;

    public static String valueFor(final String keyName) throws IOException {
        return getInstance().getProperty(keyName);
    }

    private static TestConfig getInstance() throws IOException {
        if(testConfig == null) {
            requiredEnvironmentName = System.getProperty("env", "local");
            populateEnvPropertyDetails(requiredEnvironmentName);
            testConfig = new TestConfig();
        }
        return testConfig;
    }

    private static void populateEnvPropertyDetails(final String requiredEnvironment) throws IOException {
        String propertiesFilePath = String.format("src/test/resources/config/%s.properties", requiredEnvironment);
        File propertiesFile = new File(propertiesFilePath);
        if(!propertiesFile.exists()) {
            throw new FileNotFoundException(
                    String.format("No environment properties file for environment: %s", requiredEnvironment));
        }
        InputStream input = new FileInputStream(propertiesFilePath);
        properties = new Properties();
        properties.load(input);
        input.close();

    }

    private String getProperty(final String keyName) {
        String value = properties.getProperty(keyName);
        if(value == null) {
            throw new Error(String.format("Key %s not configured for environment %s", keyName, requiredEnvironmentName));
        }
        return value;
    }
}

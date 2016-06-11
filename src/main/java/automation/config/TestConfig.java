package automation.config;

import java.io.*;
import java.util.Properties;

public class TestConfig {
    private static TestConfig testConfig;
    private static String requiredEnvironmentName;
    private static Properties properties;

    public static String valueFor(final String keyName) throws Throwable {
        return getInstance().getProperty(keyName);
    }

    private static TestConfig getInstance() throws Throwable {
        if (testConfig == null) {
            properties = new Properties();
            requiredEnvironmentName = System.getProperty("env", "local");
            populateCommonProperties();
            populateEnvProperties(requiredEnvironmentName);
            testConfig = new TestConfig();
        }
        return testConfig;
    }

    private static void populateCommonProperties() throws Throwable {
        readInPropertiesFile("common");
    }

    private static void populateEnvProperties(final String requiredEnvironment) throws Throwable {
        readInPropertiesFile(requiredEnvironment);
    }

    private static void readInPropertiesFile(String filePath) throws Throwable {
        String propertiesFilePath = String.format("src/test/resources/config/%s.properties", filePath);
        File propertiesFile = new File(propertiesFilePath);
        if(!propertiesFile.exists()) {
            throw new FileNotFoundException(
                    String.format("No properties file found at: %s", filePath));
        }
        InputStream input = new FileInputStream(propertiesFilePath);
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

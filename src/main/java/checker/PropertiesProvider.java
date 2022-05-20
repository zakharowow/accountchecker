package checker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static checker.ExceptionAssistant.writeExceptionInLog;


public class PropertiesProvider {
    public static String getConfigProperty(String propertyName) {
        Properties properties = new Properties();
        String propertyValue = "";
        String propertyPath = Objects.requireNonNull(PropertiesProvider.class.getResource("/config.properties")).getFile();
        try (FileInputStream fis = new FileInputStream(propertyPath)) {
            properties.load(fis);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            writeExceptionInLog(e);
        }
        return propertyValue == null ? "" : propertyValue;
    }
}

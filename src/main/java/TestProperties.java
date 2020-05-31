import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private Properties properties = new Properties();

    private static TestProperties INSTANCE = null;

    private TestProperties(){
        try {
            properties.load(new FileInputStream(new File("src/test/resources/" +
                    System.getProperty("environment") + ".properties")));
        } catch (IOException e) {
            throw new RuntimeException("не удалось найти файл!" +e.getMessage());
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }








    public Properties getProperties() {
        return properties;
    }

}

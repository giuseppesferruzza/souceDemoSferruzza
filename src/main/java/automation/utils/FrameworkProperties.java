package automation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String Key) {
        try {
            Properties properties = new Properties();
            String propFileName = Constants.PROPERTIES_FILE_NAME;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if ( inputStream != null)
                properties.load(inputStream);
            else
                throw new FileNotFoundException("The Property file has not been found");

            String propertyValue = properties.getProperty(Key);
            this.result = propertyValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

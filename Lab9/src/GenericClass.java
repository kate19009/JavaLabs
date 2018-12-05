import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystemException;
import java.util.Properties;

public class GenericClass<T>
{
    String result="";
    InputStream inputStream;
    InputStream inputStream1;
    public String getPropValues(String propFileName, String key) throws IOException {
        try
        {

            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            inputStream1 = getClass().getClassLoader().getResourceAsStream(propFileName);

                 if (inputStream != null || inputStream1 != null) {
                    prop.load(inputStream1);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }
                result = "Stream1. Value of " + key + " is " + prop.getProperty(key);
                System.out.println(result);
                result = "Stream2. Value of " + key + " is " + prop.getProperty(key);
                System.out.println(result + '\n');
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        finally
        {
            inputStream.close();
            inputStream1.close();
        }
        return result;
    }
}

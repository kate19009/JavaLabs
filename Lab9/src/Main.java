import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String propFileName = "config.properties";
        GenericClass<String>  example = new GenericClass<>();
        example.getPropValues(propFileName,"key2");
        example.getPropValues(propFileName,"key4");
        example.getPropValues(propFileName,"key3");
        example.getPropValues(propFileName,"key1");
    }
}

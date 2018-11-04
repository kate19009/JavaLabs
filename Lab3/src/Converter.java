import java.util.ArrayList;

public class Converter
{
    public static <T> ArrayList<T> convertArray(T[] notConvertedArray)
    {
        ArrayList<T> newArr = new ArrayList<>();
        for (int i = 0; i < notConvertedArray.length; i++)
        {
            newArr.add(notConvertedArray[i]);
        }
        return newArr;
    }
}

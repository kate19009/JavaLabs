import java.util.ArrayList;
import java.util.Iterator;

public class Main
{
    public static void PrintInf(ArrayList justPrint)
    {
        for (int i = 0; i < justPrint.size(); i++)
        {
            System.out.print(justPrint.get(i));
            System.out.print(' ');
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Integer [] intArr = {1,2,3,5};
        Double [] doublArr = {1.5,2.3,3.4,5.6};
        Character [] charArr = {'b','h','a','f'};
        Boolean [] boolArr = {true, false, false};
        ArrayList convertedArr = new ArrayList();
        convertedArr = Converter.convertArray(intArr);
        PrintInf(convertedArr);
        convertedArr = Converter.convertArray(doublArr);
        PrintInf(convertedArr);
        convertedArr = Converter.convertArray(boolArr);
        PrintInf(convertedArr);
        convertedArr = Converter.convertArray(charArr);
        PrintInf(convertedArr);
    }
}
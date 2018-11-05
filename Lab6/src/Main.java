import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {

        MyList<String> firList = new MyList<>();
        firList.add("first");
        firList.add("lab");
        firList.add("example");

        Iterator<String> itEx = firList.iterator();
        while (itEx.hasNext())
        {
            System.out.println(itEx.next());
        }


        MyList<String> secList = new MyList<>();
        secList.add("aaa");
        secList.add("bbb");
        secList.add("ccc");

        MyList.StaticIterator<String> staticExample = new MyList.StaticIterator<>(secList);
        while (staticExample.hasNext())
        {
            System.out.println(staticExample.next());
        }


        MyList<String> thList = new MyList<>();

        thList.add("how");
        thList.add("are");
        thList.add("you");
        MyList<String>.InnerIterator newList = thList.new InnerIterator();
        while (newList.hasNext())
        {
            System.out.println(newList.next());
        }

    }
}

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Stream byteStream = new Stream("/Users/stevenpauljobs/IdeaProjects/Lab7.1/src/Text.txt");
            byteStream.readWrite();

        } catch (Exception error)
        {
            error.printStackTrace();
        }
    }
}

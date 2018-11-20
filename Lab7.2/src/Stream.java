import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Stream
{
    private String fileName_ = "";
    public ArrayList<Container> words_ = new ArrayList<Container>();

    public Stream(String fileName)
    {
        fileName_ = fileName;
    }

    public void readWrite()
    {
        try (FileReader inStream = new FileReader(fileName_);
             FileWriter outStream = new FileWriter("New text.txt"))
        {
            String buffer = "";
            int temp = 0;
            while ((temp = inStream.read()) != -1)
            {
                buffer += (char)temp;
            }
            String[] textInArray = buffer.split("\\s");
            int counter = 0;
            for (String word : textInArray)
            {
                if (Utils.isKeyword(word))
                {
                    counter++;
                    if (words_.isEmpty())
                    {
                        Container tmp = new Container(word, 1);
                        words_.add(tmp);
                    } else {
                        boolean flag = false;
                        for (Container s: words_)
                        {
                            if (s.value_.equals(word))
                            {
                                s.total_ ++;
                                flag = true;
                                break;
                            }
                        }
                        if (!flag)
                        {
                            Container tmp = new Container(word, 1);
                            words_.add(tmp);
                        }
                    }
                }
            }
            outStream.write("Total words ");
            outStream.write(Integer.toString(counter));
            outStream.write("\n");
            for (Container s: words_) {
                if (s.total_ == 1) {
                    outStream.write("'");
                    outStream.write(s.value_);
                    outStream.write("' use ");
                    outStream.write(Integer.toString(s.total_));
                    outStream.write(" time\n");
                } else {
                    outStream.write("'");
                    outStream.write(s.value_);
                    outStream.write("' use ");
                    outStream.write(Integer.toString(s.total_));
                    outStream.write(" times\n");
                }
            }
        }
        catch (FileNotFoundException error)
        {
            error.printStackTrace();
        }
        catch (IOException error)
        {
            error.printStackTrace();
        }
    }

}
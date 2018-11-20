import java.util.ArrayList;
import java.io.*;

public class Stream
{
    private String fileName_;
    public ArrayList<Container> words_ = new ArrayList<Container>();

    Stream(String fileName)
    {
        fileName_ = fileName;
    }

    public void readWrite()
    {
        try (FileInputStream inStream = new FileInputStream(fileName_);
             FileOutputStream outStream = new FileOutputStream("New text.txt"))
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
                    } else
                        {
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
            outStream.write("Total words ".getBytes());
            outStream.write(Integer.toString(counter).getBytes());
            outStream.write("\n".getBytes());
            for (Container s: words_)
            {
                if (s.total_==1)
                {
                    outStream.write("'".getBytes());
                    outStream.write(s.value_.getBytes());
                    outStream.write("' use ".getBytes());
                    outStream.write(Integer.toString(s.total_).getBytes());
                    outStream.write(" time\n".getBytes());
                }
                else
                 {
                    outStream.write("'".getBytes());
                    outStream.write(s.value_.getBytes());
                    outStream.write("' use ".getBytes());
                    outStream.write(Integer.toString(s.total_).getBytes());
                    outStream.write(" times\n".getBytes());
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

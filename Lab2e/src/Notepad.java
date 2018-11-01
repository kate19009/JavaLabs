import java.util.Scanner;

public class Notepad
{
    String[] notes = new String[100];
    int last = 0;
    public void addNote()
    {
        System.out.println("Enter new node");
        Scanner inn = new Scanner(System.in);
        String note = inn.next();
        if (last > notes.length)
        {
            throw new NullPointerException("Error");
        }
        this.notes[this.last++] = note;
    }
    public void showAllNotes()
    {
        if (notes.length == 0)
        {
            throw new NullPointerException("Error");
        }
        else
        {
            for (int i = 0; i < this.last; i++)
            {
                System.out.println(this.notes[i]);
            }
        }
    }
}

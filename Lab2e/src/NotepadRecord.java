import java.util.Scanner;

public class NotepadRecord extends Notepad
{
    public void deleteNote()
    {
        System.out.println("What note do you want delete?");
        Scanner in = new Scanner(System.in);
        int position = in.nextInt();
        if (notes.length == 0 || notes.length < position)
        {
            try
            {
                throw new NullPointerException("Error");
            }
            catch(NullPointerException e)
            {
                System.out.println("Error! Change input data");
            }
        }
        else
        {
            System.arraycopy(
                    this.notes, position + 1, this.notes,
                    position, this.last - position);
            this.last--;
        }
    }
    public void editNote()
    {
        System.out.println("What note do you want change?");
        Scanner in = new Scanner(System.in);
        int position = in.nextInt();
        System.out.println("Enter a new note");
        Scanner inn = new Scanner(System.in);
        String note = inn.next();
        if (notes.length == 0 || notes.length < position)
        {
             try
            {
                throw new NullPointerException("Error");
            }
            catch(NullPointerException e)
            {
                System.out.println("Error! Change input data");
            }
        }
        else
        {

            this.notes[position] = note;
        }
    }
}

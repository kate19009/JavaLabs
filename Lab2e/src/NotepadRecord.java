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
            throw new NullPointerException("Error");
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
        Scanner inn = new Scanner(System.in);
        String note = inn.next();
        System.out.println("Enter a new note");
        Scanner in = new Scanner(System.in);
        int position = in.nextInt();
        if (notes.length == 0 || notes.length < position)
        {
            throw new NullPointerException("Error");
        }
        else
        {

            this.notes[position] = note;
        }
    }
}

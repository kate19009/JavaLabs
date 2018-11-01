import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        NotepadRecord firstNotepad = new NotepadRecord();
        boolean shouldBreak = true;
        while (shouldBreak)
        {
            System.out.println("Choose what to do");
            System.out.println("1 - Add note");
            System.out.println("2 - Delete note");
            System.out.println("3 - Edit note");
            System.out.println("4 - Show all notes");
            System.out.println("5 - Exit");
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            switch (k) {
                case 1:
                    firstNotepad.addNote();
                    break;
                case 2:
                    firstNotepad.deleteNote();
                    break;
                case 3:
                    firstNotepad.editNote();
                    break;
                case 4:
                    firstNotepad.showAllNotes();
                    break;
                case 5:
                    shouldBreak = false;
                    break;
                default:
                    System.out.print("Error!");
                    break;
            }
        }
    }
}
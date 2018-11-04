
/**
 * @author Kate Zabrodina
 * @version 1.1
 */

public class NuclearBoat
{
    /** inner class */
    private class EngineForNuclearBoat
    {
         /** method to start engine of the nuclear boat */
        void startTheEngine()
        {
            System.out.println("Engine started. Nuclear boat is ready to sail");
        }
    }
    private EngineForNuclearBoat engineOfTheBoat = new EngineForNuclearBoat();
    @NuclearBoatAnnotation(title = "Annotation", started = true, text = "This is annotation for NuclearBoat class")
    public NuclearBoat()
     {
     }
    /** method to launch nuclear boat to sail */
    public void launchToSail()
    {
        engineOfTheBoat.startTheEngine();
        System.out.println("Nuclear boat is launched to sail");
    }
}


public class NuclearBoat
{
    private class EngineForNuclearBoat
    {
        void startTheEngine()
        {
            System.out.println("Engine started. Nuclear boat is ready to sail");
        }
    }
    private EngineForNuclearBoat engineOfTheBoat = new EngineForNuclearBoat();
    public void launchToSail()
    {
        engineOfTheBoat.startTheEngine();
        System.out.println("Nuclear boat is launched to sail");
    }
}


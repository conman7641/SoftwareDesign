

public class Fielder extends Player{

    public Fielder() {
        battingBehavior = new BatWithNothing();
        catchingBehavior = new CatchWithGlove();
        throwingBehavior = new ThrowWithFielder();
    }

    @Override
    public void Display() {
        System.out.println(getPlayerName());
    }
}

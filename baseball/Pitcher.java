

public class Pitcher extends Player {
 
    public Pitcher() {
        throwingBehavior = new ThrowWithPitch();
        battingBehavior = new BatWithNothing();
        catchingBehavior = new CatchWithGlove();
    }

    @Override
    public void Display() {
        System.out.println(getPlayerName());
    }


}

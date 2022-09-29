

public class Batter extends Player{

    public Batter() {
        battingBehavior = new BatWithContact();
        catchingBehavior = new CatchWithBareHands();
        throwingBehavior = new ThrowWithNothing();
    }
    @Override
    public void Display() {
        System.out.println(getPlayerName());
    }
    
}

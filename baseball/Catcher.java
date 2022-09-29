

public class Catcher extends Player{

    public Catcher(){
        battingBehavior = new BatWithNothing();
        throwingBehavior = new ThrowWithFielder();
        catchingBehavior = new CatchWithCatchersMitt();
    }

    @Override
    public void Display() {
        System.out.println(getPlayerName());
    }
    
}

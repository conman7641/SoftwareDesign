

public class PinchHitter extends Player{

    public PinchHitter(){
        battingBehavior = new BatWithPower();
        throwingBehavior = new ThrowWithNothing();
        catchingBehavior = new CatchWithNothing();
    }

    @Override
    public void Display() {
        System.out.println(getPlayerName());
    }
    
}

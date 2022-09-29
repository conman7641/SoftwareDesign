//Class similar to Duck
//will make all the behaviors extend it

public abstract class Player {
    
    BattingBehavior battingBehavior;
    CatchingBehavior catchingBehavior;
    ThrowingBehavior throwingBehavior;
    String PlayerName;

    public abstract void Display();

    public void SetThrowingBehavior(ThrowingBehavior ThrowingBehavior) {
        throwingBehavior = ThrowingBehavior;
    }

    public void PerformThrow() {
        throwingBehavior.Throwing();
    }

    public void SetCathcingBehavior(CatchingBehavior CatchingBehavior) {
        catchingBehavior = CatchingBehavior;
    }

    public void PerformCatch() {
        catchingBehavior.Catching();
    }

    public void SetBattingBehavior(BattingBehavior BattingBehavior) {
        battingBehavior = BattingBehavior;
    }

    public void PerformBat() {
        battingBehavior.Batting();
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void SetName(String playerName) {
        PlayerName = playerName;
    }


}

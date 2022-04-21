package tictactoe;

public class AI extends Player{

    public AI(Mark playerMark) {
        super(playerMark);
    }

    Mark oppositeMark() {
        if (playerMark == Mark.FIRST) return Mark.SECOND;
        else return Mark.FIRST;
    }
}

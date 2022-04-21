package tictactoe;

public class AIEasy extends AI {

    public AIEasy(Mark playerMark) {
        super(playerMark);
    }

    @Override
    public void nextTurn(Field field) {
        System.out.println("Making move level \"easy\"");
        field.setCoordinate(field.randomCoord(), playerMark);
    }
}

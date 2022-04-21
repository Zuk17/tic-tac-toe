package tictactoe;

public class AImedium extends AI {

    public AImedium(Mark playerMark) {
        super(playerMark);
    }

    @Override
    public void nextTurn(Field field) {
        System.out.println("Making move level \"medium\"");

        Coord tmpCoord = field.predicateTurn(oppositeMark());
        if (field.coordsGetSize() == 1 ||
                field.coordsGetSize() == Field.X * Field.X || tmpCoord == null)
            field.setCoordinate(field.randomCoord(), playerMark);
        else
            field.setCoordinate(tmpCoord, playerMark);
    }
}

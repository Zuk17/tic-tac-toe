package tictactoe;

public class AIhard extends AI {

    public AIhard(Mark playerMark) {
        super(playerMark);
    }

    /*TODO: реализовать сложную "сложность" */

    @Override
    public void nextTurn(Field field) {
        System.out.println("Making move level \"hard\"");

        if (field.coordsGetSize() == 1 || field.coordsGetSize() == Field.X * Field.X)
            field.setCoordinate(field.randomCoord(), playerMark);
    }
}

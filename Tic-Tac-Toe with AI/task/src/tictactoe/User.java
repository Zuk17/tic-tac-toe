package tictactoe;

public class User extends Player {
    Input input;

    public User(Mark playerMark, Input input) {
        super(playerMark);
        this.input = input;
    }

    @Override
    public void nextTurn(Field field) {
        do {
            try {
                Coord coord = new Coord(input.readCoords());
                System.out.print("\n");
                if (coord.getY() >= Field.X || coord.getX() >= Field.X) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (field.setCoordinate(coord, playerMark)) {
                    return;
                } else System.out.println("This cell is occupied! Choose another one!");
            } catch (RuntimeException e) {
                System.out.println("You should enter numbers!");
            }
        } while (true);
    }
}

package tictactoe;

public class Main {

    public static final int X = 3;
    public static final int Y = 3;


    public static void main(String[] args) {
        // write your code here
        Input input = new Input();
        Field field = initField(input);

        try {
            Mark turn = field.getTurn();

            nextTurn(input, field, turn);
            System.out.println(field.printField());

            if (field.isWin(turn))
                System.out.println(turn.valueOf() + " wins");

            else System.out.println("Game not finished");

        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    private static Field initField(Input input) {
        Field field;
        do {
            try {
                System.out.print("Enter the cells: ");
                field = new Field(input.readInitString());
                System.out.println("\n" + field.printField());
                break;
            } catch (RuntimeException e) {
                System.out.println("!!!!!ERROR!!!!!\t\t" + e + "\t\t!!!!!ERROR!!!!!\n");
            }
        } while (true);
        return field;
    }

    private static Boolean nextTurn(Input input, Field field, Mark mark) {
        do {
            System.out.print("Enter the coordinates: ");
            try {
                Coord coord = new Coord(input.readCoords());
                System.out.print("\n");
                if (coord.getY() >= 3 || coord.getX() >= 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (field.setCoordinate(coord, mark)) {
                    return true;
                } else System.out.println("This cell is occupied! Choose another one!");
            } catch (RuntimeException e) {
                System.out.println("You should enter numbers!\n");
            }
        } while (true);
    }
}

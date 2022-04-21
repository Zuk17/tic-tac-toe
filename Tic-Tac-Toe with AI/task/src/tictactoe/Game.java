package tictactoe;

public class Game {
    Field field;
    Player[] players;

    public Game(Difficulty first, Difficulty second) {

        players = new Player[]{
                new Player(first, Mark.FIRST),
                new Player(second, Mark.SECOND)
        };

        field = initField("         ");
    }

    void playGame(Input input) {
        System.out.println(field.printField());

        for (int i = 0; i < 9; i++) {
            Mark turn = field.getTurn();
            try {
                players[i % 2].nextTurn(input, field);
            } catch (RuntimeException e) {
                System.out.println(e);
            }

            System.out.println(field.printField());

            if (field.isWin(turn)) {
                System.out.println(turn.valueOf() + " wins");
                break;
            } else if (i == 8)
                System.out.println("Draw");
        }
    }

    private static Field initField(Input input) {
        Field field;
        do {
            try {
                field = new Field(input.readInitString());
                System.out.println("\n" + field.printField());
                break;
            } catch (RuntimeException e) {
                System.out.println("!!!!!ERROR!!!!!\t\t" + e + "\t\t!!!!!ERROR!!!!!\n");
            }
        } while (true);
        return field;
    }

    private static Field initField(String input) {
        return new Field(input);
    }
}

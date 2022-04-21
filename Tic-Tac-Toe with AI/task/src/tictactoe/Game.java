package tictactoe;

public class Game {
    Field field;
    Player[] players;

    public Game(Difficulty first, Difficulty second, Input input, String inputStr) {

        players = new Player[]{
                createPlayer(Mark.FIRST, first, input),
                createPlayer(Mark.SECOND, second, input)
        };

        field = new Field(inputStr);
    }

    private Player createPlayer(Mark mark, Difficulty difficulty, Input input) {
        switch (difficulty) {
            case USER:
                return new User(mark, input);
            case EASY:
                return new AIEasy(mark);
            case MEDIUM:
                return new AImedium(mark);
            case HARD:
                return new AIhard(mark);
            default:
                System.out.println("Something wrong");
        }
        assert false;
        return null;
    }

    void playGame() {
        System.out.println(field.printField());

        for (int i = 0; i < 9; i++) {
            Mark turn = field.getTurn();

            players[i % 2].nextTurn(field);

            System.out.println(field.printField());

            if (field.isWin(turn)) {
                System.out.println(turn.valueOf() + " wins");
                break;
            } else if (i == Field.X * Field.X - 1)
                System.out.println("Draw");
        }
    }
}

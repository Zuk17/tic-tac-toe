package tictactoe;

import static tictactoe.Field.X;

public class Main {

    public static void main(String[] args) {

        Input input = new Input();

        while (true) {
            Game game = initGame(input);

            if (game == null) break;
            game.playGame();
        }
        System.out.println("Goodbye. See you later!");
    }

    private static Game initGame(Input input) {
        do {
            String[] inputStr = input.readStart();

            //Выход из игры
            if (inputStr[0].equals("EXIT")) break;

            //Игра с двумя игроками и начальным состоянием
            else if (inputStr[0].matches("[_|OX]*") && inputStr[0].length() == X * X)
                return new Game(Difficulty.USER, Difficulty.USER, input, inputStr[0].replace('_', ' '));

            //Игра
            else if (inputStr.length == 3 && inputStr[0].equals("START")) {
                try {
                    return new Game(Difficulty.valueOf(inputStr[1]), Difficulty.valueOf(inputStr[2]), input, "         ");
                } catch (IllegalArgumentException e) {
                    System.out.println("Bad parameters!");
                }
            } else System.out.println("Bad parameters!");
        } while (true);
        return null;
    }
}

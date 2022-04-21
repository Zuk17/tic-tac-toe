package tictactoe;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Input input = new Input();

        while (true) {
            Game game = initGame(input);

            if (game == null) break;
            game.playGame(input);
        }
        System.out.println("Goodbye. See you later!");
    }

    private static Game initGame(Input input) {
        do {
            String[] inputStr = input.readStart();
            System.out.println("\n");

            if (inputStr[0].equals("EXIT")) break;
            else if (inputStr.length == 3 && inputStr[0].equals("START")) {
                try {
                    return new Game(Difficulty.valueOf(inputStr[1]), Difficulty.valueOf(inputStr[2]));
                } catch (IllegalArgumentException e) {
                    System.out.println("Bad parameters!");
                }
            } else System.out.println("Bad parameters!");
        } while (true);
        return null;
    }
}

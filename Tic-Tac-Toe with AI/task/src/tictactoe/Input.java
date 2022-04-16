package tictactoe;

import java.util.Scanner;
import java.util.stream.Stream;

import static tictactoe.Main.X;
import static tictactoe.Main.Y;

public class Input {

    Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }

    public int[] readCoords() {
        return Stream.of(input.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
    }

    public String readInitString() {
        String inputStr = input.nextLine().toUpperCase();

        if (inputStr.matches("[_|OX]*") && inputStr.length() == X * Y)
            return inputStr.replace('_', ' ');

        throw new RuntimeException("Incorrect input of start string");
    }
}

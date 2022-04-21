package tictactoe;

import java.util.Scanner;
import java.util.stream.Stream;

import static tictactoe.Field.X;

public class Input {

    Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }

    public int[] readCoords() {
        System.out.print("Enter the coordinates: ");
        return Stream.of(input.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();
    }

    public String readInitString() {
        System.out.print("Enter the cells: ");
        String inputStr = input.nextLine().toUpperCase();

        if (inputStr.matches("[_|OX]*") && inputStr.length() == X * X)
            return inputStr.replace('_', ' ');

        throw new RuntimeException("Incorrect input of start string");
    }

    public String[] readStart() {
        System.out.print("Input command: ");
        return input.nextLine().toUpperCase().split(" ");
    }

}

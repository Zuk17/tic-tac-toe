package tictactoe;

import java.util.Scanner;
import java.util.stream.Stream;

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

    public String[] readStart() {
        System.out.print("Input command: ");
        return input.nextLine().toUpperCase().split(" ");
    }
}

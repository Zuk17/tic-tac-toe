package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    Difficulty difficulty;
    Mark playerMark;

    public Player(Difficulty difficulty, Mark playerMark) {
        this.difficulty = difficulty;
        this.playerMark = playerMark;
    }

    void nextTurn(Input input, Field field) {
        switch (difficulty) {
            case USER:
                turnUser(input, field);
                break;
            case EASY:
                turnEasy(field);
                break;
            case MEDIUM:
                turnMedium(field);
                break;
            case HARD:
                turnHard(field);
                break;
            default:
                System.out.println("Something wrong");
        }
    }

    private void turnHard(Field field) {
        System.out.println("Making move level \"hard\"");
    }

    private void turnMedium(Field field) {
        System.out.println("Making move level \"medium\"");
    }

    private void turnUser(Input input, Field field) {
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
                System.out.println("You should enter numbers!\n");
            }
        } while (true);
    }

    private void turnEasy(Field field) {
        System.out.println("Making move level \"easy\"");

        ArrayList<Coord> listCoords = field.listCoord(playerMark);
        if (listCoords.size() == 1)
            field.setCoordinate(listCoords.remove(0), playerMark);
        else {
            Random random = new Random();
            Coord tmpCoord = listCoords.remove(random.nextInt(listCoords.size() - 1) + 1);
            field.setCoordinate(tmpCoord, playerMark);
        }
    }
}

package tictactoe;

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
                System.out.println("Making move level \"easy\"");
                turnEasy(field);
                break;
            case MEDIUM:
                System.out.println("Making move level \"medium\"");
                turnMedium(field);
                break;
            case HARD:
                System.out.println("Making move level \"hard\"");
                turnHard(field);
                break;
            default:
                System.out.println("Something wrong");
        }
    }

    private void turnHard(Field field) {
    }

    private void turnMedium(Field field) {
        if (field.listCoord.size() == 1 || field.listCoord.size() == Field.X * Field.X)
            turnEasy(field);
        else {
            Coord tmpCoord = field.predicateTurn(oppositeMark());
            if (tmpCoord != null)
                field.setCoordinate(tmpCoord, playerMark);
            else turnEasy(field);
        }
    }

    private Mark oppositeMark() {
        if (playerMark == Mark.FIRST) return Mark.SECOND;
        else return Mark.FIRST;
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
        if (field.listCoord.size() == 1)
            field.setCoordinate(field.listCoord.get(0), playerMark);
        else {
            Random random = new Random();
            Coord tmpCoord = field.listCoord.get(random.nextInt(field.listCoord.size() - 1) + 1);
            field.setCoordinate(tmpCoord, playerMark);
        }
    }
}

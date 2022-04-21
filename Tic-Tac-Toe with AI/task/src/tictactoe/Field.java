package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    //Размеры поля
    public static final int X = 3;

    private int turn = 0;
    private final Mark[][] field = new Mark[X][X];
    private final List<Coord> listCoord = new ArrayList<>();

    public Field(String inputString) {
        for (int i = 0; i < X; i++)
            for (int j = 0; j < X; j++) {
                field[i][j] = Mark.markFromAbbreviation(inputString.charAt(i * X + j));
                if (field[i][j] == Mark.FIRST) turn++;
                if (field[i][j] == Mark.SECOND) turn--;
                if (field[i][j] == Mark.FOG) listCoord.add(new Coord(new int[]{i + 1, j + 1}));
            }
    }

    public int coordsGetSize() {
        return listCoord.size();
    }

    public Mark getTurn() {
        if (turn == 0) return Mark.FIRST;
        if (turn == 1) return Mark.SECOND;
        throw new RuntimeException("Wrong turn! Check code");
    }

    public String printField() {
        StringBuilder output = new StringBuilder();
        output.append("---------\n");

        for (int i = 0; i < X; i++) {
            output.append("| ");
            for (int j = 0; j < X; j++)
                output.append(field[i][j].valueOf()).append(" ");
            output.append("|\n");
        }

        output.append("---------\n");
        return output.toString();
    }

    public boolean setCoordinate(Coord coord, Mark mark) {
        if (field[coord.getX()][coord.getY()] == Mark.FOG) {
            field[coord.getX()][coord.getY()] = mark;

            if (!listCoord.remove(coord))
                throw new RuntimeException("В листе с доступными ходами отсутствует эта координата\n" +
                        "X=" + coord.getX() + "\t\tY=" + coord.getY() + "\t\t Size of " + listCoord.size() + "\n" +
                        listCoord);

            if (mark == Mark.FIRST) turn++;
            else turn--;

            return true;
        } else return false;
    }

    /* TODO: Вынести логику в другой класс*/
    public boolean isWin(Mark mark) {
        boolean resultVertical = true;
        boolean resultHorizontal = true;
        boolean resultDiagonal1 = true;
        boolean resultDiagonal2 = true;
        for (int i = 0; i < X; i++) {
            resultVertical = true;
            resultHorizontal = true;
            if (field[i][i] != mark) resultDiagonal1 = false;
            if (field[i][X - 1 - i] != mark) resultDiagonal2 = false;
            for (int j = 0; j < X; j++) {
                if (field[i][j] != mark) resultHorizontal = false;
                if (field[j][i] != mark) resultVertical = false;
            }
            if (resultVertical || resultHorizontal) break;
        }
        return resultDiagonal1 || resultDiagonal2 || resultHorizontal || resultVertical;
    }

    public Coord randomCoord () {
        if (listCoord.size() == 1) return listCoord.get(0);
        Random random = new Random();
        return listCoord.get(random.nextInt(listCoord.size() - 1) + 1);
    }

    public Coord predicateTurn(Mark oppositeMark) {
        Coord coord;
        Coord coordVert;
        Coord coordDiag1 = null;
        Coord coordDiag2 = null;
        int countDiag1 = 0;
        int countDiag2 = 0;

        for (int i = 0; i < X; i++) {
            int count = 0;
            coord = null;

            int countVert = 0;
            coordVert = null;

            if (field[i][i] == oppositeMark) countDiag1++;
            if (field[i][i] == Mark.FOG) coordDiag1 = new Coord(new int[]{i + 1, i + 1});

            if (field[i][X - 1 - i] == oppositeMark) countDiag2++;
            if (field[i][X - 1 - i] == Mark.FOG) coordDiag2 = new Coord(new int[]{i + 1, X - i});

            for (int j = 0; j < X; j++) {
                if (field[i][j] == oppositeMark) count++;
                if (field[i][j] == Mark.FOG) coord = new Coord(new int[]{i + 1, j + 1});

                if (field[j][i] == oppositeMark) countVert++;
                if (field[j][i] == Mark.FOG) coordVert = new Coord(new int[]{j + 1, i + 1});
            }

            if (count == 2 && coord != null) return coord;
            if (countVert == 2 && coordVert != null) return coordVert;
            if (countDiag1 == 2 && coordDiag1 != null) return coordDiag1;
            if (countDiag2 == 2 && coordDiag2 != null) return coordDiag2;
        }
        return null;
    }
}

package tictactoe;

public class Field {
    //Размеры поля
    public final int X = 3;
    private int turn = 0;
    Mark[][] field = new Mark[3][3];

    public Field(String inputString) {
        for (int i = 0; i < X; i++)
            for (int j = 0; j < X; j++) {
                field[i][j] = Mark.markFromAbbreviation(inputString.charAt(i * X + j));
                if (field[i][j] == Mark.FIRST) turn++;
                if (field[i][j] == Mark.SECOND) turn--;
            }
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

    public boolean setCoordinate(Coord coord, Mark mark) {
        if (field[coord.getX()][coord.getY()] == Mark.FOG) {
            field[coord.getX()][coord.getY()] = mark;
            return true;
        } else return false;
    }
}

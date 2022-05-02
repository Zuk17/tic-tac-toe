package tictactoe;

public class Player {
    final Mark playerMark;

    public Player(Mark playerMark) {
        this.playerMark = playerMark;
    }

    public void nextTurn(Field field) {
        System.out.println("Something wrong with overriding nextTurn() method");
        assert false;
    }

    public boolean isWin(Field field, Mark playerMark) {
        boolean resultVertical = true;
        boolean resultHorizontal = true;
        boolean resultDiagonal1 = true;
        boolean resultDiagonal2 = true;
        for (int i = 0; i < Field.X; i++) {
            resultVertical = true;
            resultHorizontal = true;
            if (field.get(i, i) != playerMark) resultDiagonal1 = false;
            if (field.get(i, Field.X - 1 - i) != playerMark) resultDiagonal2 = false;
            for (int j = 0; j < Field.X; j++) {
                if (field.get(i, j) != playerMark) resultHorizontal = false;
                if (field.get(j, i) != playerMark) resultVertical = false;
            }
            if (resultVertical || resultHorizontal) break;
        }
        return resultDiagonal1 || resultDiagonal2 || resultHorizontal || resultVertical;
    }
}

package tictactoe;

public class AIhard extends AImedium {

    public AIhard(Mark playerMark) {
        super(playerMark);
    }

    @Override
    public void nextTurn(Field field) {
        System.out.println("Making move level \"hard\"");
        if (field.coordsGetSize() != 1) {
            Coord winTurn = null;
            int max = Integer.MIN_VALUE;
            for (Coord a : field.getList()) {
                Field fieldA = field.clone();
                if (!fieldA.setCoordinate(a, playerMark)) new AssertionError();
                int tmp = minimax(fieldA, oppositeMark(playerMark));
                if (tmp > max) {
                    max = tmp;
                    winTurn = a;
                }
                System.out.println("coord=" + a + "\t\tweight=" + tmp);
            }
            assert winTurn != null;
            System.out.println("Winner coord=" + winTurn);
            field.setCoordinate(winTurn, playerMark);
        } else
            field.setCoordinate(randomCoord(field), playerMark);
    }

    private int minimax(Field field, Mark playerMark) {
        int max;

        if (playerMark == this.playerMark) max = Integer.MIN_VALUE;
        else max = Integer.MAX_VALUE;

        for (Coord a : field.getList()) {
            Field fieldA = field.clone();
            if (!fieldA.setCoordinate(a, playerMark)) new AssertionError();

            if (isWin(fieldA, this.playerMark))
                return 10;
            else if (isWin(fieldA, oppositeMark()))
                return -10;
            else if (fieldA.getList().isEmpty())
                return 0;

            int tmp = minimax(fieldA, oppositeMark(playerMark));
            if (playerMark == this.playerMark && tmp > max) max = tmp;
            if (playerMark != this.playerMark && tmp < max) max = tmp;
        }
        return max;
    }

    Mark oppositeMark(Mark playerMark) {
        if (playerMark == Mark.FIRST) return Mark.SECOND;
        else return Mark.FIRST;
    }
}

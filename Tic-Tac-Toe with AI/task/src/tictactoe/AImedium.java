package tictactoe;

public class AImedium extends AIEasy {

    public AImedium(Mark playerMark) {
        super(playerMark);
    }

    @Override
    public void nextTurn(Field field) {
        System.out.println("Making move level \"medium\"");

        Coord tmpCoord = predicateTurn(field, oppositeMark());
        if (field.coordsGetSize() == 1 ||
                field.coordsGetSize() == Field.X * Field.X ||
                tmpCoord == null)
            field.setCoordinate(randomCoord(field), playerMark);
        else
            field.setCoordinate(tmpCoord, playerMark);
    }

    Mark oppositeMark() {
        if (playerMark == Mark.FIRST) return Mark.SECOND;
        else return Mark.FIRST;
    }

    public Coord predicateTurn(Field field, Mark oppositeMark) {
        Coord coord;
        Coord coordVert;
        Coord coordDiag1 = null;
        Coord coordDiag2 = null;
        int countDiag1 = 0;
        int countDiag2 = 0;

        for (int i = 0; i < Field.X; i++) {
            int count = 0;
            coord = null;

            int countVert = 0;
            coordVert = null;

            if (field.get(i, i) == oppositeMark) countDiag1++;
            if (field.get(i, i) == Mark.FOG) coordDiag1 = new Coord(new int[]{i + 1, i + 1});

            if (field.get(i, Field.X - 1 - i) == oppositeMark) countDiag2++;
            if (field.get(i, Field.X - 1 - i) == Mark.FOG) coordDiag2 = new Coord(new int[]{i + 1, Field.X - i});

            for (int j = 0; j < Field.X; j++) {
                if (field.get(i, j) == oppositeMark) count++;
                if (field.get(i, j) == Mark.FOG) coord = new Coord(new int[]{i + 1, j + 1});

                if (field.get(j, i) == oppositeMark) countVert++;
                if (field.get(j, i) == Mark.FOG) coordVert = new Coord(new int[]{j + 1, i + 1});
            }

            if (count == 2 && coord != null) return coord;
            if (countVert == 2 && coordVert != null) return coordVert;
            if (countDiag1 == 2 && coordDiag1 != null) return coordDiag1;
            if (countDiag2 == 2 && coordDiag2 != null) return coordDiag2;
        }
        return null;
    }
}

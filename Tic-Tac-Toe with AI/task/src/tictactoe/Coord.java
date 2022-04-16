package tictactoe;

/*
@author Ivan Zhukov <ivan.p.zhukov@gmail.com>

@param x Координата X
@param y Координата Y
*/

public class Coord {
    private final int x;
    private final int y;

    public Coord(int[] i) {
        this.x = i[0] - 1;
        this.y = i[1] - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

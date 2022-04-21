package tictactoe;

/*
@author Ivan Zhukov <ivan.p.zhukov@gmail.com>

@param x Координата X
@param y Координата Y
*/

import java.util.Objects;

public class Coord {
    private final int x;
    private final int y;

    public Coord(int[] i) {
        this.x = i[0] - 1;
        this.y = i[1] - 1;
    }

    public String toString() {
        return "{X=" + x + ", Y=" + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

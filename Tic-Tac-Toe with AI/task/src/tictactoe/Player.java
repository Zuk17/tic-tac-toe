package tictactoe;

public class Player {
    Mark playerMark;

    public Player(Mark playerMark) {
        this.playerMark = playerMark;
    }

    public void nextTurn(Field field) {
        System.out.println("Something wrong with overriding method of nextTurn");
        assert false;
    }
}

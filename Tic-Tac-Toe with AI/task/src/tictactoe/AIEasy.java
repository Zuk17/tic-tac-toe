package tictactoe;

import java.util.List;
import java.util.Random;

public class AIEasy extends Player {

    public AIEasy(Mark playerMark) {
        super(playerMark);
    }

    @Override
    public void nextTurn(Field field) {
        System.out.println("Making move level \"easy\"");
        field.setCoordinate(randomCoord(field), playerMark);
    }

    public Coord randomCoord (Field field) {
        List<Coord> listCoord = field.getList();
        if (listCoord.size() == 1) return listCoord.get(0);
        Random random = new Random();
        return listCoord.get(random.nextInt(listCoord.size() - 1) + 1);
    }
}

package tictactoe;

public enum Mark {
    FOG(' '),
    FIRST('X'),
    SECOND('O');

    private char appearance;

    Mark(char c) {
        this.appearance = c;
    }

    String valueOf() {
        return String.valueOf(appearance);
    }

    public static Mark markFromAbbreviation(char c) {
        for (var mark : Mark.values())
            if (c == mark.appearance)
                return mark;
        throw new RuntimeException("absent statement");
    }
}

// Мапу ключ-енум, и по ключу гетать енум за О1
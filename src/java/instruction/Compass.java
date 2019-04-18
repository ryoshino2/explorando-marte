package instruction;

public enum Compass {
    N('N'),
    E('E'),
    S('S'),
    W('W');

    private final char asChar;

    private Compass(char asChar) {
        this.asChar = asChar;
    }

    public static Compass of(Character value) {
        for (Compass v : values()) {
            if (v.asChar == value) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    public Character asChar() {
        return asChar;
    }

}

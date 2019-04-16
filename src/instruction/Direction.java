package instruction;

public enum Direction{

    R('R'),
    L('L'),
    M('M');

    private final char asChar;
    private Direction(char asChar) {
        this.asChar = asChar;
    }

    public static Direction of(Character value) {
        for (Direction v : values()) {
            if (v.asChar == value) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    public Direction asChar() {
        return Direction.of(asChar);
    }

}


package instruction;

public enum Instruction {

    R('R'),
    L('L'),
    M('M');

    private final char asChar;
    private Instruction(char asChar) {
        this.asChar = asChar;
    }

    public static Instruction of(Character value) {
        for (Instruction v : values()) {
            if (v.asChar == value) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    public Instruction asChar() {
        return Instruction.of(asChar);
    }

}


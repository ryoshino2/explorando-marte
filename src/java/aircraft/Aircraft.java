package aircraft;

import instruction.Compass;
import instruction.Instruction;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {

    private Coordinate coordinate;
    private Compass compass;
    private List<Instruction> commands = new ArrayList<Instruction>();

    public Aircraft(Coordinate coordinate, Compass compass) {
        this.coordinate = coordinate;
        this.compass = compass;
    }

    public Compass getCompass() {
        return compass;
    }

    void setCompass(Compass compass) {
        this.compass = compass;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Coordinate setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return coordinate;
    }

    @Override
    public String toString() {
        return "" + compass;
    }


    public void transformStringForInstruction(String palavra) {
        try {
            for (int i = 0; i < palavra.length(); i++) {
                commands.add(Instruction.valueOf(palavra.toUpperCase().substring(i, i + 1)));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    public List<Instruction> getCommands() {
        return commands;
    }
}

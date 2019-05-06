package aircraft;

import instruction.Instruction;

import java.util.List;

public interface ControlAirship {
    void rotateAircraft(List<Instruction> instruction);
    void moveAircraft(List<Instruction> instruction);
    void sensorAircraft();

}

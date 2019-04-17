package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AircraftTest {

    private List<Instruction> instructionList = new ArrayList<Instruction>();
    private aircraft.Aircraft aircraft;

    @Before
    public void setup() {
        aircraft.Coordinate coordinate = new aircraft.Coordinate(5, 5);
        aircraft = new aircraft.Aircraft(coordinate, Compass.NORTH);
    }

    @Test
    public void transformStringForInstruction() {
        String direction = "MLMM";
        aircraft.transformStringForInstruction(direction);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);

        assertEquals(aircraft.getCommands(), instructionList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notBeakString() {
        String direction = "MLMS";
        aircraft.transformStringForInstruction(direction);
    }

}
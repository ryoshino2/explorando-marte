package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SensorTest {

    private Aircraft aircraft;
    private Nasa nasa;
    private List<Instruction> instructionList = new ArrayList<>();
    private Sensor sensor;

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(5, 5);
        TableLand tableLand = new TableLand(10, 10);
        aircraft = new Aircraft(coordinate, Compass.N);
        sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void checkSpaceWhenMovingForwardTrue() {
        instructionList.add(Instruction.M);
        nasa.moveAircraft(instructionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void checkSpaceWhenMovingRightTrue() {
        instructionList.add(Instruction.R);
        nasa.moveAircraft(instructionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void checkSpaceWhenMovingLeftTrue() {
        instructionList.add(Instruction.L);
        nasa.moveAircraft(instructionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void checkSpaceWhenMoving5timesForwardTrue() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        nasa.moveAircraft(instructionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkSpaceWhenMoving6timesForwardFalse() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        nasa.moveAircraft(instructionList);
        sensor.verifyHaveSpaceTableLand(aircraft);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSpaceWhenMoving6TimesForward() {
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        nasa.moveAircraft(instructionList);
        sensor.verifyHaveSpaceTableLand(aircraft);
    }
}
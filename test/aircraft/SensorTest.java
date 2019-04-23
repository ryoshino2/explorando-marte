package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
        aircraft = new Aircraft(5,5, Compass.N);
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
        assertEquals(10, aircraft.getLengthCoordinate().intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSpaceWhenMoving6timesForward() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        nasa.moveAircraft(instructionList);
    }

    @Test
    public void checkSpaceWhenMoving5timesForwardAnd1timeLeft() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);
        nasa.moveAircraft(instructionList);
        assertEquals(10, aircraft.getLengthCoordinate().intValue());
        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void checkSpaceWhenMoving5timesForward1TimeLeftAnd1timeForward() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.M);
        nasa.moveAircraft(instructionList);
        assertEquals(4, aircraft.getWidthCoordinate().intValue());
        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void checkSpaceWhenMoving5timesForward2TimesLeftAnd1timeForward() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(9, aircraft.getLengthCoordinate().intValue());
        assertEquals('S', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void checkSpaceWhenMoving5timesForward1TimeRightAnd1TimeForward(){
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(10, aircraft.getLengthCoordinate().intValue());
        assertEquals(6, aircraft.getWidthCoordinate().intValue());
        assertEquals('E', (char) aircraft.getCompass().asChar());

    }
}
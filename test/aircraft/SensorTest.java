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
    private List<Instruction> instructionList;
    private Sensor sensor;

    @Before
    public void setup() {
        instructionList = new ArrayList<>();
        TableLand tableLand = new TableLand(10, 10);
        aircraft = new Aircraft(5,5, Compass.N);
        sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void checkSpaceWhenMovingForwardTrue() {
        // arrange
        instructionList.add(Instruction.M);
        // act
        nasa.moveAircraft(instructionList);
        // assert
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void checkSpaceWhenMovingRightTrue() {
        //arrange
        instructionList.add(Instruction.R);
        // act
        nasa.moveAircraft(instructionList);
        //assert
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void checkSpaceWhenMovingLeftTrue() {
        //arrange
        instructionList.add(Instruction.L);
        // act
        nasa.moveAircraft(instructionList);
        //assert
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void checkSpaceWhenMoving5timesForwardTrue() {
        //arrange
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);

        //act
        nasa.moveAircraft(instructionList);

        //assert
        assertEquals(10, aircraft.getLengthCoordinate().intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSpaceWhenMoving6timesForward() {
        //arrange
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        //act
        nasa.moveAircraft(instructionList);
    }

    @Test
    public void checkSpaceWhenMoving5timesForwardAnd1timeLeft() {
        //arrange
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);
        //act
        nasa.moveAircraft(instructionList);

        //assert
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
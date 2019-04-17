package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NasaTest {

    private Aircraft aircraft;
    private Nasa nasa;
    private List<Instruction> instructionList = new ArrayList<>();

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(5, 5);
        TableLand tableLand = new TableLand( 10, 10);
        aircraft = new Aircraft(coordinate, Compass.NORTH);
        Sensor sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void MoveLeftAircraft() {
        instructionList.add(Instruction.L);
        nasa.moveAircraft(instructionList);
        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void Move2TimesLeftAircraft() {
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        nasa.moveAircraft(instructionList);

        assertEquals('S', (char) aircraft.getCompass().asChar());
    }
    @Test
    public void Move3TimesLeftAircraft() {
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        nasa.moveAircraft(instructionList);

        assertEquals('E', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void Move4timesLeftAircraft() {
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        nasa.moveAircraft(instructionList);

        assertEquals('N', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void MoveRightAircraft() {
        instructionList.add(Instruction.R);
        nasa.moveAircraft(instructionList);

        assertEquals('E', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void Move2TimesRightAircraft() {
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        nasa.moveAircraft(instructionList);

        assertEquals('S', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void Move3TimesRightAircraft() {
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        nasa.moveAircraft(instructionList);

        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void Move4TimesRightAircraft() {
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        nasa.moveAircraft(instructionList);

        assertEquals('N', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void MoveForwardAircraft() {
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(6, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveForwardAndRightAircraft() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.R);

        nasa.moveAircraft(instructionList);
        assertEquals(6, (int) aircraft.getCoordinate().getLengthCoordinate());
    }


    @Test
    public void MoveForwardAndLeftAircraft() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);

        nasa.moveAircraft(instructionList);
        assertEquals(6, (int) aircraft.getCoordinate().getLengthCoordinate());
    }


    @Test
    public void MoveLeftAndForwardAircraft() {
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(5, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveRAndForwardAircraft() {
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(5, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveRightTwoAndForwardAircraft() {
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(4, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void Move5TimesForwardAircraft() {
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);

        nasa.moveAircraft(instructionList);
        assertEquals(10, (int) aircraft.getCoordinate().getLengthCoordinate());
    }
}
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
    private List<Instruction> instructionList = new ArrayList<Instruction>();

    @Before
    public void setup() {
        TableLand tableLand = new TableLand( 10, 10);
        aircraft = new Aircraft(5,5, Compass.N);
        Sensor sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void MoveLeftAircraft() {
        //arrange
        instructionList.add(Instruction.L);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void Move2TimesLeftAircraft() {
        //arrange
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('S', (char) aircraft.getCompass().asChar());
    }
    @Test
    public void Move3TimesLeftAircraft() {
        //arrange
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('E', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void Move4timesLeftAircraft() {
        //arrange
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.L);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('N', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void MoveRightAircraft() {
        //arrange
        instructionList.add(Instruction.R);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('E', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void Move2TimesRightAircraft() {
        //arrange
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('S', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void Move3TimesRightAircraft() {
        //arrange
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void Move4TimesRightAircraft() {
        //arrange
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals('N', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void MoveForwardAircraft() {
        //arrange
        instructionList.add(Instruction.M);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(6, (int) aircraft.getLengthCoordinate());
    }

    @Test
    public void MoveForwardAndRightAircraft() {
        //arrange
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.R);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(6, (int) aircraft.getLengthCoordinate());
    }


    @Test
    public void MoveForwardAndLeftAircraft() {
        //arrange
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.L);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(6, (int) aircraft.getLengthCoordinate());
    }


    @Test
    public void MoveLeftAndForwardAircraft() {
        //arrange
        instructionList.add(Instruction.L);
        instructionList.add(Instruction.M);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(5, (int) aircraft.getLengthCoordinate());
    }

    @Test
    public void MoveRightAndForwardAircraft() {
        //arrange
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.M);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(5, (int) aircraft.getLengthCoordinate());
    }

    @Test
    public void MoveRightTwoAndForwardAircraft() {
        //arrange
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.R);
        instructionList.add(Instruction.M);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(4, (int) aircraft.getLengthCoordinate());
    }

    @Test
    public void Move5TimesForwardAircraft() {
        //arrange
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        instructionList.add(Instruction.M);
        //act
        nasa.moveAircraft(instructionList);
        //assert
        assertEquals(10, (int) aircraft.getLengthCoordinate());
    }
}
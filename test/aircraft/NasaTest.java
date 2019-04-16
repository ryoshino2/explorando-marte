package aircraft;

import instruction.Compass;
import instruction.Direction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NasaTest {

    private Aircraft aircraft;
    private Nasa nasa;
    private List<Direction> directionList = new ArrayList<>();

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(5, 5);
        TableLand tableLand = new TableLand("Marte", 10, 10);
        aircraft = new Aircraft(coordinate, Compass.NORTH);
        Sensor sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void MoveLeftAircraft() {
        directionList.add(Direction.L);
        nasa.moveAircraft(directionList);
        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void MoveTwoLeftNorthAircraft() {
        directionList.add(Direction.L);
        directionList.add(Direction.L);
        nasa.moveAircraft(directionList);

        assertEquals('S', (char) aircraft.getCompass().asChar());
    }
    @Test
    public void MoveThreeLeftNorthAircraft() {
        directionList.add(Direction.L);
        directionList.add(Direction.L);
        directionList.add(Direction.L);
        nasa.moveAircraft(directionList);

        assertEquals('E', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void MoveFourLeftNorthAircraft() {
        directionList.add(Direction.L);
        directionList.add(Direction.L);
        directionList.add(Direction.L);
        directionList.add(Direction.L);
        nasa.moveAircraft(directionList);

        assertEquals('N', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void MoveRightAircraft() {
        directionList.add(Direction.R);
        nasa.moveAircraft(directionList);

        assertEquals('E', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void MTwoRAircraft() {
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        nasa.moveAircraft(directionList);

        assertEquals('S', (char) aircraft.getCompass().asChar());
    }


    @Test
    public void MoveThreeRAircraft() {
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        nasa.moveAircraft(directionList);

        assertEquals('W', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void MoveFourRAircraft() {
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        nasa.moveAircraft(directionList);

        assertEquals('N', (char) aircraft.getCompass().asChar());
    }

    @Test
    public void MoveForwardNave() {
        directionList.add(Direction.M);

        nasa.moveAircraft(directionList);
        assertEquals(6, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveForwardAndRNave() {
        directionList.add(Direction.M);
        directionList.add(Direction.R);

        nasa.moveAircraft(directionList);
        assertEquals(6, (int) aircraft.getCoordinate().getLengthCoordinate());
    }


    @Test
    public void MoveForwardAndLeftNave() {
        directionList.add(Direction.M);
        directionList.add(Direction.L);

        nasa.moveAircraft(directionList);
        assertEquals(6, (int) aircraft.getCoordinate().getLengthCoordinate());
    }


    @Test
    public void MoveLeftAndForwardNave() {
        directionList.add(Direction.L);
        directionList.add(Direction.M);

        nasa.moveAircraft(directionList);
        assertEquals(5, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveRAndForwardNave() {
        directionList.add(Direction.R);
        directionList.add(Direction.M);

        nasa.moveAircraft(directionList);
        assertEquals(5, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveRightTwoAndForwardNave() {
        directionList.add(Direction.R);
        directionList.add(Direction.R);
        directionList.add(Direction.M);

        nasa.moveAircraft(directionList);
        assertEquals(4, (int) aircraft.getCoordinate().getLengthCoordinate());
    }

    @Test
    public void MoveForwardNaveForaSuper() {

        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);

        nasa.moveAircraft(directionList);
        assertEquals(10, (int) aircraft.getCoordinate().getLengthCoordinate());
    }
}
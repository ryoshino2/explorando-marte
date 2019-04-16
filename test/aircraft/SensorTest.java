package aircraft;

import instruction.Compass;
import instruction.Direction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SensorTest {

    private Aircraft aircraft;
    private Nasa nasa;
    private List<Direction> directionList = new ArrayList<>();
    private Sensor sensor;

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(5, 5);
        TableLand tableLand = new TableLand("Marte", 10, 10);
        aircraft = new Aircraft(coordinate, Compass.NORTH);
        sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void verifyHaveSpaceTableLandLOk() {
        directionList.add(Direction.L);
        nasa.moveAircraft(directionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void verifyHaveSpaceTableLandROk() {
        directionList.add(Direction.R);
        nasa.moveAircraft(directionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void verifyHaveSpaceTableLandMoveOk() {
        directionList.add(Direction.M);
        nasa.moveAircraft(directionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }

    @Test
    public void verifyHaveSpaceTableLandMove5timesOk() {
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        nasa.moveAircraft(directionList);
        assertTrue(sensor.verifyHaveSpaceTableLand(aircraft));
    }
    @Test(expected = IllegalArgumentException.class)
    public void verifyHaveSpaceTableLandMove6TimesNOkPositive() {
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        nasa.moveAircraft(directionList);
        sensor.verifyHaveSpaceTableLand(aircraft);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyHaveSpaceTablelandMove6TimesNOkNegative() {
        directionList.add(Direction.L);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        directionList.add(Direction.M);
        nasa.moveAircraft(directionList);
        sensor.verifyHaveSpaceTableLand(aircraft);
    }
}
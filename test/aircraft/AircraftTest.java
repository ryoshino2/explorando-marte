package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AircraftTest {

    private List<Instruction> instructionList = new ArrayList<>();

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(5, 5);
        TableLand tableLand = new TableLand( 10, 10);
        Aircraft aircraft = new Aircraft(coordinate, Compass.NORTH);
        Sensor sensor = new Sensor(tableLand);
        Nasa nasa = new Nasa(aircraft, tableLand, sensor);
    }

    @Test
    public void transformStringForInstruction() {
    }
}
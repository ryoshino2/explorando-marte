package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConvertStringTest {

    private ConvertString convertString;

    @Before
    public void setup() {
        convertString = new ConvertString();
    }

    @Test
    public void transformStringForCoordinatesTableLand() {
        String directionList = "5 6\n"
                + "1 2 N\n"
                + "MMMR\n";
        convertString.transformStringForCoordinateTableLand(directionList);
        assertEquals(5, (int) convertString.getTableLandCoordinates().get(0));
        assertEquals(6, (int) convertString.getTableLandCoordinates().get(1));
    }

    @Test
    public void transformStringForInstruction() {
        String directionList = "5 5\n"
                + "1 2 N\n"
                + "MMMR\n";

        List<Instruction> directionListExpected = new ArrayList<>();
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.R);

        convertString.coordinateAircraft(directionList);
        assertEquals(directionListExpected, convertString.getCommands());
    }

    @Test
    public void transformStringForCoordinatesAircraft() {
        String directionList = "5 5\n"
                + "1 1 N\n"
                + "MMMR\n";

        Aircraft aircraft = new Aircraft(1, 1, Compass.N);
        convertString.positionAircraft(directionList);
        assertEquals(convertString.getCoordinates().get(0), aircraft.getWidthCoordinate());
        assertEquals(convertString.getCoordinates().get(0), aircraft.getLengthCoordinate());
        assertEquals(convertString.getCompass().get(0), aircraft.getCompass());
    }
}
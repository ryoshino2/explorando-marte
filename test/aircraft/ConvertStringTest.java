package aircraft;

import instruction.Compass;
import instruction.Instruction;
import io.FileOpening;
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
        //arrange
        String directionList = "5 6\n"
                + "1 2 N\n"
                + "MMMR\n";
        //act
        convertString.transformStringForCoordinateTableLand(directionList);

        //assert
        assertEquals(5, (int) convertString.getTableLandCoordinates().get(0));
        assertEquals(6, (int) convertString.getTableLandCoordinates().get(1));
    }

    @Test
    public void transformStringForInstruction() {
        //arrange
        String directionList = "5 5\n"
                + "1 2 N\n"
                + "MMMR\n";

        List<Instruction> directionListExpected = new ArrayList<>();
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.R);

        //act
        convertString.coordinateAircraft(directionList);

        //assert
        assertEquals(directionListExpected, convertString.getCommands());
    }

    @Test
    public void transformStringForCoordinatesAircraft() {
        //arrange
        String directionList = "5 5\n"
                + "1 1 N\n"
                + "MMMR\n";

        Aircraft aircraft = new Aircraft(1, 1, Compass.N);

        //act
        convertString.positionAircraft(directionList);

        //assert
        assertEquals(convertString.getCoordinates().get(0), aircraft.getWidthCoordinate());
        assertEquals(convertString.getCoordinates().get(1), aircraft.getLengthCoordinate());
        assertEquals(convertString.getCompass().get(0), aircraft.getCompass());
    }

    @Test
    public void transformFileStringForCoordinatesAircraft() {

        //arrange
        FileOpening fileOpening = new FileOpening();

        Aircraft aircraft = new Aircraft(1, 2, Compass.N);

        //act
        convertString.positionAircraft(fileOpening.getPalavras());

        //assert
        assertEquals(convertString.getCoordinates().get(0), aircraft.getWidthCoordinate());
        assertEquals(convertString.getCoordinates().get(1), aircraft.getLengthCoordinate());
        assertEquals(convertString.getCompass().get(0), aircraft.getCompass());
    }
}
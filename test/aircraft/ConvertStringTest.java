package aircraft;

import instruction.Compass;
import instruction.Instruction;
import org.junit.Before;
import org.junit.Test;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConvertStringTest {

    private ConvertString convertString;
    private Nasa nasa;
    private List<Instruction> instructionList = new ArrayList<Instruction>();
    private Aircraft aircraft;

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(5, 5);
        TableLand tableLand = new TableLand(10, 10);
        aircraft = new Aircraft(coordinate, Compass.N);
        Sensor sensor = new Sensor(tableLand);
        nasa = new Nasa(aircraft, tableLand, sensor);
        convertString = new ConvertString();
    }

    @Test
    public void transformStringForCoordinatesTableLand() {
        String posicaoSonda = "5 6";
        convertString.transformStringForCoordinatesTableLand(posicaoSonda);
        assertEquals(java.util.Optional.of(5), java.util.Optional.of(convertString.getSuperficie().get(0)));
        assertEquals(java.util.Optional.of(6), java.util.Optional.of(convertString.getSuperficie().get(1)));
    }

    @Test
    public void transformStringForInstruction() {
        String directionList = "MMMR";
        List<Instruction> directionListExpected = new ArrayList<>();
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.M);
        directionListExpected.add(Instruction.R);

        convertString.transformStringForInstruction(directionList);
        assertEquals(directionListExpected, convertString.getCommands());
    }

    @Test
    public void transformStringForCoordinatesAircraft() {
        String directionList = "1 1 N";

        Coordinate coordinate = new Coordinate(1, 1);
        Aircraft aircraft = new Aircraft(coordinate, Compass.N);
        convertString.transformStringForCoordinatesAircraft(directionList);

        assertEquals(convertString.getCoodenadas().get(0), aircraft.getCoordinate().getWidthCoordinate());
        assertEquals(convertString.getCoodenadas().get(0), aircraft.getCoordinate().getLengthCoordinate());
        assertEquals(convertString.getCompass().get(0), aircraft.getCompass());
    }
}
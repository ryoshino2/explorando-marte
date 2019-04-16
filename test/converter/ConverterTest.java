package converter;

import instruction.Direction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    private Converter converter;
    private List<Direction> directionList = new ArrayList<>();

    @Before
    public void setup() {
        converter = new Converter();
    }

    @Test
    public void breakString() {
        String direction = "MLMM";
        converter.breakString(direction);
        directionList.add(Direction.M);
        directionList.add(Direction.L);
        directionList.add(Direction.M);
        directionList.add(Direction.M);

        assertEquals(converter.getComandos(), directionList);
    }
    @Test(expected = IllegalArgumentException.class)
    public void notBeakString() {
        String direction = "MLMS";
        converter.breakString(direction);
    }
}
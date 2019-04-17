//package converter;
//
//import instruction.Instruction;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class ConverterTest {
//
//    private ConvertStringForInstruction converter;
//    private List<Instruction> instructionList = new ArrayList<>();
//
//    @Before
//    public void setup() {
//        converter = new ConvertStringForInstruction();
//    }
//
//    @Test
//    public void breakStringForInstruction() {
//        String direction = "MLMM";
//        converter.transformStringForInstruction(direction);
//        instructionList.add(Instruction.M);
//        instructionList.add(Instruction.L);
//        instructionList.add(Instruction.M);
//        instructionList.add(Instruction.M);
//
//        assertEquals(converter.getCommands(), instructionList);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void notBeakString() {
//        String direction = "MLMS";
//        converter.transformStringForInstruction(direction);
//    }
//}
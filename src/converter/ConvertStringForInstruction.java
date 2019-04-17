//package converter;
//
//import instruction.Instruction;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConvertStringForInstruction {
//
//    private List<Instruction> commands = new ArrayList<>();
//
//    public void transformStringForInstruction(String word) {
//        try {
//            for (int i = 0; i < word.length(); i++) {
//                commands.add(Instruction.valueOf(word.toUpperCase().substring(i, i + 1)));
//            }
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Direcao desconhecida");
//        }
//    }
//
//    public List<Instruction> getCommands() {
//        return commands;
//    }
//
//}

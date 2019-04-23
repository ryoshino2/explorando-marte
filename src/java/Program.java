import aircraft.ConvertString;

public class Program {

    public static void main(String[] args) {
        final ConvertString convert = new ConvertString();

        String input = "5 5\n"
                + "1 2 N\n"
                + "LMLMLMLMM\n"
                + "3 3 E\n"
                + "MMRMMRMRRM\n";

        convert.runInstructions(input);
        convert.viewAircraft();
    }
}

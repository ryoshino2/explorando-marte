import aircraft.NasaInstructions;

public class Program {

    public static void main(String[] args) {
        final NasaInstructions nasa = new NasaInstructions();

        String input = "5 5\n"
                + "1 2 N\n"
                + "LMLMLMLMM\n"
                + "3 3 E\n"
                + "MMRMMRMRRM\n"
                + "1 1 N\n"
                + "LMLMLMLMM\n"
                + "1 3 N\n"
                + "LMLMLMLMM\n";

        nasa.runInstructions(input);
        nasa.viewAircraft();
    }
}

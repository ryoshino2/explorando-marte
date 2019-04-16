import aircraft.Builders;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        final Builders builders = new Builders();
        final Scanner scanner = new Scanner(System.in);
        String directionList = null;

        directionList = scanner.nextLine();
        builders.getConverter().breakString(directionList);

        builders.getNasa().moveAircraft(builders.getConverter().getComandos());
        System.out.println("Localizado:  " + builders.getAircraft().getCoordinate() + " - Posicao: " + builders.getAircraft().getCompass());
    }
}

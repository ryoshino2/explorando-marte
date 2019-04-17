import aircraft.Builders;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        final Builders builders = new Builders();
        final Scanner scanner = new Scanner(System.in);
        String directionList = null;

        directionList = scanner.nextLine();
//        builders.getConverter().transformStringForInstruction(directionList);
//
//        builders.getNasa().moveAircraft(builders.getConverter().getCommands());

        builders.getAircraft().transformStringForInstruction(directionList);
        builders.getNasa().moveAircraft(builders.getAircraft().getCommands());
        System.out.println(builders.getAircraft().getCommands());
        System.out.println("" + builders.getAircraft().getCoordinate().getWidthCoordinate() + " " + builders.getAircraft().getCoordinate().getLengthCoordinate()  + " " + builders.getAircraft().getCompass().asChar());
    }
}

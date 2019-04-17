import aircraft.Builders;

public class Program {

    public static void main(String[] args) {
        final Builders builders = new Builders();

        //Inserir coordenadas
        String directionList = "MMR";

        builders.getAircraft().transformStringForInstruction(directionList);

        builders.getNasa().moveAircraft(builders.getAircraft().getCommands());
        System.out.println("" + builders.getAircraft().getCoordinate().getWidthCoordinate() + " " + builders.getAircraft().getCoordinate().getLengthCoordinate() + " " + builders.getAircraft().getCompass().asChar());

    }
}

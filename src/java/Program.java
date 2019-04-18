import aircraft.*;
import tableLand.TableLand;

public class Program {

    public static void main(String[] args) {

        final ConvertString convert = new ConvertString();

//        String posicaoSonda = "5 5";
//        String coordenadas = "1 1 N";
//        String directionList = "MMMR";

        String finalInstrucao = "5 5\n"
                + "1 1 N\n"
                + "MMR";

//        convert.transformStringForCoordinatesTableLand(posicaoSonda);
//        convert.transformStringForCoordinatesAircraft(coordenadas);
        convert.transformandoTudo(finalInstrucao);
//        Builders builders = new Builders(convert);
        final Coordinate coordinate = new Coordinate(convert.getCoodenadas().get(0), convert.getCoodenadas().get(1));
        final Aircraft aircraft = new Aircraft(coordinate, convert.getCompass().get(0));
        final TableLand tableLand = new TableLand(convert.getSuperficie().get(0), convert.getSuperficie().get(1));
        final Sensor sensor = new Sensor(tableLand);
        final Nasa nasa = new Nasa(aircraft, tableLand, sensor);


//        aircraft.transformStringForInstruction(finalInstrucao);

        nasa.moveAircraft(convert.getCommands());
        System.out.println("" + aircraft.getCoordinate().getWidthCoordinate() + " " + aircraft.getCoordinate().getLengthCoordinate() + " " + aircraft.getCompass().asChar());
    }
}

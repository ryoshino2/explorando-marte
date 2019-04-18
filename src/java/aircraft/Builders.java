package aircraft;

import tableLand.TableLand;

public class Builders {

    private ConvertString convertString;

    public Builders(ConvertString convertString) {
        this.convertString = convertString;
    }


    //    final Coordinate coordinate = new Coordinate(1, 2);
//    final Aircraft aircraft = new Aircraft(coordinate, Compass.N);
//    final TableLand tableLand = new TableLand(10,10);
//    final Sensor sensor = new Sensor(tableLand);
//    final Nasa nasa = new Nasa(aircraft,tableLand,sensor);

    final Coordinate coordinate = new Coordinate(convertString.getCoodenadas().get(0), convertString.getCoodenadas().get(1));
    final Aircraft aircraft = new Aircraft(coordinate, convertString.getCompass().get(0));
    final TableLand tableLand = new TableLand(convertString.getSuperficie().get(0), convertString.getSuperficie().get(1));
    final Sensor sensor = new Sensor(tableLand);
    final Nasa nasa = new Nasa(aircraft, tableLand, sensor);

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public TableLand getTableLand() {
        return tableLand;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Nasa getNasa() {
        return nasa;
    }


}

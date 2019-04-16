package aircraft;

import converter.Converter;
import instruction.Compass;
import tableLand.TableLand;

public class Builders {
    private final Coordinate coordinate = new Coordinate(1, 2);
    private final Aircraft aircraft = new Aircraft(coordinate, Compass.NORTH);
    private final TableLand tableLand = new TableLand("marte", 10, 10);
    private final Sensor sensor = new Sensor(tableLand);
    private final Nasa nasa = new Nasa(aircraft, tableLand, sensor);
    private final Converter converter = new Converter();

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

    public Converter getConverter() {
        return converter;
    }
}

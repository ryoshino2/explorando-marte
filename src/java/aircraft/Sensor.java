package aircraft;

import tableLand.TableLand;

public class Sensor {

    private TableLand tableLand;

    public Sensor(TableLand tableLand) {
        this.tableLand = tableLand;
    }

    boolean verifyHaveSpaceTableLand(Aircraft aircraft) {
        if (tableLand.getLength() < aircraft.getCoordinate().getLengthCoordinate()
                || tableLand.getWidth() < aircraft.getCoordinate().getWidthCoordinate()) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifyWidthLenghtNegative(aircraft);
    }

    boolean verifyWidthLenghtNegative(Aircraft aircraft) {
        if (aircraft.getCoordinate().getLengthCoordinate() < 0 || aircraft.getCoordinate().getWidthCoordinate() < 0) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return true;
    }
}

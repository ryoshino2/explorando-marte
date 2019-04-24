package aircraft;

import tableLand.TableLand;

public class Sensor {

    private TableLand tableLand;

    public Sensor(TableLand tableLand) {
        this.tableLand = tableLand;
    }

    boolean verifyHaveSpaceTableLand(Aircraft aircraft) {
        if (tableLand.getLength() < aircraft.getLengthCoordinate() || tableLand.getWidth() < aircraft.getWidthCoordinate()) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifyWidthLenghtNegative(aircraft);
    }

    private boolean verifyWidthLenghtNegative(Aircraft aircraft) {
        if (aircraft.getLengthCoordinate() < 0 || aircraft.getWidthCoordinate() < 0) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifySubtractWidth(aircraft);
    }

    private boolean verifySubtractWidth(Aircraft aircraft) {
        if (tableLand.getWidth() < aircraft.getWidthCoordinate() && (aircraft.getCompass().asChar() == 'W')) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifyIncraseLength(aircraft);
    }

    private boolean verifyIncraseLength(Aircraft aircraft) {
        if (tableLand.getLength() < aircraft.getLengthCoordinate() + 1 && (aircraft.getCompass().asChar() == 'N')) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifySubtractLength(aircraft);
    }

    private boolean verifySubtractLength(Aircraft aircraft) {
        if (tableLand.getLength() < aircraft.getLengthCoordinate() && aircraft.getCompass().asChar() == 'S') {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifyIncraseWidth(aircraft);
    }

    private boolean verifyIncraseWidth(Aircraft aircraft) {
        if (tableLand.getWidth() < aircraft.getWidthCoordinate() + 1 && (aircraft.getCompass().asChar() == 'E')) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return true;
    }
}

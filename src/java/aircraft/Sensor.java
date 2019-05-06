package aircraft;

import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    private TableLand tableLand;
    private List<Aircraft> aircraftList = new ArrayList<>();

    public Sensor(TableLand tableLand) {
        this.tableLand = tableLand;
    }

    boolean verifyHaveSpaceTableLand(Aircraft aircraft) {
        if (tableLand.getLength() < aircraft.getLengthCoordinate() || tableLand.getWidth() < aircraft.getWidthCoordinate()) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifyWidthNegative(aircraft);
    }

    private boolean verifyWidthNegative(Aircraft aircraft) {
        if ((aircraft.getWidthCoordinate() - 1 < 0) && (aircraft.getCompass().asChar() == 'W')) {
            throw new IllegalArgumentException("Fora do terreno");
        }
        return verifyLengthNegative(aircraft);
    }

    private boolean verifyLengthNegative(Aircraft aircraft) {
        if ((aircraft.getLengthCoordinate() - 1 < 0) && aircraft.getCompass().asChar() == 'S') {
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

    public void markAircraftPosition(Aircraft aircraft) {
        for (Aircraft value : aircraftList) {
            if (aircraft.getLengthCoordinate().equals(value.getLengthCoordinate()) &&
                    aircraft.getWidthCoordinate().equals(value.getWidthCoordinate())) {
                throw new IllegalArgumentException("Já possui sonda no local");
            }
        }
        aircraftList.add(aircraft);
    }
}

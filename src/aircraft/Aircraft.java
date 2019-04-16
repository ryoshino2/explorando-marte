package aircraft;

import instruction.Compass;

public class Aircraft {

    private Coordinate coordinate;
    private Compass compass;

    public Aircraft(Coordinate coordinate, Compass compass) {
        this.coordinate = coordinate;
        this.compass = compass;
    }

    public Compass getCompass() {
        return compass;
    }

    void setCompass(Compass compass) {
        this.compass = compass;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Coordinate setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return coordinate;
    }

    @Override
    public String toString() {
        return "" + compass;
    }

}

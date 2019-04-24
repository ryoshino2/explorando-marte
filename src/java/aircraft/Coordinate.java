package aircraft;

public class Coordinate {
    private Integer widthCoordinate;
    private Integer lengthCoordinate;

    public Coordinate(Integer widthCoordinate, Integer lengthCoordinate) {
        this.widthCoordinate = widthCoordinate;
        this.lengthCoordinate = lengthCoordinate;
    }

    public Integer getLengthCoordinate() {
        return lengthCoordinate;
    }

    public Integer getWidthCoordinate() {
        return widthCoordinate;
    }

    @Override
    public String toString() {
        return widthCoordinate + ", " + lengthCoordinate;
    }
}

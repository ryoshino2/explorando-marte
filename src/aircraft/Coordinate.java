package aircraft;

public class Coordinate {
    private Integer widthCoordinate;
    private Integer lengthCoordinate;

    public Coordinate(Integer widthCoordinate, Integer lengthCoordinate){
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
        return widthCoordinate +", "+ lengthCoordinate;
    }

    public Coordinate incraseWidthCoordinate(){
        widthCoordinate = widthCoordinate+1;
        return this;
    }

    public Coordinate subtractWidthCoordinate(){
        widthCoordinate = widthCoordinate-1;
        return this;
    }

    public Coordinate incraseLengthCoordinate(){
        lengthCoordinate = lengthCoordinate+1;
        return this;
    }
    public Coordinate subtractLengthCoordinate(){
        lengthCoordinate = lengthCoordinate-1;
        return this;
    }
}

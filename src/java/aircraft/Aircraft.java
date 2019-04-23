package aircraft;

import instruction.Compass;

public class Aircraft {

    private Compass compass;
    private Integer widthCoordinate;
    private Integer lengthCoordinate;

    public Aircraft(Integer widthCoordinate, Integer lengthCoordinate, Compass compass) {
        this.widthCoordinate = widthCoordinate;
        this.lengthCoordinate = lengthCoordinate;
        this.compass = compass;
    }

    public Compass getCompass() {
        return compass;
    }

    void setCompass(Compass compass) {
        this.compass = compass;
    }

    public Integer getWidthCoordinate() {
        return widthCoordinate;
    }

    public Integer getLengthCoordinate() {
        return lengthCoordinate;
    }

    public Integer setCoordinate(Integer coordinate) {
        return coordinate;
    }

    public Integer incraseWidthCoordinate(){
        return widthCoordinate = widthCoordinate+1;
    }

    public Integer subtractWidthCoordinate(){
        return widthCoordinate = widthCoordinate-1;
    }

    public Integer incraseLengthCoordinate(){
        return lengthCoordinate = lengthCoordinate+1;
    }
    public Integer subtractLengthCoordinate(){
        return lengthCoordinate = lengthCoordinate-1;
    }
}

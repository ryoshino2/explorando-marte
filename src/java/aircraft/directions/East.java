package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class East implements CompassDirection {


    public Coordinate moveAircraft(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.getCoordinate().incraseWidthCoordinate());
    }

}

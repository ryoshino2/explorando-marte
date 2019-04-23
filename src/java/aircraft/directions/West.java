package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class West implements CompassDirection {

    public Integer moveAircraft(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.subtractWidthCoordinate());
    }

}

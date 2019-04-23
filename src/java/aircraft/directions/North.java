package aircraft.directions;

import aircraft.Aircraft;

public class North implements CompassDirection {

    public Integer moveAircraft(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.incraseLengthCoordinate());
    }
}

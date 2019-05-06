package aircraft.directions;

import aircraft.Aircraft;

public class West implements CompassDirection {

    public Integer moveAircraft(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.subtractWidthCoordinate());
    }

}

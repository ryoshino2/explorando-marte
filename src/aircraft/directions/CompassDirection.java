package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public interface CompassDirection {

    Coordinate moveAircraft(Aircraft aircraft);

}

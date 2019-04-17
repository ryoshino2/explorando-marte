package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class South implements CompassDirection {

    @Override
    public Coordinate moveAircraft(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.getCoordinate().subtractLengthCoordinate());
    }


}

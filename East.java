package aircraft.directions;

import aircraft.Aircraft;

public class East implements CompassDirection {
    
    public Integer moveAircraft(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.incraseWidthCoordinate());
    }

}

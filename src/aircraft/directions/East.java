package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class East implements SensorNave {

    @Override
    public Coordinate moverNave(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.getCoordinate().incraseWidthCoordinate());
    }


}

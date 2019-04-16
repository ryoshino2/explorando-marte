package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class West implements SensorNave {

    @Override
    public Coordinate moverNave(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.getCoordinate().subtractWidthCoordinate());
    }

}
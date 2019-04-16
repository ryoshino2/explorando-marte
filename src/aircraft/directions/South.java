package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class South implements SensorNave {

    @Override
    public Coordinate moverNave(Aircraft aircraft) {
        return aircraft.setCoordinate(aircraft.getCoordinate().subtractLengthCoordinate());
    }


}

package aircraft.directions;

import aircraft.Aircraft;
import aircraft.Coordinate;

public class North implements SensorNave {

    private SensorNave sensorNave;

    public North() {
        this.sensorNave = sensorNave;
    }


    @Override
    public Coordinate moverNave(Aircraft aircraft) {

        if (aircraft.getCompass().asChar() == 'N') {
            return aircraft.setCoordinate(aircraft.getCoordinate().incraseLengthCoordinate());
        } else {
            setNext(sensorNave);
            return sensorNave.moverNave(aircraft);
        }
    }


    public SensorNave setNext(SensorNave sensorNave) {
        return sensorNave;
    }
}

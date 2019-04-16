package aircraft;


import aircraft.directions.*;
import instruction.Direction;
import tableLand.TableLand;

import java.util.List;

public class Nasa {

    private final Aircraft aircraft;
    private final Sensor sensor;
    private int posicaoNaLista;

    public Nasa(Aircraft aircraft, TableLand tableLand, Sensor sensor) {
        this.aircraft = aircraft;
        this.sensor = sensor;
    }

    private void rotateAircraft(List<Direction> direction) {
        if (Direction.L.equals(direction.get(posicaoNaLista).asChar())) {
            aircraft.setCompass(NextDirection.getEsquerdaDe(aircraft.getCompass()));
        } else if (Direction.R.equals(direction.get(posicaoNaLista).asChar())) {
            aircraft.setCompass(NextDirection.getDireitaDe(aircraft.getCompass()));
        }
    }

    public void moveAircraft(List<Direction> direction) {
        for (posicaoNaLista = 0; posicaoNaLista < direction.size(); posicaoNaLista++) {
            if (sensor.verifyHaveSpaceTableLand(aircraft)) {
                switch (getDirectionList(direction).get(posicaoNaLista).asChar()) {
                    case L:
                    case R:
                        rotateAircraft(direction);
                        break;
                    case M:
                        sensorAircraft();
                        break;
                }
            }
        }

    }

    //Ajustar
    private void sensorAircraft() {
        SensorNave sensorNave = null;
        if (aircraft.getCompass().asChar() == 'N') {
            sensorNave = new North();
        }
        if (aircraft.getCompass().asChar() == 'W') {
            sensorNave = new West();
        }
        if (aircraft.getCompass().asChar() == 'E') {
            sensorNave = new East();
        }
        if (aircraft.getCompass().asChar() == 'S') {
            sensorNave = new South();
        }
        sensorNave.moverNave(aircraft);
    }

    private List<Direction> getDirectionList(List<Direction> directions) {
        for (Direction direction : directions) {
            direction.asChar();
        }
        return directions;
    }

    @Override
    public String toString() {
        return aircraft + " ";
    }
}

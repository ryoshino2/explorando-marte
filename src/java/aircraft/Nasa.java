package aircraft;


import aircraft.directions.*;
import instruction.Instruction;
import tableLand.TableLand;

import java.util.List;

public class Nasa {

    private final Aircraft aircraft;
    private final Sensor sensor;
    private int positionList;

    public Nasa(Aircraft aircraft, TableLand tableLand, Sensor sensor) {
        this.aircraft = aircraft;
        this.sensor = sensor;
    }

    private void rotateAircraft(List<Instruction> instruction) {
        if (Instruction.L.equals(instruction.get(positionList).asChar())) {
            aircraft.setCompass(NextDirection.getLeftOf(aircraft.getCompass()));
        } else if (Instruction.R.equals(instruction.get(positionList).asChar())) {
            aircraft.setCompass(NextDirection.getRightOf(aircraft.getCompass()));
        }
    }

    public void moveAircraft(List<Instruction> instruction) {
        for (positionList = 0; positionList < instruction.size(); positionList++) {
            switch (getDirectionList(instruction).get(positionList).asChar()) {
                case L:
                    // Falls through
                case R:
                    rotateAircraft(instruction);
                    break;
                case M:
                    if (sensor.verifyHaveSpaceTableLand(aircraft)) {
                        sensorAircraft();
                    }
                    break;
            }
        }
    }

    private void sensorAircraft() {
        CompassDirection sensorNave = null;
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
        assert sensorNave != null;
        sensorNave.moveAircraft(aircraft);
    }

    private List<Instruction> getDirectionList(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            instruction.asChar();
        }
        return instructions;
    }

    @Override
    public String toString() {
        return aircraft + " ";
    }
}

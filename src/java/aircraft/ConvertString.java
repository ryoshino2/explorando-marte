package aircraft;

import instruction.Compass;
import instruction.Instruction;
import tableLand.TableLand;

import java.util.ArrayList;
import java.util.List;

public class ConvertString {

    private final List<Integer> subList = new ArrayList<>();
    private final List<Integer> tableLandCoordinates = new ArrayList<>();
    private final List<Aircraft> aircrafts = new ArrayList<>();
    private final List<Instruction> commands = new ArrayList<>();
    private final List<Integer> coordinates = new ArrayList<>();
    private final List<Compass> compass = new ArrayList<>();

    private String[] arrayString(String word) {
        return word.split("\n");
    }

    public TableLand transformStringForCoordinateTableLand(String word) {
        String[] arrayCoordinate = arrayString(word)[0].split(" ");

        try {
            int[] integerValueSize = new int[arrayCoordinate.length];
            for (int i = 0; i < integerValueSize.length; i++) {
                integerValueSize[i] = Integer.parseInt(String.valueOf(arrayCoordinate[i]));
                tableLandCoordinates.add(integerValueSize[i]);
            }
          return  new TableLand(tableLandCoordinates.get(0), tableLandCoordinates.get(1));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    private void instructionForNasa(TableLand tableLand, Sensor sensor) {
        for (int i = 0; i < aircrafts.size(); i++) {
            Integer start = 0;
            Integer sizeInstruction = subList.get(i);
            Nasa nasa = new Nasa(aircrafts.get(i), tableLand, sensor);

            if (i == 0) {
                nasa.moveAircraft(getCommands().subList(start, sizeInstruction));
            } else {
                int finish;
                start = subList.get(i - 1);
                finish = sizeInstruction + start;
                nasa.moveAircraft(getCommands().subList(start, finish));
            }
        }
    }

    public void positionAircraft(String word) {
        int valueController = 0;
        for (int i = 0; i < arrayString(word).length; i++) {
            int[] integerValueSize = new int[arrayString(word)[i].length() - 1];
            String[] arrayCoordinate = arrayString(word)[i].split(" ");
            if (i % 2 != 0) {
                for (int j = 0; j < 2; j++) {
                    integerValueSize[j] = Integer.parseInt(String.valueOf(arrayCoordinate[j]));
                    coordinates.add(integerValueSize[j]);
                    if (j == 1) {
                        compass.add(Compass.valueOf(String.valueOf(arrayCoordinate[arrayCoordinate.length - 1])));
                        aircrafts.add(new Aircraft(coordinates.get(i - 1), coordinates.get(i), compass.get(valueController)));
                        valueController += 1;
                    }
                }
            }
        }
    }

    public void runInstructions(String word){
        transformStringForCoordinateTableLand(word);
        positionAircraft(word);
        coordinateAircraft(word);
        Sensor sensor = new Sensor(transformStringForCoordinateTableLand(word));
        instructionForNasa(transformStringForCoordinateTableLand(word), sensor);
    }


    public void coordinateAircraft(String word) {
        for (int i = 1; i < arrayString(word).length; i++) {
            String[] arrayInstruction = (arrayString(word)[i].split("\n"));
            String[] words = arrayInstruction[0].split("");

            if (i % 2 == 0) {
                subList.add(words.length);
                for (String command : words) {
                    commands.add(Instruction.valueOf(command.toUpperCase()));
                }
            }
        }
    }

    public List<Instruction> getCommands() {
        return commands;
    }

    public void viewAircraft() {
        for (int i = 0; i < getAircrafts().size(); i++) {
            System.out.println(getAircrafts().get(i).getWidthCoordinate() + " " + getAircrafts().get(i).getLengthCoordinate() + " " + getAircrafts().get(i).getCompass());
        }
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public List<Compass> getCompass() {
        return compass;
    }

    public List<Integer> getCoordinates() {
        return coordinates;
    }

    public List<Integer> getTableLandCoordinates() {
        return tableLandCoordinates;
    }
}

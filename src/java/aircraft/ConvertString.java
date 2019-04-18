package aircraft;

import instruction.Compass;
import instruction.Instruction;

import java.util.ArrayList;
import java.util.List;

public class ConvertString {

    private List<Integer> superficie = new ArrayList<>();
    private List<Instruction> commands = new ArrayList<Instruction>();
    private List<Integer> coodenadas = new ArrayList<>();
    private List<Compass> compass = new ArrayList<>();

    public void transformStringForCoordinatesTableLand(String palavra) {
        try {
            String[] arrayValores = palavra.split(" ");
            int[] valorInteiros = new int[arrayValores.length];
            for (int i = 0; i < valorInteiros.length; i++) {
                valorInteiros[i] = Integer.parseInt(String.valueOf(arrayValores[i]));
                superficie.add(valorInteiros[i]);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    public void transformStringForInstruction(String palavra) {
        try {
            for (int i = 0; i < palavra.length(); i++) {
                commands.add(Instruction.valueOf(palavra.toUpperCase().substring(i, i + 1)));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    public void transformStringForCoordinatesAircraft(String palavra) {
        try {
            String[] arrayValores = palavra.split(" ");
            int[] valorInteiros = new int[arrayValores.length - 1];

            for (int i = 0; i < 2; i++) {
                valorInteiros[i] = Integer.parseInt(String.valueOf(arrayValores[i]));
                coodenadas.add(valorInteiros[i]);
            }
            compass.add(Compass.valueOf(String.valueOf(arrayValores[arrayValores.length - 1])));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    public void transformandoTudo(String palavra) {
        try {
            //Quebro toda String em Arrays
            String[] arrayValores = palavra.split("\n");

            //Separo a primeira linha para Coordenadas
            String [] arrayCoordenada = arrayValores[0].split(" ");

            //Separo a segunda linha para Inicio da Sonda
            String [] arrayInicioSonda = arrayValores[1].split(" ");

            String arrayInstrucoes = arrayValores[2];

            int[] valorInteiros = new int[arrayInicioSonda.length];


            for (int i = 0; i < arrayValores.length -1; i++) {
                valorInteiros[i] = Integer.parseInt(String.valueOf(arrayCoordenada[i]));
                superficie.add(valorInteiros[i]);
            }
            System.out.println(getSuperficie());


            int[] valorInicioSonda   = new int[arrayInicioSonda.length-1];
            for (int i = 0; i < 2; i++) {
                valorInicioSonda[i] = Integer.parseInt(String.valueOf(arrayInicioSonda[i]));
                coodenadas.add(valorInicioSonda[i]);
            }
            compass.add(Compass.valueOf(String.valueOf(arrayInicioSonda[arrayInicioSonda.length - 1])));
            System.out.println(getCoodenadas());

            for (int i = 0; i < arrayInstrucoes.length(); i++) {
                commands.add(Instruction.valueOf(arrayInstrucoes.toUpperCase().substring(i, i + 1)));
            }

            System.out.println(getCommands());


        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    public List<Integer> getSuperficie() {
        return superficie;
    }

    public List<Instruction> getCommands() {
        return commands;
    }

    public List<Integer> getCoodenadas() {
        return coodenadas;
    }

    public List<Compass> getCompass() {
        return compass;
    }
}

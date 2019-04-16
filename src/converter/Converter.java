package converter;

import instruction.Direction;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private List<Direction> comandos = new ArrayList<>();

    public void breakString(String palavra) {
        try {
            for (int i = 0; i < palavra.length(); i++) {
                comandos.add(Direction.valueOf(palavra.toUpperCase().substring(i, i + 1)));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Direcao desconhecida");
        }
    }

    public List<Direction> getComandos() {
        return comandos;
    }

}

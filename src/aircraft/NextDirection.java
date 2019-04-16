package aircraft;

import instruction.Compass;

import java.util.HashMap;
import java.util.Map;

final class NextDirection {

    private static Map<Compass, NextDirection> rosaDosVentos;

    static {
        rosaDosVentos = new HashMap<Compass, NextDirection>();
        rosaDosVentos.put(Compass.NORTH, new NextDirection(Compass.EAST, Compass.WEST));
        rosaDosVentos.put(Compass.SOUTH, new NextDirection(Compass.WEST, Compass.EAST));
        rosaDosVentos.put(Compass.EAST, new NextDirection(Compass.SOUTH, Compass.NORTH));
        rosaDosVentos.put(Compass.WEST, new NextDirection(Compass.NORTH, Compass.SOUTH));
    }

    private Compass right;
    private Compass left;

    private NextDirection(Compass right, Compass left) {
        this.right = right;
        this.left = left;
    }

    static Compass getDireitaDe(Compass direcaoAtual) {
        return rosaDosVentos.get(direcaoAtual).getRight();
    }

    static Compass getEsquerdaDe(Compass direcaoAtual) {
        return rosaDosVentos.get(direcaoAtual).getLeft();
    }

    private Compass getLeft() {
        return left;
    }

    private Compass getRight() {
        return right;
    }

}

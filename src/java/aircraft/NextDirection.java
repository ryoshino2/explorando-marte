package aircraft;

import instruction.Compass;

import java.util.HashMap;
import java.util.Map;

final class NextDirection {

    private static Map<Compass, NextDirection> windRose;

    static {
        windRose = new HashMap<Compass, NextDirection>();
        windRose.put(Compass.N, new NextDirection(Compass.E, Compass.W));
        windRose.put(Compass.S, new NextDirection(Compass.W, Compass.E));
        windRose.put(Compass.E, new NextDirection(Compass.S, Compass.N));
        windRose.put(Compass.W, new NextDirection(Compass.N, Compass.S));
    }

    private Compass right;
    private Compass left;

    private NextDirection(Compass right, Compass left) {
        this.right = right;
        this.left = left;
    }

    static Compass getRightOf(Compass currentDirection) {
        return windRose.get(currentDirection).getRight();
    }

    static Compass getLeftOf(Compass currentDirection) {
        return windRose.get(currentDirection).getLeft();
    }

    private Compass getLeft() {
        return left;
    }

    private Compass getRight() {
        return right;
    }

}

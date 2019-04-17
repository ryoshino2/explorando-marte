package aircraft;

import instruction.Compass;

import java.util.HashMap;
import java.util.Map;

final class NextDirection {

    private static Map<Compass, NextDirection> windRose;

    static {
        windRose = new HashMap<Compass, NextDirection>();
        windRose.put(Compass.NORTH, new NextDirection(Compass.EAST, Compass.WEST));
        windRose.put(Compass.SOUTH, new NextDirection(Compass.WEST, Compass.EAST));
        windRose.put(Compass.EAST, new NextDirection(Compass.SOUTH, Compass.NORTH));
        windRose.put(Compass.WEST, new NextDirection(Compass.NORTH, Compass.SOUTH));
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

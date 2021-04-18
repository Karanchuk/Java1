package HW_7;

public class Plate {
    private int food;
    private final int capacity = 100;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        }
        return false;
    }

    public void increaseFood(int n) {
        int tmpSize = food + n;
        food = Math.min(tmpSize, capacity);
    }

    public void increaseFood() {
        food = capacity;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

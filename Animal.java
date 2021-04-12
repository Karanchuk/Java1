public abstract class Animal {
    private final String name;
    private static int numb;

    public Animal(String name) {
        this.name = name;
        numb++;
    }

    public String getName() {
        return name;
    }

    public static int getNumb() {
        return numb;
    }

    public void doAction(String action, int distance) {
        String string = String.format("%s %s %d м%n", name, action, distance);
        System.out.print(string);
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}

public class Dog extends Animal{

    private static int numb;

    public Dog(String name) {
        super(name);
        numb++;
    }

    public void showNumb() {
        System.out.println("Dogs - " + numb + ", animals - " + super.getNumb());
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.doAction("пробежал", distance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.doAction("проплыл", distance);
        }
    }
}

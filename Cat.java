public class Cat extends Animal{

    private static int numb;

    public Cat(String name) {
        super(name);
        numb++;
    }

    public void showNumb() {
        System.out.println("Cats - " + numb + ", animals - " + super.getNumb());
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.doAction("пробежал", distance);
        }
    }

    @Override
    public void swim(int distance) {
        String string = String.format("%s не умеет плавать%n", super.getName());
        System.out.println(string);
    }
}

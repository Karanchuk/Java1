public class Triathlon {
    public static void main(String[] args) {
        Cat murzik = new Cat("Мурзик");
        Dog bobik = new Dog("Бобик");

        bobik.run(30);
        murzik.run(16);
        bobik.swim(8);
        murzik.swim(2);

        bobik.showNumb();
        murzik.showNumb();

    }

}

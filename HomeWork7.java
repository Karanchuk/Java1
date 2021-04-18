package HW_7;

public class HomeWork7 {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length ; i++) {
            cats[i] = new Cat("Barsik " + i, (int) (Math.random() * 40));
        }

        Plate plate = new Plate(100);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.printf("%s with appetite %d %s%n", cats[i].getName(), cats[i].getAppetite(), (cats[i].isSatiety() ? "is satisfying" : "still hungry"));
        }

        plate.info();
        plate.increaseFood(15);
        plate.info();
    }
}


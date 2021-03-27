public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        
    }

    static void printThreeWords() {
        String[] fruits = {"Orange", "Banana", "Apple"};

        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }

    static void checkSumSign() {
        int a = 1;
        int b = -2;
        if (a + b < 0) {
            System.out.println("Сумма отрицательная");
        } else {
            System.out.println("Сумма положительная");
        }
    }

    static void printColor() {
        int value = 500;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 100;
        int b = 25;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /*1. Написать метод, принимающий на вход два целых числа
    * и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
    * если да – вернуть true, в противном случае – false.
    */
    static boolean isInRange(int a, int b) {
        boolean result = false;
        if (a + b >= 10 && a + b <= 20) {
            result = true;
        }
        return result;
    }

    /*2. Написать метод, которому в качестве параметра передается целое число,
    * метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    * Замечание: ноль считаем положительным числом.
    */
    static void writeIsPositiveOrNegative(int number) {
        System.out.println("Число " + (isNegativeNumber(number) ? "отрицательное" : "положительное"));
    }
    /*3. Написать метод, которому в качестве параметра передается целое число.
    * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    */
    static boolean isNegativeNumber(int number) {
        boolean numberSign;
        if (number < 0) {
            numberSign = true;
        } else {
            numberSign = false;
        }
        return numberSign;
    }
    /*4. Написать метод, которому в качестве аргументов передается строка и число,
    * метод должен отпечатать в консоль указанную строку, указанное количество раз;
    * */
    static void printLine(String line, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(line);
        }
    }
    /*5. * Написать метод, который определяет, является ли год високосным,
    * и возвращает boolean (високосный - true, не високосный - false).
    * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}














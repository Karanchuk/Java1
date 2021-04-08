import java.util.Random;
import java.util.Scanner;

public class homeWork3 {
    public static void main(String[] args) {

        System.out.println(" – Exercise 1");
        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        boolean inRange = isInRange(a, b);
        String string = String.format("Sum of integers %d and %d %s range of 10 to 20", a, b , (inRange ? "is in" : "out of"));
        System.out.println(string + "\n");

        System.out.println(" – Exercise 2");
        writeIsPositiveOrNegative(random.nextInt());
        System.out.println();

        System.out.println(" – Exercise 4");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input some string");
        String str = scanner.nextLine();
        System.out.println("Now specify how many times this line will be displayed");
        printLine(str, scanner.nextInt());
        System.out.println();

        System.out.println(" – Exercise 5");
        System.out.println("Please input some year");
        System.out.println(String.format("This is %s a leap year", (isLeapYear(scanner.nextInt()) ? "" : "not")));
    }

    /*1. Написать метод, принимающий на вход два целых числа
     * и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
     * если да – вернуть true, в противном случае – false.
     */
    static boolean isInRange(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }

    /*2. Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     * Замечание: ноль считаем положительным числом.
     */
    static void writeIsPositiveOrNegative(int number) {
        String string = String.format("Integer %d is %s", number, (isNegativeNumber(number) ? "negative" : "positive"));
        System.out.println(string);
    }
    /*3. Написать метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    static boolean isNegativeNumber(int number) {
        return number < 0;
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

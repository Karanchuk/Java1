import java.sql.Statement;
import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        doFrom1To4();
        findMinMaxValue();

        int[] array7 = {2, 2, 2, 2, 2, 6};
        System.out.println(checkBalance(array7));

        int[] array8 = {1, 2, 3, 4};
        shiftElements(array8, -2);
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

    static void doFrom1To4() {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            }
        }

        // 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        int[] array2 = new int [100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */
        int[][] array4 = new int[10][10];
        for (int i = 0; i < array4.length; i++) {
            for (int j =  0; j < array4[i].length; j++) {
                if (i == j || array4.length - i == j + 1) {
                    array4[i][j] = 1;
                }
                //System.out.print(array4[i][j]);
                //System.out.print(" ");
            }
            //System.out.println();
        }
    }

    /*5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
     */
    static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    // 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    static void findMinMaxValue() {
        int[] array = {6, 0, 3, 15, -5, 12, -32, 89, 53, 16};
        int min = 0;
        int max = 0;
        System.out.print("For array [");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min || i == 0) {
                min = array[i];
            }
            if (array[i] > max || i == 0) {
                max = array[i];
            }
            System.out.print(array[i] + (i < array.length - 1 ? ", " : ""));
        }
        System.out.println("] minimum value is " + min + ", maximum is " + max);
    }
    /* ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.

     **Примеры:
     checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */
    static boolean checkBalance(int[] array) {
        boolean balanceFound = false;
        int leftSum = 0;
        int rightSum = Arrays.stream(array).sum();

        /*for (int i = 0; i < array.length; i++) {
            rightSum = rightSum + array[i];
        }*/

        for (int i = 0; i < array.length; i++) {
            leftSum = leftSum + array[i];
            rightSum = rightSum - array[i];
            if (leftSum == rightSum) {
                balanceFound = true;
                break;
            }
        }
        return balanceFound;
    }
    /*8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций.
    Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
        [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
     */
    static void shiftElements(int[] array, int n) {
        while (n != 0) {
            if (n > 0) { // for positive n
                for (int i = 0; i < array.length - 1; i++) {
                    array[array.length - 1] = array[array.length - 1] + array[i];
                    array[i] = array[array.length - 1] - array[i];
                    array[array.length - 1] = array[array.length - 1] - array[i];
                }
                n--;
            } else if (n < 0) { // for negative n
                for (int i = array.length - 1; i > 0; i--) {
                    array[0] = array[0] + array[i];
                    array[i] = array[0] - array[i];
                    array[0] = array[0] - array[i];
                }
                n++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}














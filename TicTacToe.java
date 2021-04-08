import java.util.Random;
import java.util.Scanner;

class MoveCounter {
    private int horizontalCounter = 0;
    private int verticalCounter = 0;
    private int diagonalCounter = 0;
    private int reverseDiagonalCounter = 0;

    public MoveCounter() {
    }

    public int getHorizontalCounter() {
        return horizontalCounter;
    }

    public void increaseHorizontalCounter(int value) {
        this.horizontalCounter += value;
    }

    public int getVerticalCounter() {
        return verticalCounter;
    }

    public void increaseVerticalCounter(int value) {
        this.verticalCounter += value;
    }

    public int getDiagonalCounter() {
        return diagonalCounter;
    }

    public void increaseDiagonalCounter(int value) {
        this.diagonalCounter += value;
    }

    public int getReverseDiagonalCounter() {
        return reverseDiagonalCounter;
    }

    public void increaseReverseDiagonalCounter(int value) {
        this.reverseDiagonalCounter += value;
    }

    public void resetHorizontalAndVertical() {
        this.horizontalCounter = 0;
        this.verticalCounter = 0;
    }
}

public class TicTacToe {
    static void start() {
        char[][] field = createField(5);
        drawField(field);

        while (true) {
            doPlayerMove(field);
            if (isWin(field, 'X') || isDraw(field)) {
                break;
            }

            doAIMove(field);
            if (isWin(field, 'O') || isDraw(field)) {
                break;
            }
        }
    }

    static boolean isWin(char[][] field, char sign) {

        MoveCounter moveCounter = new MoveCounter();

        for (int i = 0; i < field.length; i++) {
            moveCounter = changeCounters(field, i, sign, moveCounter);
            if (moveCounter.getHorizontalCounter() == field.length - 1 || moveCounter.getVerticalCounter() == field.length - 1) {
                return true;
            }
        }

        if (moveCounter.getDiagonalCounter() == field.length - 1 || moveCounter.getReverseDiagonalCounter() == field.length - 1) {
            return true;
        }

        return false;
    }

    static MoveCounter changeCounters(char[][] field, int i, char sign, MoveCounter moveCounter) {

        moveCounter.resetHorizontalAndVertical();

        for (int j = 0; j < field[i].length; j++) {
            if (field[i][j] == sign) {
                moveCounter.increaseHorizontalCounter(1);
            }
            if (field[j][i] == sign) {
                moveCounter.increaseVerticalCounter(1);
            }
            if (i == j && field[i][j] == sign) {
                moveCounter.increaseDiagonalCounter(1);
            }
            if (field.length - 1 - i == j && field[i][j] == sign) {
                moveCounter.increaseReverseDiagonalCounter(1);
            }
        }
        return moveCounter;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isCellFree(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void doAIMove(char[][] field) {

        int[] coordinates = tryToBlockOpponentsMove(field);
        field[coordinates[0]][coordinates[1]] = 'O';
        drawField(field);
    }

    static void doPlayerMove(char[][] field) {
        int row;
        int col;
        do {
            System.out.println("Please input coordinates...");
            row = getCoordinate("row", field.length);
            col = getCoordinate("col", field.length);
        } while (isCellOccupied(field, row, col));

        field[row][col] = 'X';
        drawField(field);
    }

    static boolean isCellFree(char[][] field, int row, int col) {
        return !isCellOccupied(field, row, col);
    }

    static boolean isCellOccupied(char[][] field, int row, int col) {
        return field[row][col] != '-';
    }

    static int getCoordinate(String coordType, int fieldLength) {
        Scanner scanner = new Scanner(System.in);
        int coord;

        do {
            System.out.printf("Please input %s-coordinate [1-%d]...%n", coordType, fieldLength);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord >= fieldLength);

        return coord;
    }

    static char[][] createField(int length) {
        char[][] array = new char[length][length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                array[i][j] = '-';
            }
        }
        return array;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[] tryToBlockOpponentsMove(char[][] field) {

        int[] response = new int[2];
        MoveCounter moveCounter = new MoveCounter();

        int[][] usedCellCounter = new int[field.length][2];
        int maxCount = 0;

        for (int i = 0; i < field.length; i++) {
            moveCounter = changeCounters(field, i, 'X', moveCounter);

            maxCount = (maxCount > moveCounter.getVerticalCounter() ? maxCount : moveCounter.getVerticalCounter());
            maxCount = (maxCount > moveCounter.getHorizontalCounter() ? maxCount : moveCounter.getHorizontalCounter());

            usedCellCounter[i][0] = moveCounter.getVerticalCounter();
            usedCellCounter[i][1] = moveCounter.getHorizontalCounter();
        }

        maxCount = (maxCount > moveCounter.getDiagonalCounter() ? maxCount : moveCounter.getDiagonalCounter());
        maxCount = (maxCount > moveCounter.getReverseDiagonalCounter() ? maxCount : moveCounter.getReverseDiagonalCounter());

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (maxCount == moveCounter.getDiagonalCounter()) {
                    // find empty cell in diagonal
                    if (i == j && !isCellOccupied(field, i, j)) {
                        response[0] = i;
                        response[1] = j;
                        return response;
                    }
                } else if (maxCount == moveCounter.getDiagonalCounter()) {
                    // find empty cell in reverse diagonal
                    if (field.length - 1 - i == j && !isCellOccupied(field, i, j)) {
                        response[0] = i;
                        response[1] = j;
                        return response;
                    }
                } else if (maxCount == usedCellCounter[i][0]) {
                    // find empty cell in vertical
                    if (!isCellOccupied(field, j, i)) {
                        response[0] = j;
                        response[1] = i;
                        return response;
                    }
                } else if (maxCount == usedCellCounter[i][1]) {
                    // find empty cell in horizontal
                    if (!isCellOccupied(field, i, j)) {
                        response[0] = i;
                        response[1] = j;
                        return response;
                    }
                }
            }
        }
        // get random cell
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(field.length);
            col = random.nextInt(field.length);
        } while (isCellOccupied(field, row, col));
        response[0] = row;
        response[1] = col;

        return response;
    }
}
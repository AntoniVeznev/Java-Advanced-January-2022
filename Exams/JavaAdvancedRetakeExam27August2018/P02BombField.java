package Exams.JavaAdvancedRetakeExam27August2018;

import java.util.Scanner;

public class P02BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        boolean flag = false;

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();
        }

        int currentRow = 0, currentCol = 0, countBomb = 0, existBomb = 0;
        int oldRow = 0;
        int oldCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    currentRow = row;
                    currentCol = col;
                } else if (matrix[row][col] == 'B') {
                    existBomb++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("up")) {
                currentRow--;
            } else if (command.equals("down")) {
                currentRow++;
            } else if (command.equals("left")) {
                currentCol--;
            } else if (command.equals("right")) {
                currentCol++;
            }

            if (currentRow == -1) {
                currentRow = 0;
            } else if (currentCol < 0) {
                currentCol = 0;
            } else if (currentRow > size - 1) {
                currentRow = matrix.length - 1;
            } else if (currentCol > size - 1) {
                currentCol = matrix.length - 1;
            }


            if (matrix[currentRow][currentCol] == 'B') {
                countBomb++;
                matrix[oldRow][oldCol] = '+';
                matrix[currentRow][currentCol] = 's';
                System.out.println("You found a bomb!");
            } else if (matrix[currentRow][currentCol] == 'e') {
                matrix[oldRow][oldCol] = '+';
                matrix[currentRow][currentCol] = 's';
                System.out.printf("END! %d bombs left on the field%n", existBomb - countBomb);
                flag = true;
                break;
            }

        }
        if (existBomb - countBomb == 0) {
            flag = true;
            System.out.println("Congratulations! You found all bombs!");
        }
        if (!flag)
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", existBomb - countBomb, currentRow, currentCol);

    }
}

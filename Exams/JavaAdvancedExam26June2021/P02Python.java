package Exams.JavaAdvancedExam26June2021;

import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        String[] commandsArr = scanner.nextLine().split(", ");
        int pythonLength = 1;
        int allFoodInTheField = 0;
        int rowPython = 0;
        int colPython = 0;
        boolean weGoToEnemy = false;
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    rowPython = row;
                    colPython = col;
                }
                if (matrix[row][col] == 'f') {
                    allFoodInTheField++;
                }
            }
        }
        for (int i = 0; i < commandsArr.length; i++) {
            if (allFoodInTheField == 0) {
                break;
            }
            String command = commandsArr[i];
            int oldRow = rowPython;
            int oldCol = colPython;
            if (command.equals("up")) {
                rowPython--;
            } else if (command.equals("down")) {
                rowPython++;
            } else if (command.equals("left")) {
                colPython--;
            } else if (command.equals("right")) {
                colPython++;
            }
            if (rowPython < 0) {
                matrix[oldRow][oldCol] = '*';
                rowPython = matrix.length - 1;
                if (matrix[rowPython][colPython] == 'e') {
                    matrix[oldRow][oldCol] = 's';
                    weGoToEnemy = true;
                    break;
                } else if (matrix[rowPython][colPython] == 'f') {
                    pythonLength++;
                    allFoodInTheField--;
                    matrix[rowPython][colPython] = 's';
                } else {
                    matrix[oldRow][oldCol] = '*';
                    matrix[rowPython][colPython] = 's';
                }
            } else if (rowPython >= matrix.length) {
                matrix[oldRow][oldCol] = '*';
                rowPython = 0;
                if (matrix[rowPython][colPython] == 'e') {
                    matrix[oldRow][oldCol] = 's';
                    weGoToEnemy = true;
                    break;
                } else if (matrix[rowPython][colPython] == 'f') {
                    pythonLength++;
                    allFoodInTheField--;
                    matrix[rowPython][colPython] = 's';
                } else {
                    matrix[oldRow][oldCol] = '*';
                    matrix[rowPython][colPython] = 's';
                }
            } else if (colPython < 0) {
                matrix[oldRow][oldCol] = '*';
                colPython = matrix.length - 1;
                if (matrix[rowPython][colPython] == 'e') {
                    matrix[oldRow][oldCol] = 's';
                    weGoToEnemy = true;
                    break;
                } else if (matrix[rowPython][colPython] == 'f') {
                    pythonLength++;
                    allFoodInTheField--;
                    matrix[rowPython][colPython] = 's';
                } else {
                    matrix[oldRow][oldCol] = '*';
                    matrix[rowPython][colPython] = 's';
                }
            } else if (colPython >= matrix.length) {
                matrix[oldRow][oldCol] = '*';
                colPython = 0;
                if (matrix[rowPython][colPython] == 'e') {
                    matrix[oldRow][oldCol] = 's';
                    weGoToEnemy = true;
                    break;
                } else if (matrix[rowPython][colPython] == 'f') {
                    pythonLength++;
                    allFoodInTheField--;
                    matrix[rowPython][colPython] = 's';
                } else {
                    matrix[oldRow][oldCol] = '*';
                    matrix[rowPython][colPython] = 's';
                }
            }
            if (matrix[rowPython][colPython] == 'e') {
                weGoToEnemy = true;
                break;
            } else if (matrix[rowPython][colPython] == 'f') {
                pythonLength++;
                allFoodInTheField--;
                matrix[oldRow][oldCol] = '*';
                matrix[rowPython][colPython] = 's';
            } else if (matrix[rowPython][colPython] == '*') {
                matrix[oldRow][oldCol] = '*';
                matrix[rowPython][colPython] = 's';
            }
        }
        if (allFoodInTheField == 0) {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        }
        if (allFoodInTheField > 0 && !weGoToEnemy) {
            System.out.printf("You lose! There is still %d food to be eaten.", allFoodInTheField);
        }
        if (weGoToEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        }
    }
}
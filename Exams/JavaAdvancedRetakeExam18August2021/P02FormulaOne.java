package Exams.JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][rows];
        int rowCar = 0;
        int colCar = 0;
        boolean heFinished = false;
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'P') {
                    rowCar = row;
                    colCar = col;
                }
            }
        }
        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();
            int oldRow = rowCar;
            int oldCol = colCar;
            if (command.equals("up")) {
                rowCar--;
            } else if (command.equals("down")) {
                rowCar++;
            } else if (command.equals("left")) {
                colCar--;
            } else if (command.equals("right")) {
                colCar++;
            }
            if (rowCar < 0) {
                matrix[oldRow][oldCol] = '.';
                rowCar = matrix.length - 1;
                matrix[rowCar][colCar] = 'P';
            } else if (rowCar >= matrix.length) {
                matrix[oldRow][oldCol] = '.';
                rowCar = 0;
                matrix[rowCar][colCar] = 'P';
            } else if (colCar < 0) {
                matrix[oldRow][oldCol] = '.';
                colCar = matrix.length - 1;
                matrix[rowCar][colCar] = 'P';
            } else if (colCar >= matrix.length) {
                matrix[oldRow][oldCol] = '.';
                colCar = 0;
                matrix[rowCar][colCar] = 'P';
            }
            if (matrix[rowCar][colCar] == 'B') {
                matrix[oldRow][oldCol] = '.';
                oldRow = rowCar;
                oldCol = colCar;
                if (command.equals("up")) {
                    rowCar--;
                } else if (command.equals("down")) {
                    rowCar++;
                } else if (command.equals("left")) {
                    colCar--;
                } else if (command.equals("right")) {
                    colCar++;
                }
                if (matrix[rowCar][colCar] == 'T') {
                    matrix[oldRow][oldCol] = 'P';
                } else if (matrix[rowCar][colCar] == '.') {
                    matrix[rowCar][colCar] = 'P';
                }
            }
            if (matrix[rowCar][colCar] == 'T') {
                matrix[oldRow][oldCol] = 'P';
                rowCar = oldRow;
                colCar = oldCol;
            }
            if (matrix[rowCar][colCar] == 'F') {
                matrix[oldRow][oldCol] = '.';
                matrix[rowCar][colCar] = 'P';
                heFinished = true;
                break;
            }
            if (matrix[rowCar][colCar] == '.') {
                matrix[oldRow][oldCol] = '.';
                matrix[rowCar][colCar] = 'P';
            }


        }
        if (heFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
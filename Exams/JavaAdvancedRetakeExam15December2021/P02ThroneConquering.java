package Exams.JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        int parisRow = 0;
        int parisCol = 0;
        int helenRow = 0;
        int helenCol = 0;
        int sizeCol = 0;
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            sizeCol = matrix[row].length;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < sizeCol; col++) {
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
                if (matrix[row][col] == 'H') {
                    helenRow = row;
                    helenCol = col;
                }
            }
        }
        boolean helenaIsAbducted = false;
        while (energy > 0 && matrix[parisRow][parisCol] != matrix[helenRow][helenCol]) {
            String[] commandArr = scanner.nextLine().split("\\s+");
            String command = commandArr[0];
            int spartanRow = Integer.parseInt(commandArr[1]);
            int spartanCol = Integer.parseInt(commandArr[2]);
            matrix[spartanRow][spartanCol] = 'S';
            int oldParisRow = parisRow;
            int oldParisCol = parisCol;
            if (command.equals("up")) {
                parisRow--;
            } else if (command.equals("down")) {
                parisRow++;
            } else if (command.equals("left")) {
                parisCol--;
            } else if (command.equals("right")) {
                parisCol++;
            }
            if (parisRow < 0 || parisRow >= matrix.length || parisCol < 0 || parisCol >= sizeCol) {
                energy--;
                parisRow = oldParisRow;
                parisCol = oldParisCol;
                continue;

            }
            if (matrix[parisRow][parisCol] == matrix[spartanRow][spartanCol]) {
                energy -= 3;
                matrix[oldParisRow][oldParisCol] = '-';
                if (energy <= 0) {
                    matrix[oldParisRow][oldParisCol] = 'X';
                    break;
                } else {
                    matrix[parisRow][parisCol] = 'P';
                }
            }
            if (matrix[parisRow][parisCol] == 'H') {
                helenaIsAbducted = true;
                energy--;
                matrix[oldParisRow][oldParisCol] = '-';
                matrix[helenRow][helenCol] = '-';
                break;
            }
            if (matrix[parisRow][parisCol] == '-') {
                matrix[oldParisRow][oldParisCol] = '-';
                matrix[parisRow][parisCol] = 'P';
                energy--;
                if (energy <= 0) {
                    matrix[parisRow][parisCol] = 'X';
                    break;
                }
            }
        }
        if (energy <= 0 || !helenaIsAbducted) {
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
        if (helenaIsAbducted) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < sizeCol; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
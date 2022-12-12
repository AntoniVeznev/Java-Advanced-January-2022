package Exams.JavaAdvancedExam20February2021;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String[] commandArr = scanner.nextLine().split(",");
        char[][] matrix = new char[rows][rows];
        int rowSapper = 0;
        int colSapper = 0;
        int bombCount = 0;
        int defusedBombs = 0;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 's') {
                    rowSapper = row;
                    colSapper = col;
                }
                if (matrix[row][col] == 'B') {
                    bombCount++;
                }
            }
        }
        for (int i = 0; i < commandArr.length; i++) {
            count++;
            String command = commandArr[i];
            int oldRow = rowSapper;
            int oldCol = colSapper;
            if (command.equals("up")) {
                rowSapper--;
            } else if (command.equals("down")) {
                rowSapper++;
            } else if (command.equals("left")) {
                colSapper--;
            } else if (command.equals("right")) {
                colSapper++;
            }
            if (rowSapper < 0 || rowSapper >= rows || colSapper < 0 || colSapper >= rows) {
                rowSapper = oldRow;
                colSapper = oldCol;
                continue;
            }
            if (matrix[rowSapper][colSapper] == '+') {
                matrix[oldRow][oldCol] = '+';

            }
            if (matrix[rowSapper][colSapper] == 'e') {
                matrix[oldRow][oldCol] = '+';
                break;
            }
            if (matrix[rowSapper][colSapper] == 'B') {
                matrix[oldRow][oldCol] = '+';
                matrix[rowSapper][colSapper] = '+';
                defusedBombs++;
                System.out.println("You found a bomb!");
            }
            if (bombCount == defusedBombs) {
                break;
            }
        }

        if (bombCount == defusedBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (matrix[rowSapper][colSapper] == 'e') {
            System.out.printf("END! %d bombs left on the field", bombCount - defusedBombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCount - defusedBombs, rowSapper, colSapper);
        }
    }
}

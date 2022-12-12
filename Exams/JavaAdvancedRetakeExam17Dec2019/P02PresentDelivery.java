package Exams.JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class P02PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfThePresents = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][rows];
        int rowSanta = 0;
        int colSanta = 0;
        int countGoodKids = 0;
        int givenGiftToGoodKids = 0;
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'S') {
                    rowSanta = row;
                    colSanta = col;
                }
                if (matrix[row][col] == 'V') {
                    countGoodKids++;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning") || countOfThePresents == 0) {
            int oldRow = rowSanta;
            int oldCol = colSanta;
            if (command.equals("up")) {
                rowSanta--;
            } else if (command.equals("down")) {
                rowSanta++;
            } else if (command.equals("left")) {
                colSanta--;
            } else if (command.equals("right")) {
                colSanta++;
            }
            if (rowSanta < 0 || colSanta < 0 || rowSanta >= rows || colSanta >= rows) {
                matrix[oldRow][oldCol] = '-';
                System.out.println("Santa ran out of presents!");
                break;
            }
            if (matrix[rowSanta][colSanta] == '-') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowSanta][colSanta] = 'S';
            }
            if (matrix[rowSanta][colSanta] == 'X') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowSanta][colSanta] = 'S';
            }
            if (matrix[rowSanta][colSanta] == 'V') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowSanta][colSanta] = 'S';
                countOfThePresents--;
                givenGiftToGoodKids++;
                if (countOfThePresents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            }
            if (matrix[rowSanta][colSanta] == 'C') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowSanta][colSanta] = 'S';
                for (int row = rowSanta - 1; row <= 3; row++) {
                    for (int col = colSanta - 1; col <= 3; col++) {
                        if (matrix[row][col] == 'X') {
                            matrix[row][col] = '-';
                            countOfThePresents--;
                            if (countOfThePresents == 0) {
                                System.out.println("Santa ran out of presents!");
                                break;
                            }
                        }
                        if (matrix[row][col] == 'V') {
                            matrix[row][col] = '-';
                            countOfThePresents--;
                            givenGiftToGoodKids++;
                            if (countOfThePresents == 0) {
                                System.out.println("Santa ran out of presents!");
                                break;
                            }
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
        if (countGoodKids == givenGiftToGoodKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countGoodKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", countGoodKids - givenGiftToGoodKids);
        }
    }
}
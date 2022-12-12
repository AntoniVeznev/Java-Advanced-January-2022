package Exams.JavaAdvancedExam19February2022;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            String input = scanner.nextLine();
            matrix[row] = input.toCharArray();
        }
        int rowWhite = 0;
        int colWhite = 0;
        int rowBlack = 0;
        int colBlack = 0;
        int oldRowW = 0;
        int oldColW = 0;
        int oldRowB = 0;
        int oldColB = 0;
        boolean whiteWinner = false;
        boolean blackWinner = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == 'w') {
                    rowWhite = row;
                    colWhite = col;
                }
                if (matrix[row][col] == 'b') {
                    rowBlack = row;
                    colBlack = col;
                }
            }
        }
        String symbol1 = "87654321";
        String symbol2 = "abcdefgh";
        String[][] matrix2 = new String[8][8];


        while (true) {
            oldRowW = rowWhite;
            oldColW = colWhite;
            oldRowB = rowBlack;
            oldColB = colBlack;
            rowWhite = rowWhite - 1;
            if (rowWhite < 0) {
                rowWhite = oldRowW;
                colWhite = oldColW;
                whiteWinner = true;
                break;
            }
            matrix[rowWhite][colWhite] = 'w';
            matrix[oldRowW][oldColW] = '-';

            rowBlack = rowBlack + 1;
            if (rowBlack >= matrix.length) {
                rowBlack = oldRowB;
                colBlack = oldColB;
                blackWinner = true;
                break;
            }
            matrix[rowBlack][colBlack] = 'b';
            matrix[oldRowB][oldColB] = '-';
        }
        String whatToPrint = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String s1 = String.valueOf(symbol1.charAt(i));
                String s2 = String.valueOf(symbol2.charAt(j));
                matrix2[i][j] = s2 + s1;

            }
        }

        if (whiteWinner) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", matrix2[rowWhite][colWhite]);
        }
        if (blackWinner) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", matrix2[rowBlack][colBlack]);
        }

    }
}

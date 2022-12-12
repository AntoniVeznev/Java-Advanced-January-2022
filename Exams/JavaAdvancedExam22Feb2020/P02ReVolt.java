package Exams.JavaAdvancedExam22Feb2020;

import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][rows];
        int rowPlayer = 0;
        int colPlayer = 0;
        int counter = 0;
        boolean finish = false;
        for (int row = 0; row < rows; row++) {
            char[] line = scanner.nextLine().toCharArray();
            matrix[row] = line;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'f') {
                    rowPlayer = row;
                    colPlayer = col;
                }
            }
        }
        while (!finish && counter != commands) {
            String command = scanner.nextLine();
            counter++;
            int oldRow = rowPlayer;
            int oldCol = colPlayer;
            if (command.equals("up")) {
                rowPlayer--;
            } else if (command.equals("down")) {
                rowPlayer++;
            } else if (command.equals("left")) {
                colPlayer--;
            } else if (command.equals("right")) {
                colPlayer++;
            }
            if (rowPlayer < 0) {
                matrix[oldRow][oldCol] = '-';
                rowPlayer = rows - 1;
                if (matrix[rowPlayer][colPlayer] == '-') {
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'B') {
                    oldRow = rowPlayer;
                    oldCol = colPlayer;
                    if (command.equals("up")) {
                        rowPlayer--;
                    } else if (command.equals("down")) {
                        rowPlayer++;
                    } else if (command.equals("left")) {
                        colPlayer--;
                    } else if (command.equals("right")) {
                        colPlayer++;
                    }
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'T') {
                    rowPlayer = oldRow;
                    colPlayer = oldCol;
                    matrix[rowPlayer][colPlayer] = 'f';
                } else {
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowPlayer][colPlayer] = 'f';
                    finish = true;
                    break;
                }
            } else if (rowPlayer >= rows) {
                matrix[oldRow][oldCol] = '-';
                rowPlayer = 0;
                if (matrix[rowPlayer][colPlayer] == '-') {
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'B') {
                    oldRow = rowPlayer;
                    oldCol = colPlayer;
                    if (command.equals("up")) {
                        rowPlayer--;
                    } else if (command.equals("down")) {
                        rowPlayer++;
                    } else if (command.equals("left")) {
                        colPlayer--;
                    } else if (command.equals("right")) {
                        colPlayer++;
                    }
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'T') {
                    rowPlayer = oldRow;
                    colPlayer = oldCol;
                    matrix[rowPlayer][colPlayer] = 'f';
                } else {
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowPlayer][colPlayer] = 'f';
                    finish = true;
                    break;
                }
            } else if (colPlayer < 0) {
                matrix[oldRow][oldCol] = '-';
                colPlayer = rows - 1;
                if (matrix[rowPlayer][colPlayer] == '-') {
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'B') {
                    oldRow = rowPlayer;
                    oldCol = colPlayer;
                    if (command.equals("up")) {
                        rowPlayer--;
                    } else if (command.equals("down")) {
                        rowPlayer++;
                    } else if (command.equals("left")) {
                        colPlayer--;
                    } else if (command.equals("right")) {
                        colPlayer++;
                    }
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'T') {
                    rowPlayer = oldRow;
                    colPlayer = oldCol;
                    matrix[rowPlayer][colPlayer] = 'f';
                } else {
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowPlayer][colPlayer] = 'f';
                    finish = true;
                    break;
                }
            } else if (colPlayer >= rows) {
                matrix[oldRow][oldCol] = '-';
                colPlayer = rows - 1;
                if (matrix[rowPlayer][colPlayer] == '-') {
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'B') {
                    oldRow = rowPlayer;
                    oldCol = colPlayer;
                    if (command.equals("up")) {
                        rowPlayer--;
                    } else if (command.equals("down")) {
                        rowPlayer++;
                    } else if (command.equals("left")) {
                        colPlayer--;
                    } else if (command.equals("right")) {
                        colPlayer++;
                    }
                    matrix[rowPlayer][colPlayer] = 'f';
                } else if (matrix[rowPlayer][colPlayer] == 'T') {
                    rowPlayer = oldRow;
                    colPlayer = oldCol;
                    matrix[rowPlayer][colPlayer] = 'f';
                } else {
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowPlayer][colPlayer] = 'f';
                    finish = true;
                    System.out.println("Player won!");
                    break;
                }
            }
            if (matrix[rowPlayer][colPlayer] == '-') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowPlayer][colPlayer] = 'f';
            } else if (matrix[rowPlayer][colPlayer] == 'T') {
                rowPlayer = oldRow;
                colPlayer = oldCol;
                matrix[rowPlayer][colPlayer] = 'f';
            } else if (matrix[rowPlayer][colPlayer] == 'F') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowPlayer][colPlayer] = 'f';
                finish = true;
                break;
            } else if (matrix[rowPlayer][colPlayer] == 'B') {
                matrix[oldRow][oldCol] = '-';
                oldRow = rowPlayer;
                oldCol = colPlayer;
                if (command.equals("up")) {
                    rowPlayer--;
                } else if (command.equals("down")) {
                    rowPlayer++;
                } else if (command.equals("left")) {
                    colPlayer--;
                } else if (command.equals("right")) {
                    colPlayer++;
                }
                if (rowPlayer < 0) {
                    rowPlayer = rows - 1;
                    if (matrix[rowPlayer][colPlayer] == '-') {
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        oldRow = rowPlayer;
                        oldCol = colPlayer;
                        if (command.equals("up")) {
                            rowPlayer--;
                        } else if (command.equals("down")) {
                            rowPlayer++;
                        } else if (command.equals("left")) {
                            colPlayer--;
                        } else if (command.equals("right")) {
                            colPlayer++;
                        }
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {
                        rowPlayer = oldRow;
                        colPlayer = oldCol;
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else {
                        matrix[oldRow][oldCol] = '-';
                        matrix[rowPlayer][colPlayer] = 'f';
                        finish = true;
                        break;
                    }
                } else if (rowPlayer >= rows) {
                    rowPlayer = 0;
                    if (matrix[rowPlayer][colPlayer] == '-') {
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        oldRow = rowPlayer;
                        oldCol = colPlayer;
                        if (command.equals("up")) {
                            rowPlayer--;
                        } else if (command.equals("down")) {
                            rowPlayer++;
                        } else if (command.equals("left")) {
                            colPlayer--;
                        } else if (command.equals("right")) {
                            colPlayer++;
                        }
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {
                        rowPlayer = oldRow;
                        colPlayer = oldCol;
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else {
                        matrix[oldRow][oldCol] = '-';
                        matrix[rowPlayer][colPlayer] = 'f';
                        finish = true;
                        break;
                    }
                } else if (colPlayer < 0) {
                    colPlayer = rows - 1;
                    if (matrix[rowPlayer][colPlayer] == '-') {
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        oldRow = rowPlayer;
                        oldCol = colPlayer;
                        if (command.equals("up")) {
                            rowPlayer--;
                        } else if (command.equals("down")) {
                            rowPlayer++;
                        } else if (command.equals("left")) {
                            colPlayer--;
                        } else if (command.equals("right")) {
                            colPlayer++;
                        }
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {
                        rowPlayer = oldRow;
                        colPlayer = oldCol;
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else {
                        matrix[oldRow][oldCol] = '-';
                        matrix[rowPlayer][colPlayer] = 'f';
                        finish = true;
                        break;
                    }
                } else if (colPlayer >= rows) {
                    colPlayer = rows - 1;
                    if (matrix[rowPlayer][colPlayer] == '-') {
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        oldRow = rowPlayer;
                        oldCol = colPlayer;
                        if (command.equals("up")) {
                            rowPlayer--;
                        } else if (command.equals("down")) {
                            rowPlayer++;
                        } else if (command.equals("left")) {
                            colPlayer--;
                        } else if (command.equals("right")) {
                            colPlayer++;
                        }
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {
                        rowPlayer = oldRow;
                        colPlayer = oldCol;
                        matrix[rowPlayer][colPlayer] = 'f';
                    } else {
                        matrix[oldRow][oldCol] = '-';
                        matrix[rowPlayer][colPlayer] = 'f';
                        finish = true;
                        break;
                    }
                }
            }
        }
        if (counter == commands && !finish) {
            System.out.println("Player lost!");
        } else {
            System.out.println("Player won!");
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
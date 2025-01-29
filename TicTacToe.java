import java.util.Scanner;

public class TicTacToe {
    static char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
    static char currentPlayer = 'X';
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        boolean gameWon = false;

        System.out.println("🎮 Welcome to Tic-Tac-Toe!");
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameWon = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; 
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }

            if (gameWon) break;
        }
        scanner.close();
    }

    static void printBoard() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true; // Row
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true; // Column
        }
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || // Main diagonal
               (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);   // Other diagonal
    }

    static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}


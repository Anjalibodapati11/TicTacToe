import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        System.out.println("🎮 Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            String input = scanner.nextLine();

            if (!makeMove(input)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            printBoard();

            if (checkWin()) {
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (checkDraw()) {
                System.out.println("😐 It's a draw!");
                gameEnded = true;
            } else {
                switchPlayer();
            }
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println();
        for (char[] row : board) {
            System.out.println(" " + row[0] + " | " + row[1] + " | " + row[2]);
            if (row != board[2]) System.out.println("---+---+---");
        }
        System.out.println();
    }

    static boolean makeMove(String input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(board[i][j]).equals(input)) {
                    board[i][j] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean checkWin() {
        // rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        // diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }

    static boolean checkDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (Character.isDigit(cell))
                    return false;
            }
        }
        return true;
    }
}

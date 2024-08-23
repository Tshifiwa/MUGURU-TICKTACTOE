import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] gameBoard = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };

        char currentPlayer = 'X';
        boolean gameIsRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (gameIsRunning) {
            System.out.println(gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
            System.out.println("--+---+--");
            System.out.println(gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
            System.out.println("--+---+--");
            System.out.println(gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);

            int move;
            while (true) {
                System.out.println("Player " + currentPlayer + ", enter your move (choose a number from 1 to 9): ");
                move = scanner.nextInt();

                if (move < 1 || move > 9) {
                    System.out.println("Invalid move. Please enter a number from 1 to 9.");
                    continue;
                }

                int row = (move - 1) / 3;
                int col = (move - 1) % 3;

                if (gameBoard[row][col] != 'X' && gameBoard[row][col] != 'O') {
                    gameBoard[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Invalid move. The position is already taken. Try again.");
                }
            }

            boolean hasWon = false;
            for (int i = 0; i < 3; i++) {
                if ((gameBoard[i][0] == currentPlayer && gameBoard[i][1] == currentPlayer && gameBoard[i][2] == currentPlayer) ||
                    (gameBoard[0][i] == currentPlayer && gameBoard[1][i] == currentPlayer && gameBoard[2][i] == currentPlayer)) {
                    hasWon = true;
                    break;
                }
            }

            if ((gameBoard[0][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][2] == currentPlayer) ||
                (gameBoard[0][2] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][0] == currentPlayer)) {
                hasWon = true;
            }

            if (hasWon) {
                System.out.println(gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
                System.out.println("--+---+--");
                System.out.println(gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
                System.out.println("--+---+--");
                System.out.println(gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
                System.out.println("Congratulations! Player " + currentPlayer + " wins!");
                gameIsRunning = false;
            } else {
                boolean isDraw = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (gameBoard[i][j] != 'X' && gameBoard[i][j] != 'O') {
                            isDraw = false;
                        }
                    }
                }
                if (isDraw) {
                    System.out.println(gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
                    System.out.println("--+---+--");
                    System.out.println(gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
                    System.out.println("--+---+--");
                    System.out.println(gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
                    System.out.println("It's a draw!");
                    gameIsRunning = false;
                }
            }

            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }
    }
}
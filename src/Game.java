import java.util.Scanner;

public class Game {
    private Board board;
    private GameState currentState;
    private Objects currentPlayer;

    private static Scanner in = new Scanner(System.in);  // input Scanner


    public Game() {
        board = new Board();
        initGame();

        do {
            playerMove(currentPlayer);
            board.print();
            updateGame(currentPlayer);
            // Print message if game-over
            if (currentState == GameState.CROSS_WON) {
                System.out.println("'X' won! Bye!");
            } else if (currentState == GameState.CIRCLE_WON) {
                System.out.println("'O' won! Bye!");
            } else if (currentState == GameState.DRAW) {
                System.out.println("It's Draw! Bye!");
            }
            // Switch player
            currentPlayer = (currentPlayer == Objects.CROSS) ? Objects.CIRCLE : Objects.CROSS;
        } while (currentState == GameState.INPLAY);  // repeat until game-over
    }

    public void initGame() {
        board.start();  // clear the board contents
        currentPlayer = Objects.CROSS;       // CROSS plays first
        currentState = GameState.INPLAY; // ready to play
    }


    public void playerMove(Objects theObjects) {
        boolean validInput = false;
        do {
            if (theObjects == Objects.CROSS) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
            }
            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                    && board.cells[row][col].content == Objects.EMPTY) {
                board.cells[row][col].content = theObjects;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true;
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
            }
        } while (!validInput);
    }


    public void updateGame(Objects theSeed) {
        if (board.hasWon(theSeed)) {  // check for win
            currentState = (theSeed == Objects.CROSS) ? GameState.CROSS_WON : GameState.CIRCLE_WON;
        } else if (board.isDraw()) {  // check for draw
            currentState = GameState.DRAW;
        }

    }

    /** The entry main() method */
    public static void main(String[] args) {
        new Game();
    }
}
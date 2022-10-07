public class Board {
    //here we are introducing the rows and columns to the board and using final means that we will always have 3 rows and 3 columns
    public static final int ROWS = 3;
    public static final int COLS = 3;

    Cell[][] cells; //RowsxCells
    int currentRow, currentCol; // this indicates what objects are in the rows and columns

    public Board(){ //Creats the gameboard
        cells = new Cell[ROWS][COLS];
        for(int row = 0; row < ROWS; ++row){
            for(int col = 0; col < COLS; ++col){
                cells[row][col] = new Cell(row, col);
            }
        }
    }
    public void start() { //Creats the content of gameboard
        for(int row = 0; row < ROWS; ++row){
            for(int col = 0; col < COLS; ++col){
                cells[row][col].clear(); //makes cell content empty
            }
        }

    }

    public boolean isDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].content == Objects.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(Objects theObjects) {
        return (cells[currentRow][0].content == theObjects         // 3-in-the-row
                && cells[currentRow][1].content == theObjects
                && cells[currentRow][2].content == theObjects
                || cells[0][currentCol].content == theObjects      // 3-in-the-column
                && cells[1][currentCol].content == theObjects
                && cells[2][currentCol].content == theObjects
                || currentRow == currentCol            // 3-in-the-diagonal
                && cells[0][0].content == theObjects
                && cells[1][1].content == theObjects
                && cells[2][2].content == theObjects
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].content == theObjects
                && cells[1][1].content == theObjects
                && cells[2][0].content == theObjects);
    }


        /** Paint itself */
        public void print() {
            for (int row = 0; row < ROWS; ++row) {
                for (int col = 0; col < COLS; ++col) {
                    cells[row][col].print();   // each cell paints itself
                    if (col < COLS - 1) System.out.print("|");
                }
                System.out.println();
                if (row < ROWS - 1) {
                    System.out.println("-----------");
                }
            }
        }
}
















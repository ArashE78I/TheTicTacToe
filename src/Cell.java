

// this class is for the every cell of the game
public class Cell {
   //
  Objects content; //It takes content from the Objects class
    int row, col; //introducing row and column to the cell class

    public Cell(int row, int col){

        this.row = row;
        this.col = col;
        clear();



    }

    public void clear() { //makes object contents empty(cell become empty)

        content = Objects.EMPTY;
    }
public void print(){

        switch (content){ //show all the case contents
            case CROSS:  System.out.print(" X "); break;
            case CIRCLE: System.out.print(" O "); break;
            case EMPTY:  System.out.print("   "); break;

         }
    }
 }

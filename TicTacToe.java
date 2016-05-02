/**
 * Simulates the 3 by 3 grid game Tic Tac Toe.
 * 
 * @author Matthew Treece
 * @version 1.0
 */
public class TicTacToe
{
    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLS = 3;
    
    /** Construct an empty board.
     */
    public TicTacToe()
    {
        board = new String[ROWS][COLS];
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                board[r][c] = " ";
            }
        }
    }    
    /** @param r the row number
     *  @param c the column number
     *  @param symbol the symbol to be placed on board[r][c]
     *  Precondition: The square board[r][c] is empty.
     *  Postcondition: symbol placed in that square.
     */
    public void makeMove(int r, int c, String symbol)
    {
        if(board[r][c] != " ")
        {
            System.out.println("There is already a value here!");
        }
        else
        {
            board[r][c] = symbol;
        }
    }
    /** @param player X or O
     *  @return whether or not three of the same character are in a row
     */
    public boolean win(String player)
    {
        String result = "";
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                result += board[i][j];
            }
            result += " ";
        }
        if (result.contains(player + player + player)) 
        {
            return true;
        }
        result = "";
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                result += board[j][i];
            }
            result += " ";
        }
        if (result.contains(player + player + player)) 
        {
            return true;
        }
        if (board[0][0] == player)
        {
            if (board[1][1] == player)
            {
                if (board[2][2] == player)
                {
                    return true;
                }
            }
        }
        if (board[0][2] == player)
        {
            if (board[1][1] == player)
            {
                if (board[2][0] == player)
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     *  @return true if all spaces are used
     */
    public boolean tie()
    {
        String result = "";
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                result += board[i][j];
            }
        }
        if (!result.contains(" "))
        {
            return true;
        }
        return false;
    }
    /** Creates a String representation of the board, e.g.
     *    |O    |
     *    |X X  |
     *    |    O|
     * @return the string representation of the board
     */
    public String toString()
    {
        String s = "";      //empty String
        for (int r = 0; r < ROWS; r++)
        {
            s += "|";
            for (int c = 0; c < COLS; c++)
            {
                s += board[r][c];
                if (c != 2)
                {
                    s += " ";
                }
            }
            s += "|\n";
        }
        return s;
    }
}

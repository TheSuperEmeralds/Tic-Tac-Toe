import java.util.Scanner;
/**
 * Play Tic Tac Toe!
 * 
 * @author Matthew Treece 
 * @version 1.0
 * 
 * Current features:
 * Detects users entering a number below 1 and above 9
 * Detects users overriding a space that already has an X or O
 * Displays the tic tac toe board after every turn
 * Checks for 3 in a row vertically, horizontally, and diagonally
 * Ends in a tie if all spaces are filled
 * 
 * Plans for version 1.1:
 * Dectect the user entering a non-number value
 * Play again option
 */
public class PlayTTT
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        boolean inProgress = true, xNotGo = false, oNotGo = false;
        int position;
        System.out.println("Here is how the board is structured: \n"
                            + "|1 2 3|\n|4 5 6|\n|7 8 9|");
        do
        {
            if(oNotGo == false)
            {
                System.out.print("Player X, where would you like to make your move? Position (1-9): ");
                position = scan.nextInt();
                while (position <= 0 || position >= 10)
                {
                    System.out.print("Invalid value! Please enter a valid value: ");
                    position = scan.nextInt();
                }
                int row = 0;
                int col = 0;
                String temp = game.toString();
                for (int i = 1; i <= position; i++)
                {
                    if(i == position)
                    {
                        game.makeMove(row, col, "X");
                        if (temp.equals(game.toString()))
                        {
                            xNotGo = true;
                            break;
                        }
                        if (!temp.equals(game.toString()))
                        {
                            xNotGo = false;
                            break;
                        }
                    }
                    col++;
                    if(col == 3)
                    {
                        row++;
                        col = 0;
                    }
                    if(row == 3)
                    {
                        row = 0;
                    }
                }
                System.out.println(game);
                if (game.win("X"))
                {
                    inProgress = false;
                    System.out.println("X wins!");
                    break;
                }
                if (game.tie())
                {
                    inProgress = false;
                    System.out.println("You tied!");
                    break;
                }
            }
            if (xNotGo == false)
            {
                System.out.print("Player O, where would you like to make your move? Position (1-9): ");
                position = scan.nextInt();
                while (position <= 0 || position >= 10)
                {
                    System.out.print("Invalid value! Please enter a valid value: ");
                    position = scan.nextInt();
                }
                int row = 0;
                int col = 0;
                String temp = game.toString();
                for (int i = 1; i <= position; i++)
                {
                    if(i == position)
                    {
                        game.makeMove(row, col, "O");
                        if (temp.equals(game.toString()))
                        {
                            oNotGo = true;
                            break;
                        }
                        if (!temp.equals(game.toString()))
                        {
                            oNotGo = false;
                            break;
                        }
                    }
                    col++;
                    if(col == 3)
                    {
                        row++;
                        col = 0;
                    }
                }
                System.out.println(game);
                if (game.win("O"))
                {
                    inProgress = false;
                    System.out.println("O wins!");
                    break;
                }
                if (game.tie())
                {
                    inProgress = false;
                    System.out.println("You tied!");
                    break;
                }
            }
        }
        while (inProgress);
    }
} 

import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int numberOfDisks, moves;

        // Welcome text
        System.out.println("This program solves a Tower of Hanoi puzzle.");

        // User input loop
        while (true) {
            // Prompt user for base 10 integer
            System.out.print("Enter a number of pegs (-1 to quit): ");
            numberOfDisks = keyboard.nextInt();

            // Check for exit prompt
            if (numberOfDisks == -1)
                break;

            // Solve puzzle
            System.out.println("Solving puzzle for " + numberOfDisks + " disks starting from Peg A.");
            moves = solveHanoiPuzzle(numberOfDisks, 'A', 'C', 'B', 0);
            System.out.println("Puzzle solved in " + moves + " moves.");

        } // end of user input loop

        keyboard.close();
        System.out.print("Goodbye!");
    }

    public static int solveHanoiPuzzle(int disksToMove, char fromPeg, char toPeg, char intermediatePeg, int moves) {

        // Base case, if disks to move = 0
        if (disksToMove == 0) {
            return moves;
        }
        //
        moves = solveHanoiPuzzle(disksToMove - 1, fromPeg, intermediatePeg, toPeg, moves);
        // Move current fromPeg to toPeg
        System.out.println("Move disc " + disksToMove + " from peg " + fromPeg + " to peg " + toPeg);
        moves++;
        //
        moves = solveHanoiPuzzle(disksToMove - 1, intermediatePeg, toPeg, fromPeg, moves);

        return moves;
    }
}

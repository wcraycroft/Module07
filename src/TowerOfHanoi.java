/* TowerOfHanoi.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Homework 7, Project 3
 * Problem Statement: This program uses a recursive method to solve a Tower of Hanoi puzzle. It also tracks the total
 *      number of moves it takes this program to solve the puzzle.
 *
 * Algorithm / Plan:
 *      1. Prompt user for number of discs
 *      2. Recursively move a number of discs from source (from) peg, to target (to), using an intermediate peg as necessary.
 *          If the number of disks need to move equals zero, return the number of moves
 *          Call method recursively with the same from peg, but swapping the intermediate and to peg. Decrement disks to move by 1.
 *          Print the current move to the user
 *          Call method recursively with the same to peg, but swapping the intermediate and from peg. Decrement disks to move by 1.
 *          Return the number of moves made
 *      3. Print the total number of moves made by the program.
 */

import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int numberOfDisks, moves;

        // Welcome text
        System.out.println("This program solves a Tower of Hanoi puzzle.");

        // User input loop
        while (true) {
            // Prompt user for number of discs
            System.out.print("Enter a number of discs (-1 to quit): ");
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
        // Call method for 1 disc higher. Swap to and intermediate pegs
        moves = solveHanoiPuzzle(disksToMove - 1, fromPeg, intermediatePeg, toPeg, moves);
        // Print the current move to console
        System.out.println("Move disc " + disksToMove + " from peg " + fromPeg + " to peg " + toPeg);
        moves++;
        // Call method for 1 disc higher. Swap intermediate and from pegs
        moves = solveHanoiPuzzle(disksToMove - 1, intermediatePeg, toPeg, fromPeg, moves);
        // Return number of moves made.
        return moves;
    }
}

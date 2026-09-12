package JAVA_beginner_DSA_foundations_prerequisites.step4;

/**
 * Problem Statement:
 * Two players, P1 and P2, play a game with an array of integers. Initially, the array is not reversed.
 * - On each turn, players alternate picking a number from either the start or end of the array.
 * - The selection always happens from the "current order":
 *     - If NOT reversed: Take from the start.
 *     - If reversed:     Take from the end.
 * - If the number picked is EVEN, the game reverses the array's orientation (that is, next pick is from the other end).
 * - P1 always goes first. Each player adds the picked numbers to their respective scores.
 * The game stops when all numbers have been picked.
 * At the end, print the two players' scores.
 * 
 * Hardcoded sample test cases included in main().
 */

public class MatchPlayerMicrosoftOA {
    
    // Implements the described scoring and picks for both players.
    public static void solver(int[] b) {
        int p1score = 0;
        int p2score = 0;
        int start = 0;
        int end = b.length - 1;
        boolean reverse = false; // false = original order (pick from start), true = reversed (pick from end)
        int turn = 1; // odd: P1, even: P2

        // Since both players have to pick all elements, loop until no elements are left
        while (start <= end) {
            int selected; // The value picked in this turn

            if (turn % 2 != 0) {
                // P1's turn
                if (!reverse) {
                    p1score += b[start];
                    selected = b[start];
                    start++;
                } else {
                    p1score += b[end];
                    selected = b[end];
                    end--;
                }
            } else {
                // P2's turn
                if (!reverse) {
                    p2score += b[start];
                    selected = b[start];
                    start++;
                } else {
                    p2score += b[end];
                    selected = b[end];
                    end--;
                }
            }
            // Reverse the picking order if the selected number is EVEN
            if (selected % 2 == 0) {
                reverse = !reverse;
            }
            turn++;
        }
        System.out.println("Player 1 score: " + p1score + " --- Player 2 score: " + p2score);
    }

    public static void main(String[] args) {
        // Hardcoded test cases
        int[][] testCases = {
            {1, 3, 5, 7, 9},          // all odds, so reverse never flips
            {2, 4, 6, 8, 10},         // all evens, so always reverse after every pick
            {2, 1, 4, 3, 6, 5},       // mix of evens and odds, checking reverse flips
            {2, 7, 4, 9, 6, 8, 3},    // longer, varied
            {42},                     // single element, edge case
            {3, 2, 1}                 // minimal array with reverse effects
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + " input: ");
            for (int v : testCases[i]) System.out.print(v + " ");
            System.out.println();
            solver(testCases[i]);
            System.out.println("-----------");
        }
    }
}

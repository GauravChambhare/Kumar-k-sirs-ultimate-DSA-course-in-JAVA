package JAVA_beginner_DSA_foundations_prerequisites.step4;

public class Session21MaximumNoOfSubsequencesAfterInsertingOne {

    /**
     * Returns the maximum number of "L-C-T" subsequences after inserting exactly one character ('L', 'C', or 'T')
     * in the input string at any position.
     */
    public static long numOfSubsequences(String s) {
        int len = s.length();

        // 1. Build Prefix L and Suffix T arrays
        long[] prefixArL = new long[len];
        long[] suffixArT = new long[len];

        prefixArL[0] = (s.charAt(0) == 'L') ? 1 : 0;
        for (int i = 1; i < len; i++) {
            prefixArL[i] = prefixArL[i - 1] + (s.charAt(i) == 'L' ? 1 : 0);
        }

        suffixArT[len - 1] = (s.charAt(len - 1) == 'T') ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            suffixArT[i] = suffixArT[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
        }

        // 2. Calculate original LCT count & helper counts for inserting L or T
        long originalLCT = 0;
        long totalCT = 0;
        long totalLC = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'C') {
                long L_on_left = (i > 0) ? prefixArL[i - 1] : 0;
                long T_on_right = (i < len - 1) ? suffixArT[i + 1] : 0;

                originalLCT += L_on_left * T_on_right;
                totalCT += T_on_right; // For inserting 'L' at the start
                totalLC += L_on_left;  // For inserting 'T' at the end
            }
        }

        // 3. Find the best spot to insert 'C'
        long insertCCombinations = 0;
        for (int i = 0; i <= len; i++) {
            // For each possible insertion of 'C' at position i (between i-1 and i)
            // Calculate L's to the left, T's to the right
            long L_on_left = (i > 0) ? prefixArL[i - 1] : 0;
            long T_on_right = (i < len) ? ((len > 0) ? suffixArT[i] : 0) : 0;
            insertCCombinations = Math.max(insertCCombinations, L_on_left * T_on_right);
        }

        // 4. Get the max extra combinations we can get from any insertion
        long maxExtra = Math.max(totalCT, Math.max(totalLC, insertCCombinations));

        return originalLCT + maxExtra;
    }

    // Main method for local testing
    public static void main(String[] args) {
        String[] testCases = {
            "LCT",      // simple case, 1 original LCT, expect more after insertion
            "LLCCTT",   // multiple L, C, T
            "CCC",      // Only C's, expect zero originally
            "LTT",      // No C, so original zero
            "CLCT",     // Some LCT subsequences
            "",         // Empty string
            "LCLCLCTT", // Mix of all
            "LLTT",     // No C, but after inserting C...
        };
        for (String tc : testCases) {
            System.out.println("For input: \"" + tc + "\", max subsequences after one insertion: " + numOfSubsequences(tc));
        }
    }
}

package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

// Que: Given an array "nums" of size "N" - find the total number of pairs (i, j) [i < j]
// such that (nums[i] + nums[j]) % 5 == 0 (nums[i] >= 0 for all i).
public class Session6 {

    public static int totalPairs(int[] nums) {
        // TODO: implement using remainder frequency map (mod 5)
        Map<Integer, Integer> freqmap = new HashMap<>();
        int ans = 0;

        return ans;
    }

    // main method to run locally
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 0};
        System.out.println("Total pairs with (sum % 5 == 0): " + totalPairs(nums));
    }
}

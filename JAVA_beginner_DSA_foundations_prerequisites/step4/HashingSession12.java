package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Find count of largest/smallest subarrays with sum k in a given array
public class HashingSession12{

    // Returns {countOfSmallestLenSubarrays, countOfLargestLenSubarrays}
    // among all subarrays whose sum equals k.
    static int[] countLargestSmallest(int[] arr, int k) {
        // TODO: implement using prefix sum + hashing

        // declaring variables
        int maxLength = Integer.MIN_VALUE, minLength = Integer.MAX_VALUE, currentPrefixSum=0, countMin=0, countMax=0;

        // declaring hashmap and initializing it with 0 list[-1]

        Map<Integer, List<Integer>> prefixSuMap = new HashMap<>();
        prefixSuMap.put(0, new ArrayList<>(Arrays.asList(-1))); //putIfAbsent): Checks if currentSum exists as a key in prefixMap.
        //  If it does not, it creates a new entry:

        for(int i=0; i<arr.length; i++){
            currentPrefixSum +=arr[i];
            int targetPrefixSum = currentPrefixSum - k ;
            if(prefixSuMap.containsKey(targetPrefixSum)){
                // this means that already we have encountered an subarry where subarray sum is equal to k
                List<Integer> indexes = prefixSuMap.get(targetPrefixSum);
                for(int index : indexes){
                    int L = i - index ; // length of subarry ending at index index
                    if(L>maxLength){ maxLength = L; countMax=1; }
                    else if(L==maxLength){ countMax++; }

                    if(L<minLength){ minLength=L; countMin=1; }
                    else if(L==minLength){ countMin++; }
                }
            }
            prefixSuMap.putIfAbsent(currentPrefixSum, new ArrayList<>());
            prefixSuMap.get(currentPrefixSum).add(i);
        }
        if (minLength == Integer.MAX_VALUE) {
            return new int[] {0, 0}; // Explicitly state that 0 valid subarrays were found
        }
        return new int[]{countMin, countMax};
        
    }
    /*
     * WALKTHORUGH FOR EDGE CASE
     * Here is the step-by-step dry run of your implementation using `arr = [1, 2, -4, 5, 3]` and `k = 3`.

        ---

        ### Initial Setup

        Before starting the loop:

        * `currentPrefixSum = 0`
        * `minLength = Integer.MAX_VALUE` $(\infty)$, `countMin = 0`
        * `maxLength = Integer.MIN_VALUE` $(-\infty)$, `countMax = 0`
        * `prefixSuMap = { 0 -> [-1] }`

        ---

        ### Execution Steps

        #### **Index 0: `arr[0] = 1**`

        1. **Update sum:** `currentPrefixSum = 0 + 1 = 1`
        2. **Target sum:** `targetPrefixSum = 1 - 3 = -2`
        3. **Lookup `-2` in map:** Not found.
        4. **Update Map:** Add index `0` for key `1`.
        * `prefixSuMap = { 0 -> [-1], 1 -> [0] }`

        ---

        #### **Index 1: `arr[1] = 2**`

        1. **Update sum:** `currentPrefixSum = 1 + 2 = 3`
        2. **Target sum:** `targetPrefixSum = 3 - 3 = 0`
        3. **Lookup `0` in map:** Found! `indexes = [-1]`
        * **Process index `-1`:**
        * Length $L = 1 - (-1) = 2$
        * **Max length update:** $2 > -\infty \implies \text{maxLength} = 2, \text{countMax} = 1$
        * **Min length update:** $2 < \infty \implies \text{minLength} = 2, \text{countMin} = 1$
        * *Subarray found:* `[1, 2]` (indices 0 to 1)

        4. **Update Map:** Add index `1` for key `3`.
        * `prefixSuMap = { 0 -> [-1], 1 -> [0], 3 -> [1] }`

        ---

        #### **Index 2: `arr[2] = -4**`

        1. **Update sum:** `currentPrefixSum = 3 + (-4) = -1`
        2. **Target sum:** `targetPrefixSum = -1 - 3 = -4`
        3. **Lookup `-4` in map:** Not found.
        4. **Update Map:** Add index `2` for key `-1`.
        * `prefixSuMap = { 0 -> [-1], 1 -> [0], 3 -> [1], -1 -> [2] }`

        ---

        #### **Index 3: `arr[3] = 5**`

        1. **Update sum:** `currentPrefixSum = -1 + 5 = 4`
        2. **Target sum:** `targetPrefixSum = 4 - 3 = 1`
        3. **Lookup `1` in map:** Found! `indexes = [0]`
        * **Process index `0`:**
        * Length $L = 3 - 0 = 3$
        * **Max length update:** $3 > 2 \implies \text{maxLength} = 3, \text{countMax} = 1$
        * **Min length update:** $3 > 2$ (no change to `minLength` or `countMin`)
        * *Subarray found:* `[2, -4, 5]` (indices 1 to 3)

        4. **Update Map:** Add index `3` for key `4`.
        * `prefixSuMap = { 0 -> [-1], 1 -> [0], 3 -> [1], -1 -> [2], 4 -> [3] }`

        ---

        #### **Index 4: `arr[4] = 3**`

        1. **Update sum:** `currentPrefixSum = 4 + 3 = 7`
        2. **Target sum:** `targetPrefixSum = 7 - 3 = 4`
        3. **Lookup `4` in map:** Found! `indexes = [3]`
        * **Process index `3`:**
        * Length $L = 4 - 3 = 1$
        * **Max length update:** $1 < 3$ (no change)
        * **Min length update:** $1 < 2 \implies \text{minLength} = 1, \text{countMin} = 1$
        * *Subarray found:* `[3]` (index 4)

        4. **Update Map:** Add index `4` for key `7`.
        * `prefixSuMap = { 0 -> [-1], 1 -> [0], 3 -> [1], -1 -> [2], 4 -> [3], 7 -> [4] }`

        ---

        ### Final Summary

        | Subarray      | Indices | Length | Target Sum Achieved? |
        | ------------- | ------- | ------ | -------------------- |
        | `[1, 2]`      | 0 to 1  | **2**  | Yes ($1 + 2 = 3$)    |
        | `[2, -4, 5]`  | 1 to 3  | **3**  | Yes ($2 - 4 + 5 = 3$)|
        | `[3]`         | 4 to 4  | **1**  | Yes ($3 = 3$)        |

        * **Smallest Length:** `1` (count = `1`)
        * **Largest Length:** `3` (count = `1`)
        * **Final Output:** `{1, 1}`
    */

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, -4, 5, 3, -2, 4, -1, 3};
        int k = 15;
        int[] ans = countLargestSmallest(arr, k);
        System.out.println(
            "For subarrays with sum == " + k
            + ", count of smallest-length = " + ans[0]  // [3] , [3]
            + " & count of largest-length = " + ans[1]  // [2, -4, 5]
        );
    }
}

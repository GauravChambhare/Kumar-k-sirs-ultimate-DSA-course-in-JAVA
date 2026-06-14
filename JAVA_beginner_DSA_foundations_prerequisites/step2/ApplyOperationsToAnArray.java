import java.util.Arrays;

public class ApplyOperationsToAnArray {
    
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int size = nums.length;
        
        // First pass: apply operations on adjacent equal elements
        for(int i = 0; i < size - 1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        
        // Second pass: shift all non-zero elements to the front
        int idx = 0;
        for(int i = 0; i < size; i++) {
            if(nums[i] != 0) {
                ans[idx] = nums[i];
                idx += 1;
            }
        }
        
        return ans;
    }
    
    // Main method to test the solution locally
    public static void main(String[] args) {
        ApplyOperationsToAnArray solution = new ApplyOperationsToAnArray();
        
        // Test case 1
        int[] nums1 = {1, 2, 2, 1, 1, 0};
        int[] result1 = solution.applyOperations(nums1);
        System.out.println("Test 1: " + Arrays.toString(result1));
        // Expected: [1, 4, 2, 0, 0, 0]
        
        // Test case 2
        int[] nums2 = {0, 1};
        int[] result2 = solution.applyOperations(nums2);
        System.out.println("Test 2: " + Arrays.toString(result2));
        // Expected: [1, 0]
        
        // Test case 3
        int[] nums3 = {2, 2, 2, 2};
        int[] result3 = solution.applyOperations(nums3);
        System.out.println("Test 3: " + Arrays.toString(result3));
        // Expected: [4, 4, 0, 0]
    }
}
public class LargestSubarryWithSubarraySumLessThanEqualToK {
    
    public static int bruteForce(int[] arr, int k){
        // this is brute force solution
        int n= arr.length;
        int globalMax = 0;
        for(int i=0; i<n; i++){
            int sum=0; //current sum from [i, ... ,j]
            for(int j=i; j<n; j++){
                sum  = sum + arr[j];
                if(sum<=k){
                    int len = (j-i+1);
                    globalMax = Math.max(len, globalMax);
                }
            }
        }
        return globalMax;
    }

    public static int optimizedApproach(int[] arr, int k){
        int globalMax = 0;
        int n = arr.length;
        int sum = 0;
        for(int i=0, j=0; j<n; j++){
            sum += arr[j];

            while(sum>k && i<=j){ // necessary to add i<=j to ensure i doesnt move past j
                sum -= arr[i];
                i++;
            }
            int len = j - i + 1;
            globalMax = Math.max(globalMax, len);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 8;
        System.out.println("Test case 1: arr = [1,2,3,4,5], k = 8");
        System.out.println("Largest subarray length (bruteForce): " + bruteForce(arr1, k1));
        System.out.println("Largest subarray length (optimized): " + optimizedApproach(arr1, k1));

        // Test case 2
        int[] arr2 = {2, 1, 1, 2, 1};
        int k2 = 4;
        System.out.println("Test case 2: arr = [2,1,1,2,1], k = 4");
        System.out.println("Largest subarray length (bruteForce): " + bruteForce(arr2, k2));
        System.out.println("Largest subarray length (optimized): " + optimizedApproach(arr2, k2));

        // Test case 3
        int[] arr3 = {5, 1, 3, 2, 6};
        int k3 = 7;
        System.out.println("Test case 3: arr = [5,1,3,2,6], k = 7");
        System.out.println("Largest subarray length (bruteForce): " + bruteForce(arr3, k3));
        System.out.println("Largest subarray length (optimized): " + optimizedApproach(arr3, k3));
    }
}

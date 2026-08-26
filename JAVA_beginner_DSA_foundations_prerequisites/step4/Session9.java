package JAVA_beginner_DSA_foundations_prerequisites.step4;
/*
 *  Find Sum of Range  [l……….r] where(l<=r) using Prefix sum. 
*/

public class Session9 {
    public static long bruteForce(int[] arr, int l, int r){
        long ans = 0;
        // we will use two pointers initialized them at l and r index positions
        for(int i=l; i<=r; i++){
            ans +=arr[i];
        }
        return ans;
    }
    public static long optimizedApproach(int[] arr, int[] prefixSum, int l, int r){
        long ans = 0;
        // We are handling the case when l==0, as else; below it will check for prefixSum[-1] which will show ArrayIndexOutOfBound expection
        ans = l==0 ? prefixSum[l] : prefixSum[r] - prefixSum[l-1];
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 8, 1, 6, 3};
        int[][] queries = new int[][]{{1, 3}, {0, 1}, {5, 6}}; //declaring a queries arry where each element is l, r pair
        //no of queries 
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            // we are setting up our prefixSum array
            prefixSum[i] = prefixSum[i-1] + arr[i];

        }
        int q = queries.length;
        for(int i=0; i<q; i++){
            System.out.println("brute force approach ans for "+"l="+queries[i][0]+", "+"r="+queries[i][1]+" is = "+ bruteForce(arr, queries[i][0], queries[i][1]));
            System.out.println("Optimised approach ans for "+"l="+queries[i][0]+", "+"r="+queries[i][1]+" is = "+ optimizedApproach(arr, prefixSum, queries[i][0], queries[i][1]));
        }
    }
}

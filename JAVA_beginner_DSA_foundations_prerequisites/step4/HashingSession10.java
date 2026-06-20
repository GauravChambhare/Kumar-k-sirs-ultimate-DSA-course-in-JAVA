package JAVA_beginner_DSA_foundations_prerequisites.step4;

public class HashingSession10 {

    public static int noOfSubarraysBruteForce(int arr[], int k){

        int ans=0;
        if(arr.length==1){
            int ans1 = arr[0]==k ? 1 : 0;
            return ans1;
        }
        // we will initialize r from 1  
        for(int r=0; r<arr.length; r++){
            int sum=0;
            for(int l=r; l>=0; l--){
                sum+=arr[l];
                if(sum==k) ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2, 4, 5, 8, 1, 6, 3};
        int k = 10; // i.e count no of subarrays whose sum of elements = 10

        System.out.println(noOfSubarraysBruteForce(arr, k));
        return;
    }
}

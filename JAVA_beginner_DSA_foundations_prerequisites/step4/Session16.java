package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.Arrays;  

public class Session16 {
    

    // Approach 1 brute force

    int findFrequency1(int arr[], int x) {

        // brute force approach
        int ans = 0;
        for(int val : arr){
            if(val==x) ans+=1;
        }
        return ans;
    }

    // Approach 2 inbuilt functions usage

    int findFrequency2(int arr[], int x) {
        // using inbuilt functions approach        
        int ans = (int) Arrays.stream(arr).filter(num -> num == x).count();
        return ans;
    }


    public static void main(String[] args) {
        Session16 s16 = new Session16();
        int[] arr = {1, 2, 2, 3, 4, 2, 5};
        int x = 2;
        System.out.println("Brute force freq of " + x + ": " + s16.findFrequency1(arr, x));
        System.out.println("Inbuilt freq of " + x + ": " + s16.findFrequency2(arr, x));
    }
}

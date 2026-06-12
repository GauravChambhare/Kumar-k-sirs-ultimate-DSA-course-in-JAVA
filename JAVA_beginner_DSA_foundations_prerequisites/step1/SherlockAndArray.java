import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndArray {
    
    final static void checker(int[] arr, int n) {
        // Edge case: Single element always satisfies condition (left=0, right=0)
        if (n == 1) {
            System.out.println("YES");
            return;
        }
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // Must exclude arr[i] from rightSum (it's the element between left and right)
            int rightSum = totalSum - leftSum - arr[i];
            
            if (leftSum == rightSum) {
                System.out.println("YES");
                return;
            }
            leftSum += arr[i];
        }
        System.out.println("NO");
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // number of test cases
        while (t-- > 0) {
            int size = in.nextInt();
            int[] testcase = new int[size];
            for (int i = 0; i < size; i++) {
                testcase[i] = in.nextInt();
            }
            checker(testcase, size);
        }    
    }
}
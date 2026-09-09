package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.io.*;
import java.util.StringTokenizer;

public class CountOfSubarraysHavingSumLessThanEqualToK {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        long k = Long.parseLong(br.readLine().trim());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // --- CANONICAL TWO-POINTER TEMPLATE BEGINS ---
        long count = 0;
        long windowState = 0; // Tracks sum, frequency, or custom invariant

        for (int i = 0, j = 0; j < n; j++) {
            // 1. Expand: Include arr[j] in the current window state
            windowState += arr[j];

            // 2. Shrink: Restore validity by advancing left pointer i
            while (windowState > k && i <= j) {
                windowState -= arr[i];
                i++;
            }

            // 3. Aggregate: Accumulate all valid subarrays ending at right pointer j
            count += (j - i + 1);
        }
        // --- CANONICAL TWO-POINTER TEMPLATE ENDS ---

        System.out.println(count);
    }
    /*
    Example : 
    6
    4
    1 1 2 4 2 3
    Output :
    9
    */
}

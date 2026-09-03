package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solves the Range Sum Queries problem:
 * Given an array A of size n, perform q queries.
 * Each query provides indices l and r (0-based), and asks for sum of A[l]...A[r].
 * Uses efficient input reading.
 */
public class Session16part1que3RangeSumQueries {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read array size
        System.out.print("Enter array size n: ");
        String line = br.readLine();
        if(line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        // Read array elements
        System.out.println("Enter n array elements separated by space:");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Compute prefix sum array
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        // Read number of queries
        System.out.print("Enter number of queries: ");
        String line2 = br.readLine();
        if(line2 == null || line2.trim().isEmpty()) return;
        int q = Integer.parseInt(line2.trim());

        System.out.println("Enter " + q + " queries (start and end indices, space separated):");
        for(int k = 0; k < q; k++){
            String queryLine = br.readLine();
            if(queryLine == null || queryLine.trim().isEmpty()) {
                continue;
            }
            StringTokenizer s = new StringTokenizer(queryLine);
            int start = Integer.parseInt(s.nextToken());
            int end = Integer.parseInt(s.nextToken());

            int rangeSum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];
            System.out.println("Sum of arr[" + start + "] to arr[" + end + "] = " + rangeSum);
        }
    }
}

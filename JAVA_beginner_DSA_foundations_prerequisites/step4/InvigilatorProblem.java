package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.io.*;
import java.util.*;
/*
Invigilator Problem

Problem Description:
There are N students. Each student has an exam which starts at time 'start' and ends at time 'end' (both inclusive).
If at least K students are giving an exam at a certain time, an invigilator is required at that time. 
You have M queries, each consisting of an interval [L, R]. For each query, determine for how many units of time 
between L and R (inclusive) is an invigilator required.

Input Format:
First line: N K
Next N lines: start end (for each student)
Next line: M (number of queries)
Next M lines: L R (for each query)

Output:
For each query, output the number of units of time in [L, R] where an invigilator is required.

*/
/*
test case

5 2
1 2
3 6
2 4
4 5
1 4
2
2 5
3 4
*/


public class InvigilatorProblem {
    // The maximum possible time value based on the problem statement constraints (10^6)
    private static final int MAX_TIME = 1000000;

    public static void main(String[] args) throws IOException {
        runInvigilatorProblem();
    }
    
    public static void runInvigilatorProblem() throws IOException {
        // Using BufferedReader for fast I/O processing
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read N (number of students) and K (threshold)
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Array to implement the Range Update Trick (+2 for boundary safety)
        int[] diff = new int[MAX_TIME + 2];

        // Process each student's exam interval [start, end]
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // Apply Range Update Trick
            diff[start] += 1;
            diff[end + 1] -= 1;
        }

        // Reconstruct the frequency timeline array (Array A) and 
        // simultaneously filter into a binary filter array (Array B)
        int[] b = new int[MAX_TIME + 2];
        int currentStudents = 0;

        for (int i = 0; i <= MAX_TIME; i++) {
            currentStudents += diff[i]; // Reconstructed value of A[i]
            // If active students match or exceed threshold K, mark as 1, else 0
            b[i] = (currentStudents >= k) ? 1 : 0;
        }

        // Build the Prefix Sum array directly on top of Array B to optimize space
        for (int i = 1; i <= MAX_TIME; i++) {
            b[i] = b[i] + b[i - 1];
        }

        // Read the total number of evaluation queries (M)
        int m = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();
        System.out.println();
        System.out.println("-----------------------");
        // Process each interval query [L, R] in O(1) constant time
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // Compute total time invigilator is required using Prefix Sum logic
            int answer;
            if (l == 0) {
                answer = b[r];
            } else {
                answer = b[r] - b[l - 1];
            }
            
            output.append(answer).append("\n");
        }

        // Print out all query answers efficiently
        System.out.print(output);
    }
}
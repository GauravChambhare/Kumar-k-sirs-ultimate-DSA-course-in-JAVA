package JAVA_beginner_DSA_foundations_prerequisites.step4;

public class PrintSquareRootOfXWithoutInbuiltfunctions {
    // Print square root of number X without using any inbuilt function. [Binary search over real number]
    // Time Complexity: O(log(R/epsilon)), Space Complexity: O(1)
    public static double solver(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Negative numbers not supported.");
        }
        if (x == 0 || x == 1) return x;

        double l = 0.0, r = (double) x;
        double epsilon = 1e-7; // Sufficient for most local machines and outputs good precision for double

        // If x < 1, the square root is greater than x but less than 1
        if (x < 1) r = 1.0;

        double sqrt = 0.0;
        while (r - l > epsilon) { // loop until the interval is within epsilon
            sqrt = l + (r - l) / 2.0;
            double sq = sqrt * sqrt;
            if (sq > x) r = sqrt;
            else l = sqrt;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] testValues = {0, 1, 2, 4, 9, 16, 123, 99999999};
        for (int x : testValues) {
            System.out.printf("sqrt(%d) ≈ %.8f (actual: %.8f)\n", x, solver(x), Math.sqrt(x));
        }
    }
}

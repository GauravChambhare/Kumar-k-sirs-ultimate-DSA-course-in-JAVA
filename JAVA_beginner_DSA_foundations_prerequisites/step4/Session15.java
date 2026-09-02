package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Session15 {

    /**
     * Given an array a[] representing heights of "piles", count the minimum number of steps
     * needed to make all piles the same height by performing the following operation any number of times:
     * In one operation, choose the current highest height group and decrease all those piles by 1,
     * then repeat until all piles are equal.
     */
    public static long countSteps(int[] a) {
        int n = a.length;
        if (n < 2) return 0L;
        long countOfSteps = 0L;

        // Use reverse sorted treemap (highest first)
        Map<Integer, Integer> mp = new TreeMap<>(Collections.reverseOrder());

        // Populate the map: key=height, value=frequency
        for (int val : a) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        // Flatten map to a list of entries, preserving descending order of heights
        List<Entry<Integer, Integer>> g = new ArrayList<>(mp.entrySet());
        int size = g.size();

        // For every distinct height (except the smallest one)
        for (int i = 0; i < size - 1; i++) {
            // Combine the current height frequency into the next-lower height frequency
            g.get(i + 1).setValue(g.get(i + 1).getValue() + g.get(i).getValue());
            // Add the count of piles at this (higher) height to steps
            countOfSteps += g.get(i).getValue();
            // (optional: set current to zero for clarity)
            g.get(i).setValue(0);
        }
        return countOfSteps;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1};
        long steps = countSteps(arr);
        System.out.println("Count of steps: " + steps); // Output should be 3 (steps: 5->2: 1, 2->1: 2, total=3)
    }
}

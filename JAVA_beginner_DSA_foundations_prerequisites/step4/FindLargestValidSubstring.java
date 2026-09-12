package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.*;

/**
 * FindLargestValidSubstring - Finds the length of the largest substring such that the
 * difference between the indices (in the alphabet) of the maximum and minimum characters
 * is at most k.
 *
 * Contains:
 *    - Approach 1: Frequency array + scan for min/max (O(26n) time, O(1) space)
 *    - Approach 2: TreeMultiSet window for online min/max (O(n log 26) = O(n) time, O(26) = O(1) space)
 */
public class FindLargestValidSubstring {

    /**
     * Approach 1: Frequency Array + Scan for min/max.
     *
     * Time Complexity: O(26 * n) [For every window move, scanner for min/max does work proportional to alphabet size.]
     * Space Complexity: O(26) = O(1) [Only for frequency array]
     */
    public static int findLargestValidSubstringApproach1(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            while (true) {
                int min = -1;
                int max = -1;

                for (int i = 0; i < 26; i++) {
                    if (freq[i] > 0) {
                        if (min == -1) min = i;
                        max = i;
                    }
                }

                if (max - min <= k) {
                    break;
                }

                freq[s.charAt(left) - 'a']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }

    /**
     * Approach 2: Custom TreeMultiSet to maintain window min/max in O(1).
     *
     * Time Complexity: O(n log 26) = O(n) [add/remove from TreeMap of size <=26]
     * Space Complexity: O(26) = O(1)
     */
    public static int findLargestValidSubstringApproach2(String s, int k) {
        int n = s.length();
        TreeMultiSet<Character> multiset = new TreeMultiSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            multiset.add(s.charAt(right));

            while (multiset.last() - multiset.first() > k) {
                multiset.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // TreeMultiSet implementation using TreeMap
    static class TreeMultiSet<T extends Comparable<T>> {
        private final TreeMap<T, Integer> map;

        public TreeMultiSet() {
            map = new TreeMap<>();
        }

        public void add(T t) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        public void remove(T t) {
            if (map.containsKey(t)) {
                int count = map.get(t);
                if (count > 1) {
                    map.put(t, count - 1);
                } else {
                    map.remove(t);
                }
            }
        }

        public T first() {
            return map.firstKey();
        }

        public T last() {
            return map.lastKey();
        }
    }

    public static void main(String[] args) {
        // You can run this file on a local machine
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string and k (for custom test), or leave blank to run sample hardcoded tests.");
        String inputLine = sc.nextLine().trim();
        if (inputLine.isEmpty()) {
            // Hardcoded test cases for both approaches
            String[] testStrings = {"abcde", "aabbcc", "abacabadabacaba", "xyzxyzyz"};
            int[] testKs = {2, 1, 0, 3};
            for (int testNum = 0; testNum < testStrings.length; testNum++) {
                String s = testStrings[testNum];
                int k = testKs[testNum];
                System.out.printf("Test case %d: s = '%s', k = %d%n", testNum + 1, s, k);
                System.out.println("  Approach 1 answer: " + findLargestValidSubstringApproach1(s, k));
                System.out.println("  Approach 2 answer: " + findLargestValidSubstringApproach2(s, k));
            }
        } else {
            // Custom user input
            String s;
            int k;
            String[] parts = inputLine.split("\\s+");
            if (parts.length == 2) {
                s = parts[0];
                k = Integer.parseInt(parts[1]);
            } else {
                s = inputLine;
                System.out.print("Enter k: ");
                k = sc.nextInt();
            }
            System.out.println("Approach 1 result: " + findLargestValidSubstringApproach1(s, k));
            System.out.println("Approach 2 result: " + findLargestValidSubstringApproach2(s, k));
        }

        sc.close();
    }
}

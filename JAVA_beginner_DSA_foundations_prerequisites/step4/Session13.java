package JAVA_beginner_DSA_foundations_prerequisites.step4;

// VALID ANAGRAMS
public class Session13 {

    // Check if two strings are anagrams using a frequency array
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        // frequency array for lowercase alphabets ('a' to 'z')
        // unicode value of 'a' = 97
        int[] freqarr = new int[26];
        for (char c : s.toCharArray()) {
            freqarr[c - 97] += 1;
        }
        for (char c : t.toCharArray()) {
            freqarr[c - 97] -= 1;
            if (freqarr[c - 97] < 0) return false;
        }
        return true;
    }

    // main method to run locally
    public static void main(String[] args) {
        String s1 = "listen";
        String t1 = "silent";
        String s2 = "hello";
        String t2 = "world";

        System.out.println(s1 + " and " + t1 + " are anagrams: " + isAnagram(s1, t1)); // true
        System.out.println(s2 + " and " + t2 + " are anagrams: " + isAnagram(s2, t2)); // false
    }
}

package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;

public class HashingPart3 {
    public static void main(String[] args) {
        // we are declaring our array as below
        int[] arr = new int[]{2,3,3,5,2,5,5,5,5, 10^9};
        // since we know that max value in our input arr is very large
        // it doesnt make any sense to create a hashtable/freqArr of that big of size.
        // this is where apan HashMap ko use karte hai to keep space complexity O(arr.size)
        Map<Integer, Integer> freqmap = new HashMap<>();
        for(int i : arr){
            freqmap.put(i, freqmap.getOrDefault(i, 0)+1);
        }
        int queryvalue = 5;
        System.out.println("Frequency if "+ queryvalue+" is "+ freqmap.getOrDefault(queryvalue, 0));
        int queryvalue2 = 10^7; // here ye yad rakhna ki java me ^ operand Bitwise XOR operation karta ha
        // naki exponent ka jo math me hota hai. Agar java me exponention num represent karna hai to
        //Math.pow(10, 7) aisa karna padega
        System.out.println("Frequency if "+ queryvalue2+" is "+ freqmap.getOrDefault(queryvalue2, 0));
        return;
    }
}

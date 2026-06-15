package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;
import java.io.*;

public class HashingExample {
    
    public static void main(String[] args) {
        // declare an int array of custom size n and take its input from user
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // now we will use both methods of HashMap and freqArr for demo purposes
        // lets say we know for suzre that max value user will input for arr will be 10
        int[] freqArr = new int[11];

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<n; i++){
            freqArr[arr[i]] = freqArr[arr[i]]+1;
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        // Now we will take input query q from user to return the frequency of that element
        int qVal = sc.nextInt();
        System.out.println("Frequency of "+qVal +" in freqArr is "+ freqArr[qVal]);
        System.out.println("Frequency of "+qVal +" in freqMap is "+ freqMap.getOrDefault(qVal, 0));
    }
}

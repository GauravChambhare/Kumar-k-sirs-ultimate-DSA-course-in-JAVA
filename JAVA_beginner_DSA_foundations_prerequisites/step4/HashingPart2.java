package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;
import java.io.*;

public class HashingPart2 {
    public static void main(String[] args) {
        System.out.println("Enter the input array size, followed by inut array values in next line");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr= new int[size];

        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(" Enter no of queries followed by values for which frequency you want to know.");
        // aisa karneka
        int q = sc.nextInt();
        // declaring and precomputing our hasmap
        Map<Integer, Integer> freqmap = new HashMap<>();
        for(int i : arr){
            freqmap.put(i, freqmap.getOrDefault(i, 0)+1);
        }
        while (q-->0) { // we will run our below logic q no. of times as user has q no. of queries for us
            int queryvalue = sc.nextInt();
            System.out.println("Frequency if "+ queryvalue+" is "+ freqmap.getOrDefault(queryvalue, 0));
        }
        return;
    }
}

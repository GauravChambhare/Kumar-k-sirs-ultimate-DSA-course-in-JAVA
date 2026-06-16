package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashingPart5 {
    public static void main(String[] args) {
        System.out.println("Enter the input array1 size, followed by inut array values in next line");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr1= new int[size];

        for(int i=0; i<size; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the input array2 size, followed by input array values in the next line");
        int size2 = sc.nextInt();
        int[] arr2= new int[size2];

        for(int i=0; i<size2; i++){
            arr2[i] = sc.nextInt();
        }
        // in this question both arr1 and arr2 can have duplicate values
        // now we will check if arr[2] is subset of arr[1]
        // we will need to use hashmap as this time duplicates cna be ther, so for arr2 be subset
        // of arr1. Both elements and their frequency should be present in arr1
        // i.e, if 1 comes twice in arr2 then 1 should also come in arr1 at least twice

        Map<Integer,Integer> freqmap = new HashMap<>();
        for(int i : arr1){
            freqmap.put(i, freqmap.getOrDefault(i, 0)+1);
        }
        for(int j : arr2){
            if(freqmap.get(j)==null){
                System.out.println("Arr2 is NOT a subset of arr1!"); // We know that there is no value of j present in freqmap
                // i.e j was never present in arr1 array
                return; // we also need to ensure that we are ending our program here only, there is no need to
                // keep on checking for other elements of arr2
            }
            freqmap.put(j, freqmap.get(j)-1);
            if(freqmap.get(j)<0){ //if at any time while setting values in freqmap for element j
                // the value for that element in freqmap becomes -ve. We know that 
                System.out.println("Arr2 is NOT a subset of arr1!");
                return; // similarly we no longer need to keep on checking arr2 elements
            }
        }
        //if we have reached thill this point then we can confirm that arr2 is subset of arr1
        System.out.println("Arr2 IS subset of arr1");
        return;
    }
}

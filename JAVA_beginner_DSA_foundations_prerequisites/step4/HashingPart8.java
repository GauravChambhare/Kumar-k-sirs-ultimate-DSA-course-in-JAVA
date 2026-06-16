package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.*;
import java.util.Scanner;
import java.io.*;

/*
 * Given an array and target 'x', Find out the pair from array whose sum forms the number 'x' 
 * when both the numbers of the pair are added)
*/
public class HashingPart8 {
    public static void main(String[] args) {
        System.out.println("Enter the input array1 size, followed by inut array values in next line");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr1= new int[size];

        for(int i=0; i<size; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the input X");
        int X = sc.nextInt();
        // we will use hashmap here, for each value v in arr1 we will store X-v 
        // before adding any value in hashmap we will check if X-v value already exist in hashset or not
        // if it doesnt we will proceed with above logic, if it does then we will print True and end execution.
        // if after iteration of all elements we exit the for loop then we simply didn't encounter any such pair
        // so we will print false and exit code
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<size; i++){
            int v = arr1[i];
            if(set.contains(v)){
                // i.e, such pair exist
                System.out.println("True");
                return;
            }
            set.add(X-v);
        }
        System.out.println("False");
        return;
    }
}

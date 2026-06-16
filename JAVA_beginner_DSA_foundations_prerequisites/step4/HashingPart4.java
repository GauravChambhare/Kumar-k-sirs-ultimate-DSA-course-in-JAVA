package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class HashingPart4 {

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

        // Now we have to check if arr2 is subset of arr1
        // arr2 will be subset of arr1 if all elements of arr2 are also preset in arr1
        // both arr1 and arr2 contian unique values, it is given

        // we will simply use hashset as that is more efficient here
        // or if input constraints permits we can use boolean[] array of size[max element present in arr1]
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        // now we simply check and if at any point we see that arr1 doesnot contains any element of arr2
        // we print false
        boolean ans=true;
        for(int i : arr2){
            if(!set.contains(i)){
                ans = false;
            }
        } 
        System.out.println(ans);
        return;

    }
    
}

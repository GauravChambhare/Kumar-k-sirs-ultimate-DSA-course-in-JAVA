package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Since we know that if a duplicate is present in arr1 withing k distance/size
 * I am going to use hashset and keep its size = k.
 * HashSet has O(1) time lookup .contains() to check if something already exits.
 * I dont need hashmap since i dont need to track individual frequencies of elements
*/

public class HashingPart7 {
    public static void main(String[] args) {
        System.out.println("Enter the input array1 size, followed by inut array values in next line");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr1= new int[size];

        for(int i=0; i<size; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the input K");
        int k = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++){
            // below code won't work because while i<k the index will become -ve and we will get NegativeArrayIndexException or something
            // if(set.size()>=k){
            //     set.remove(arr1[i-k]);
            // }
            if(i>=k){ // once I value become >= k then every iteration I will keep removing arr[i-k] value from set
                set.remove(arr1[i-k]);
            }
            if(set.contains(arr1[i])){
                System.out.println("true");
                return;
            }
            set.add(arr1[i]);
        }
        System.out.println("false");
        return;
    }  
}

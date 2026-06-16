package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// que 6 Minimum operations to make all elements rqual in an array
/*
 * example arr1 = {1, 1, 1, 2, 4, 4, 4, 4}
 * min operations required will be n[size] - f[max_frequency] = 8 - 4 = 4, because there are n-f elments
 * which we will need to operate on and make them equal to 4, which has occured most in arr1
 * 
*/
public class HashingPart6 {
    public static void main(String[] args) {
        System.out.println("Enter the input array1 size, followed by inut array values in next line");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr1= new int[size];

        for(int i=0; i<size; i++){
            arr1[i] = sc.nextInt();
        }

        // we will use a hashmap to store the frequencies of elemnts
        Map<Integer,Integer> freqmap = new HashMap<>();
        for(int i : arr1){
            freqmap.put(i, freqmap.getOrDefault(i, 0)+1);
        }
        int max_frequency=0;
        for(Integer i : freqmap.values()){
            max_frequency = Math.max(max_frequency, i); // finding the maximum in values of map pairs
        }
        int max_frequency1 = freqmap.values().stream().max(Integer::compare).orElse(0);
        // above is another way using lambda and stream to performa the same
        System.out.println("Minimum no. of operations required are :"+(size-max_frequency)+" | "+(size-max_frequency1));
        return;
    }
}

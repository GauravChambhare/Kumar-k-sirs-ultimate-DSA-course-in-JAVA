import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AngryProfessor {
    final static void helperFunction(Scanner in){
        int totalStudents = in.nextInt();
        int threshold = in.nextInt();
        int[] arrivaltime = new int[totalStudents];
        int diligentStudents = 0;
        for(int i=0; i<totalStudents; i++){
            arrivaltime[i] = in.nextInt();
        }
        for(int i=0; i<totalStudents; i++){
            // if arriavltime<=0 then + 1 else 0
            diligentStudents = arrivaltime[i]<=0 ?  diligentStudents+1 : diligentStudents+ 0; 
            if(threshold<=diligentStudents){ //once threshold reaches "NO" and exit as the class DIDNOT get cancelled
                System.out.println("NO");
                return;
            }
        }
        // means threshold was not reached so "YES" as the class "did get" "Cancelled"
        System.out.println("YES");
    }
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
      int noOfTestcases = in.nextInt();
    //   System.out.println(noOfTestcases);
      for(int i=1; i<=noOfTestcases; i++){
        helperFunction(in);
      }
      return;
    }
}
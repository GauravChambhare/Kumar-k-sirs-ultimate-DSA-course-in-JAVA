package JAVA_beginner_DSA_foundations_prerequisites.step4;
import java.util.*;
import java.lang.*;
import java.io.*;

public class SpojIntroductionProblem {
    

    public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		
		while(num!=42){
			System.out.println(num);
			num = Integer.parseInt(br.readLine().trim());;
		}
		return;
	}
    
}

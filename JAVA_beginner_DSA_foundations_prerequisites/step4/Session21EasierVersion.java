package JAVA_beginner_DSA_foundations_prerequisites.step4;

public class Session21EasierVersion {
    /*
    easier version of leetcode problem
    Maximum Number of Subsequences After One Inserting
    --------
    Here we have to find no. of combinations of LC in input char array
    */
   public static int solver(char[] s){

        int count = 0;
        int ans = 0;

        for(int i=0; i<s.length; i++){
            if(s[i]=='L'){
                count++;
            }
            if(s[i]=='C'){
                ans += count;
            }
        }
        return ans;
   }
}

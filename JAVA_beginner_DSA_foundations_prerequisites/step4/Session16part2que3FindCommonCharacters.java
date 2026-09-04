package JAVA_beginner_DSA_foundations_prerequisites.step4;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Session16part2que3FindCommonCharacters {
    static class Solution {
        public List<String> commonChars(String[] words) {
            int n = words.length;
            List<String> result = new ArrayList<>();
            if(n==1){
                String[] wordChars = words[0].split("");
                for(int i=0; i< wordChars.length; i++){
                    result.add(wordChars[i]);
                }
                return result;
            }
            // base frequency map / map of first word
            Map<String, Integer> freqmap = new HashMap<>();
            String[] firstWord = words[0].split("");
            for(int i=0; i<firstWord.length; i++){
                freqmap.put(firstWord[i], freqmap.getOrDefault(firstWord[i], 0)+1);
            }
            // we have created the initial freqmap/base map
            for(int j=1; j<n; j++){
                // for each consecutive word we will create a hashmap
                Map<String, Integer> map = new HashMap<>();
                String[] word = words[j].split("");
                for(int k=0; k<word.length; k++){
                    map.put(word[k], map.getOrDefault(word[k], 0)+1);
                }
                // now comparing to base map
                for(String key : freqmap.keySet()){
                    // getting the count of each key in current word's map
                    // 0 if it is not there
                    int currentWordCount = map.getOrDefault(key, 0);
                    // now putting the minimum among currentWordCount and key's value in base map as new 
                    // value for this key in base map
                    freqmap.put(key, Math.min(freqmap.get(key), currentWordCount));
                }
            }
            for(String key : freqmap.keySet()){
                int freqForCurrentWord = freqmap.get(key);
                while(freqForCurrentWord-- > 0){
                    result.add(key);
                }
            }
            return result;
        }
    }

    // Example usage and main for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words1 = {"bella","label","roller"};
        System.out.println("Common characters: " + sol.commonChars(words1)); // Example: [e, l, l]

        String[] words2 = {"cool","lock","cook"};
        System.out.println("Common characters: " + sol.commonChars(words2)); // Example: [c, o]
    }
}
// package JAVA_beginner_DSA_foundations_prerequisites.step1;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ElectronicsShop {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        // Reading inputs
        int budget = in.nextInt();
        int a = in.nextInt(); 
        int b = in.nextInt();
        
        // keyboard options
        int[] keyboardPrices = new int[a];
        // usb prices
        int[] usbPrices = new int[b];
        
        for(int i = 0; i < a; i++){
            keyboardPrices[i] = in.nextInt();  
        }
        
        for(int j = 0; j < b; j++){
            usbPrices[j] = in.nextInt();  
        }
        
        int maxComboPrice = -1;
        
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                int currentComboPrice = keyboardPrices[i] + usbPrices[j];
                if(currentComboPrice > maxComboPrice && currentComboPrice <= budget){
                    maxComboPrice = currentComboPrice;
                }
            }
        }
        
        System.out.println(maxComboPrice);
        in.close(); // Good practice to close the scanner
    }
}
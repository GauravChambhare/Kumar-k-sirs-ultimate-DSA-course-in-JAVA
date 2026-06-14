import java.util.Arrays;

public class DetermineIfTwoEventsHaveConflict {
    
    public int toMins(String str) {
        return Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3));
    }
    
    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = toMins(event1[0]), e1 = toMins(event1[1]);
        int s2 = toMins(event2[0]), e2 = toMins(event2[1]);
        
        return Math.max(s1, s2) <= Math.min(e1, e2);
    }
    
    // Main method to test the solution locally
    public static void main(String[] args) {
        DetermineIfTwoEventsHaveConflict solution = new DetermineIfTwoEventsHaveConflict();
        
        // Test case 1: Events have conflict
        String[] event1 = {"01:15", "01:40"};
        String[] event2 = {"01:20", "02:00"};
        boolean result1 = solution.haveConflict(event1, event2);
        System.out.println("Test 1: " + result1);
        System.out.println("Event 1: " + Arrays.toString(event1));
        System.out.println("Event 2: " + Arrays.toString(event2));
        // Expected: true (conflict exists)
        
        // Test case 2: Events have no conflict
        String[] event3 = {"01:00", "01:30"};
        String[] event4 = {"01:40", "02:00"};
        boolean result2 = solution.haveConflict(event3, event4);
        System.out.println("\nTest 2: " + result2);
        System.out.println("Event 1: " + Arrays.toString(event3));
        System.out.println("Event 2: " + Arrays.toString(event4));
        // Expected: false (no conflict)
        
        // Test case 3: Events touch at boundary (have conflict)
        String[] event5 = {"01:00", "01:30"};
        String[] event6 = {"01:30", "02:00"};
        boolean result3 = solution.haveConflict(event5, event6);
        System.out.println("\nTest 3: " + result3);
        System.out.println("Event 1: " + Arrays.toString(event5));
        System.out.println("Event 2: " + Arrays.toString(event6));
        // Expected: true (conflict at boundary)
    }
}
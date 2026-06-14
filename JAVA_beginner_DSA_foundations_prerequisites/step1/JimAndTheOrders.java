import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JimAndTheOrders {
    static class Customer implements Comparable<Customer>{
        // defining properties of this class objects
        int id;
        int finishTime;
        //defining cunstructor 
        public Customer(int finishTime, int id){
            this.id = id;
            this.finishTime = finishTime;
        }
        // overriding the abstract method of Comparable interface
        @Override
        // this is the method that Collections utility class will call when we use Collections.sort() on customer objects.
        public int compareTo(Customer other){
            
            if(this.finishTime != other.finishTime){
                return Integer.compare(this.finishTime, other.finishTime);
            } else {
                return Integer.compare(this.id, other.id);
            }
        }
    }
    
    public static void main(String args[]) {
      
      Scanner in = new Scanner(System.in);
      int n ; 
      n = in.nextInt();
      //declaring a list to store inputs
      List<Customer> customerList = new ArrayList<>();
      for(int i = 0 ;i<n;i++){
          int order_id = in.nextInt();
          int prep_time = in.nextInt();
          int total_time = order_id + prep_time;
          int customer_id = i+1;
          customerList.add(new Customer(total_time, customer_id));
      }
      // now sorting the customerList
      Collections.sort(customerList);
      
      // now we have to print the customer id's post sorting
      for(Customer c : customerList){
        System.out.print(c.id+" ");
      }
      in.close();
      return;
    }
}





import java.util.*;

public class CafeUtil {
    
    public int getStreakGoal(){
        //sum together every consecutive integer from 1 to 10 and return the sum
        int sum = 0;
        for(int i = 1; i <= 10; i++){
            sum = Integer.sum(i, sum);
        }
        return sum;
    }

    public double getOrderTotal(double[]x){
        double total = 0;
        for(double element : x){
            total = Double.sum(element, total);
            //System.out.print(element + " ");
        }
        return total;
    }

    public void displayMenu(ArrayList<String> x){
        //print out each item in the arrayList
        for(int i = 0; i < x.size(); i++){
            System.out.println(i + " " + x.get(i));
        }
        // for(String element : x){
        //     System.out.println(element);
        // }
    }

    public void addCustomer(ArrayList<String> c){
        //get customer name from customer
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        //print username saying "Hello, username!""
        System.out.println("Hello, " + userName + "!");

        //print "There are __ people in front of you"
        System.out.println("There are " + c.size() + " people in front of you.");

        //add the customer's name to the customer list
        c.add(userName);

        //print the list of customers
        for(int i = 0; i < c.size(); i++){
            System.out.println(c.get(i));
        }
    }
}

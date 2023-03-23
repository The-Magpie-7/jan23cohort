
import java.util.*;

public class TestCafe {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        CafeUtil cafe = new CafeUtil();
        //System.out.println(cafe.getStreakGoal());


        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", cafe.getStreakGoal());

        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", cafe.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        cafe.displayMenu(menu);
        
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
         // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            cafe.addCustomer(customers);
            System.out.println("\n");
        }
    }
}


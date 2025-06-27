package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.accelerate.runner.SolutionNotImplementedException;
/*Our price table and offers:
+------+-------+----------------+
| Item | Price | Special offers |
+------+-------+----------------+
| A    | 50    | 3A for 130     |
| B    | 30    | 2B for 45      |
| C    | 20    |                |
| D    | 15    |                |
+------+-------+----------------+
 */
public class CheckoutSolution {
    //valid items (name, price)
    private Map<Character, Integer> shopItems;
    //custoemr items (name, number of items)
    private Map<Character, Integer> customerItems;

    public CheckoutSolution(){
        shopItems = new HashMap<>();
        shopItems.put('A', 50);
        shopItems.put('B', 30);
        shopItems.put('C', 20);
        shopItems.put('D', 15);

        customerItems = new HashMap<>();
        customerItems.put('A', 0);
        customerItems.put('B', 0);
        customerItems.put('C', 0);
        customerItems.put('D', 0);

    }
    public Integer checkout(String skus) {
        char[] items = skus.toUpperCase().toCharArray();
        Integer totalPrice = 0;
        
        for(char item : items){
            if(shopItems.containsKey(item)){
                totalPrice += shopItems.get(item);
                customerItems.put(item, customerItems.get(item)+1);

                int discount = checkDiscount(item, customerItems.get(item));
                totalPrice -= discount; 
            }
        }

        return totalPrice;
    }

    private Integer checkDiscount(char item, Integer num){
        int numDiscount = 0;
        if(item == 'A' && num>=3){
            numDiscount = num/3 *20;
        }
        else if( item =='B' && num>=2){
            numDiscount= num/2 * 15;
        }

        return numDiscount;
    }
}








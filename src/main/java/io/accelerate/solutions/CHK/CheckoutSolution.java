package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.accelerate.runner.SolutionNotImplementedException;
/*Our price table and offers:
+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
+------+-------+------------------------+
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
        shopItems.put('E', 40);

        customerItems = new HashMap<>();
        customerItems.put('A', 0);
        customerItems.put('B', 0);
        customerItems.put('C', 0);
        customerItems.put('D', 0);
        customerItems.put('E', 0);

    }
    public Integer checkout(String skus) {
        char[] items = skus.toCharArray();
        Integer totalPrice = 0;
        int discount=0;

        for(char item : items){
            if(shopItems.containsKey(item)){
                customerItems.put(item, customerItems.get(item)+1);
            }
            else{
                resetCart();
                return -1;
            }
        }

        for(Map.Entry<Character, Integer> entry : customerItems.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            int itemPrice = shopItems.get(item);
            int numDiscounts = 0;
            switch (item) {
                case 'A':
                    if(count >= 5){
                        numDiscounts = count/5;
                        totalPrice += 200*numDiscounts;
                        count -=numDiscounts;
                    } 
                    if(count >= 3){
                        numDiscounts = count/5;
                        totalPrice += 130*numDiscounts;
                        count -=numDiscounts;
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'B': 
                    if(count>=2){
                        numDiscounts = count/2;
                        totalPrice += 45*numDiscounts;
                        count -=numDiscounts;
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'C':
                    totalPrice += itemPrice*count;
                    break;

                case 'D':
                    totalPrice += itemPrice*count;
                    break;
                    
                case 'E':
                    if(count>=2){
                        numDiscounts = count/2;
                        int countB = customerItems.get('B');

                        int freeItems = Math.min(countB, numDiscounts);
                        totalPrice += (itemPrice*count) - (freeItems*30);
                    }
                    break;
                    
                default:
                    break;
            }
        }
        resetCart();
        return totalPrice;
    }

    private void resetCart(){
        customerItems.put('A', 0);
        customerItems.put('B', 0);
        customerItems.put('C', 0);
        customerItems.put('D', 0);
    }
}




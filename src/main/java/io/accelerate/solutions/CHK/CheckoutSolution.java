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
| F    | 10    | 2F get one F free      |
+------+-------+------------------------+
| G    | 20    |                        |
| H    | 10    | 5H for 45, 10H for 80  |
| I    | 35    |                        |
| J    | 60    |                        |
| K    | 80    | 2K for 120             |
| L    | 90    |                        |
| M    | 15    |                        |
| N    | 40    | 3N get one M free      |
| O    | 10    |                        |
| P    | 50    | 5P for 200             |
| Q    | 30    | 3Q for 80              |
| R    | 50    | 3R get one Q free      |
| S    | 30    |                        |
| T    | 20    |                        |
| U    | 40    | 3U get one U free      |
| V    | 50    | 2V for 90, 3V for 130  |
| W    | 20    |                        |
| X    | 90    |                        |
| Y    | 10    |                        |
| Z    | 50    |                        |
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
        shopItems.put('F', 10);
        shopItems.put('G', 20);
        shopItems.put('H', 10);
        shopItems.put('I', 35);
        shopItems.put('J', 60);
        shopItems.put('K', 70);
        shopItems.put('L', 90);
        shopItems.put('M', 15);
        shopItems.put('N', 40);
        shopItems.put('O', 10);
        shopItems.put('P', 50);
        shopItems.put('Q', 30);
        shopItems.put('R', 50);
        shopItems.put('S', 20);
        shopItems.put('T', 20);
        shopItems.put('U', 40);
        shopItems.put('V', 50);
        shopItems.put('W', 20);
        shopItems.put('X', 17);
        shopItems.put('Y', 20);
        shopItems.put('Z', 21);


        customerItems = new HashMap<>();
        customerItems.put('A', 0);
        customerItems.put('B', 0);
        customerItems.put('C', 0);
        customerItems.put('D', 0);
        customerItems.put('E', 0);
        customerItems.put('F', 0);
        customerItems.put('G', 0);
        customerItems.put('H', 0);
        customerItems.put('I', 0);
        customerItems.put('J', 0);
        customerItems.put('K', 0);
        customerItems.put('L', 0);
        customerItems.put('M', 0);
        customerItems.put('N', 0);
        customerItems.put('O', 0);
        customerItems.put('P', 0);
        customerItems.put('Q', 0);
        customerItems.put('R', 0);
        customerItems.put('S', 0);
        customerItems.put('T', 0);
        customerItems.put('U', 0);
        customerItems.put('V', 0);
        customerItems.put('W', 0);
        customerItems.put('X', 0);
        customerItems.put('Y', 0);
        customerItems.put('Z', 0);

    }
    public Integer checkout(String skus) {
        char[] items = skus.toCharArray();
        Integer totalPrice = 0;

        for(char item : items){
            if(shopItems.containsKey(item)){
                customerItems.put(item, customerItems.get(item)+1);
            }
            else{
                resetCart();
                return -1;
            }
        }

        freeItems('E',2,'B',1);
        freeItems('N',3,'M',1);
        freeItems('R',3,'Q',1);
        totalPrice += groupDiscount();

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
                        count -=numDiscounts*5;
                    } 
                    if(count >= 3){
                        numDiscounts = count/3;
                        totalPrice += 130*numDiscounts;
                        count -=numDiscounts*3;
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'B': 
                    if(count>=2){
                        numDiscounts = count/2;
                        totalPrice += 45*numDiscounts;
                        count -=numDiscounts*2;
                    }
                    totalPrice += itemPrice*count;
                    break;
                
                case 'F':
                    if(count>=3){
                        count = count/3 * 2 + (count%3);
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'H':
                    if(count >= 10){
                        numDiscounts = count/10;
                        totalPrice += 80*numDiscounts;
                        count -=numDiscounts*10;
                    }
                    if(count >= 5){
                        numDiscounts = count/5;
                        totalPrice += 45*numDiscounts;
                        count -=numDiscounts*5;
                    } 
                    totalPrice += itemPrice*count;
                    break;

                case 'K':
                    if(count >= 2){
                        numDiscounts = count/2;
                        totalPrice += 120*numDiscounts;
                        count -=numDiscounts*2;
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'P':
                    if(count >= 5){
                        numDiscounts = count/5;
                        totalPrice += 200*numDiscounts;
                        count -=numDiscounts*5;
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'Q':
                    if(count >= 3){
                        numDiscounts = count/3;
                        totalPrice += 80*numDiscounts;
                        count -=numDiscounts*3;
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'U':
                    if(count>=4){
                        count = count/4 * 3 + (count%4);
                    }
                    totalPrice += itemPrice*count;
                    break;

                case 'V':
                    if(count >= 3){
                        numDiscounts = count/3;
                        totalPrice += 130*numDiscounts;
                        count -=numDiscounts*3;
                    } 
                    if(count >= 2){
                        numDiscounts = count/2;
                        totalPrice += 90*numDiscounts;
                        count -=numDiscounts*2;
                    }
                    totalPrice += itemPrice*count;
                    break;

                default:
                    totalPrice += itemPrice*count;
                    break;
            }
        }
        resetCart();
        return totalPrice;
    }

    private void freeItems(char item, int itemsNeeded, char freeitem, int numFree){
        int count = customerItems.get(item);
        int frees = count/itemsNeeded;
        int countFreeItems = customerItems.get(freeitem);
        customerItems.put(freeitem, Math.max(0, countFreeItems-frees));
    }
    private int groupDiscount(){
        // favour Z -> STY -> X
        char[] group = {'Z', 'S', 'T', 'Y', 'X'};
        int totalGroup = 0;
        int numGroupDisc = 0;
        int total = 0;

        for(char item : group){
            totalGroup += customerItems.get(item);
        }

        numGroupDisc = totalGroup/3;
        total = numGroupDisc * 45;

        int itemsToRemove = numGroupDisc*3;
        for(char item : group){
            while(itemsToRemove>0 && customerItems.get(item)>0){
                customerItems.put(item, customerItems.get(item)-1);
                itemsToRemove--;
            }
        }

        return total;
    }

    private void resetCart(){
        for(char item : customerItems.keySet()){
            customerItems.put(item, 0);
        }
    }
}





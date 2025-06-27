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
    private Map<String, Integer> shopItems;

    public CheckoutSolution(){
        shopItems = new HashMap<>();
        shopItems.put("A", 50);
        shopItems.put("B", 30);
        shopItems.put("C", 20);
        shopItems.put("D", 15);
    }
    public Integer checkout(String skus) {
        List<String> items = toCharArray() ;
        for(char item : skus){

        }
    }
}




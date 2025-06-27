package io.accelerate.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.accelerate.solutions.HLO.HelloSolution;
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

public class CheckoutSolutionTest {
        private CheckoutSolution checkout;

    @BeforeEach
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void simpleShopping(){
        assertEquals(checkout.checkout("ABCD"), 115);
    }

    @Test
    public void discountA(){
        assertEquals(checkout.checkout("AABCAD"), 130+30+20+15);
    }

    @Test
    public void discountB(){
        assertEquals(checkout.checkout("AABBCD"), 100+45+20+15);
    }

    @Test
    public void discountAB(){
        assertEquals(checkout.checkout("AAABBCD"), 130+45+20+15);
    }

    @Test
    public void InvalidChar(){
        assertEquals(checkout.checkout("ABCD./,19235735kv"), -1);
    }
}

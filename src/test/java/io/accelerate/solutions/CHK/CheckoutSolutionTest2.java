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

public class CheckoutSolutionTest2 {
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
    public void discountEnoB(){
        assertEquals(checkout.checkout("ACDE"), 50+20+15+40);
    }

    @Test
    public void discountEwithB(){
        assertEquals(checkout.checkout("ABCDEE"), 50+20+15+80);
    }

    @Test
    public void InvalidChar(){
        assertEquals(checkout.checkout("ABCD./,19235735kv"), -1);
    }

    @Test
    public void CheckItemF(){
        assertEquals(checkout.checkout("F"), 10);
    }

    @Test
    public void CheckDiscountF(){
        assertEquals(checkout.checkout("FFF"), 20);
    }

    @Test
    public void CheckDiscountV(){
        assertEquals(checkout.checkout("V"), 50);
        assertEquals(checkout.checkout("VV"), 90);
        assertEquals(checkout.checkout("VVV"), 130);
    }

    @Test
    public void GroupDiscount(){
        assertEquals(checkout.checkout("XYZ"), 45);
    }

    @Test
    public void GroupDiscount2(){
        assertEquals(checkout.checkout("XYZA"), 45+50);
    }

     @Test
    public void GroupDiscount3(){
        assertEquals(checkout.checkout("XYZX"), 45+17);
    }

}


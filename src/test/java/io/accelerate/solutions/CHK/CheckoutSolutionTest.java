package io.accelerate.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.accelerate.solutions.HLO.HelloSolution;
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

public class CheckoutSolutionTest {
        private CheckoutSolution checkout;

    @BeforeEach
    public void setUp(){
        checkout = new CheckoutSolution();
    }

    @Test
    public void simpleShopping(){
        assertThat(checkout.checkout("ABCD"), equalTo(115));
    }
}


package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciCalculatorTest {

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        long result = FibonacciCalculator.calculate(1);
        Assert.assertEquals(1, result);
    }
}

package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciCalculatorTest {

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        long result = FibonacciCalculator.calculate(1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        long result = FibonacciCalculator.calculate(2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3() {
        long result = FibonacciCalculator.calculate(3);
        Assert.assertEquals(2, result);
    }

    @Test
    public void should_return_13_when_calculate_given_position_is_7() {
        long result = FibonacciCalculator.calculate(7);
        Assert.assertEquals(13, result);
    }

    @Test
    public void should_return_12586269025_when_calculate_given_position_is_50() {
        long result = FibonacciCalculator.calculate(50);
        Assert.assertEquals(12586269025L, result);
    }
}

package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {

    public static long calculate(int position) {
        if (position == 1) return 1;
        if (position == 2) return 1;
        return calculate(position - 1) + calculate(position - 2);
    }
}

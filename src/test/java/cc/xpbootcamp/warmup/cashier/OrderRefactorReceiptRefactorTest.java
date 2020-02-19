package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class OrderRefactorReceiptRefactorTest {
    @Test
    void shouldPrintMondayOrderListOnOrder() {
        List<GoodsRefactor> lineItems = new ArrayList<GoodsRefactor>() {{
            add(new GoodsRefactor("milk", 10.00, 2));
            add(new GoodsRefactor("biscuits", 5.00, 5));
            add(new GoodsRefactor("chocolate", 20.00, 1));
        }};
        OrderReceiptRefactor receipt = new OrderReceiptRefactor(new OrderRefactor(null, null, lineItems));

        String output = receipt.printReceipt();
        System.out.println(output);

    }


}
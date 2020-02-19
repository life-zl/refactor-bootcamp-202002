package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptRefactorTest {
    @Test
    void shouldPrintMondayOrderListOnOrder() {
        List<Goods> lineItems = new ArrayList<Goods>() {{
            add(new Goods("milk", 10.0, 2));
            add(new Goods("biscuits", 5.0, 5));
            add(new Goods("chocolate", 20.0, 1));
        }};
        OrderReceiptRefactor receipt = new OrderReceiptRefactor(new Order(null, null, lineItems));

        String output = receipt.printReceipt();
        System.out.println(output);

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
    }


}
package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class OrderReceiptTest {
    @Test
    void shouldPrintMondayOrderListOnOrder() {
        List<LineItem> lineItemItem = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItemItem));

        String output = receipt.printReceipt();

        System.out.println(output);

        assertThat(output, containsString("税额 5.30"));
        assertThat(output, containsString("总价 58.30"));
    }


}
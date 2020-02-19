package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class OrderReceiptTest {
    @Test
    void shouldPrintMondayOrderListOnOrder() {
        List<Goods> goodsItem = new ArrayList<Goods>() {{
            add(new Goods("巧克力", 21.50, 2));
            add(new Goods("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new OrderRefactor(goodsItem));

        String output = receipt.printReceipt();

        assertThat(output, containsString("税额 5.30"));
        assertThat(output, containsString("折扣 1.17"));
        assertThat(output, containsString("总价 57.13"));
    }


}
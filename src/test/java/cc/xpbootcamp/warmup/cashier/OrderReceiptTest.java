package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtil.class})
public class OrderReceiptTest {

    @Test
    public void shouldPrintHeaderInfoOnOrder() {
        List<LineItem> lineItemItem = new ArrayList<LineItem>() {{
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItemItem));

        String output = receipt.printReceipt();

        assertThat(output, containsString("====== 老王超市,值得信赖 ======"));
    }

    @Test
    public void shouldPrintBodyWithNoDiscount() {
        List<LineItem> lineItemItem = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        PowerMockito.mockStatic(DateUtil.class);
        PowerMockito.when(DateUtil.getWeekOfDate()).thenReturn("星期四");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItemItem));

        String output = receipt.printReceipt();
        System.out.println(output);

        assertThat(output, containsString("巧克力, 21.50 X 2, 43.00"));
        assertThat(output, containsString("小白菜, 10.00 X 1, 10.00"));
    }


    @Test
    public void shouldPrintSplitLineWithDiscount() {
        List<LineItem> lineItemItem = new ArrayList<LineItem>() {{
        }};
        PowerMockito.mockStatic(DateUtil.class);
        PowerMockito.when(DateUtil.getWeekOfDate()).thenReturn("星期四");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItemItem));

        String output = receipt.printReceipt();

        assertThat(output, containsString("------------------"));
    }


    @Test
    public void shouldPrintOrderListWithNoDiscount() {
        List<LineItem> lineItemItem = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        PowerMockito.mockStatic(DateUtil.class);
        PowerMockito.when(DateUtil.getWeekOfDate()).thenReturn("星期四");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItemItem));

        String output = receipt.printReceipt();
        System.out.println(output);

        assertThat(output, containsString("税额 5.30"));
        assertThat(output, containsString("总价 58.30"));
    }

    @Test
    public void shouldPrintOrderListWithDiscount() {
        List<LineItem> lineItemItem = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        PowerMockito.mockStatic(DateUtil.class);
        PowerMockito.when(DateUtil.getWeekOfDate()).thenReturn("星期三");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItemItem));

        String output = receipt.printReceipt();

        System.out.println(output);

        assertThat(output, containsString("税额 5.30"));
        assertThat(output, containsString("折扣 1.17"));
        assertThat(output, containsString("总价 57.13"));
    }


}
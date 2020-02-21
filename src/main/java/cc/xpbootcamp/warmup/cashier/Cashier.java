package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.constants.FieldConstant;

public class Cashier {

    private static String getDetail(LineItem lineItem){
        return String.format(FieldConstant.LINE_PATTERN,
                lineItem.getTitle(), lineItem.getPrice(), lineItem.getQuantity(), lineItem.getTotalAmount());
    }

    public static String printGoodsList(Order order) {
        StringBuilder output = new StringBuilder();
        order.getLineItemList().forEach(lineItem -> output.append(getDetail(lineItem)));
        return output.toString();
    }


}

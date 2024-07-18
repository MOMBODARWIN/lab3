public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        int totalQuantity = order.getItems().stream().mapToInt(Item::getQuantity).sum();
        if (totalQuantity > 5) {
            order.setShippingCost(0.0);
        } else {
            order.setShippingCost(10.0);
        }
    }
}

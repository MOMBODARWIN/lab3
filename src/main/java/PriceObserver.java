public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200.0) {
            order.setTotalPrice(order.getTotalPrice() - 20.0);
        }
    }
}

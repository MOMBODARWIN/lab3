import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<Item> items;
    private double totalPrice;
    private double shippingCost;
    private List<OrderObserver> observers;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
        this.shippingCost = 10.0; // Default shipping cost
        this.observers = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        updateTotalPrice();
        notifyObservers();
    }

    public void removeItem(Item item) {
        items.remove(item);
        updateTotalPrice();
        notifyObservers();
    }

    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    private void updateTotalPrice() {
        totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
    }

    public void updateShippingCost() {
        int totalQuantity = items.stream().mapToInt(Item::getQuantity).sum();
        shippingCost = totalQuantity > 5 ? 0.0 : 10.0;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}

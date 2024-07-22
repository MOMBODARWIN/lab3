package org.example;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("1");

        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        order.registerObserver(priceObserver);
        order.registerObserver(quantityObserver);

        Item item1 = new Item("101", "Laptop", 150.0, 1);
        Item item2 = new Item("102", "Phone", 100.0, 1);

        order.addItem(item1);
        order.addItem(item2);

        System.out.println("Total Price: " + order.getTotalPrice()); // Expected: 230.0 - 20.0 = 210.0
        System.out.println("Shipping Cost: " + order.getShippingCost()); // Expected: 10.0

        Item item3 = new Item("103", "Headphones", 50.0, 4);
        order.addItem(item3);

        System.out.println("Total Price: " + order.getTotalPrice()); // Expected: 260.0 - 20.0 = 240.0
        System.out.println("Shipping Cost: " + order.getShippingCost()); // Expected: 0.0
    }
}

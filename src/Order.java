import java.util.ArrayList;
public class Order {
    private String customerName;
    private ArrayList<String> items;
    private ArrayList<Double> prices;
    private static int totalOrders = 0;

    public Order(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.prices = new ArrayList<>();
        totalOrders++;
    }

    public void addItem(String item, double price) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid item: cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price: must be greater than 0");
        }
        items.add(item);
        prices.add(price);
    }

    public void addMultipleItems(String[] items, double... prices) {
        if (items == null || prices == null) {
            throw new IllegalArgumentException("Items and prices must not be null");
        }
        if (items.length != prices.length) {
            throw new IllegalArgumentException("Items and prices count mismatch");
        }
        for (int i = 0; i < items.length; i++) {
            try {
                addItem(items[i], prices[i]);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public double getTotalAmount() {
        double sum = 0.0;
        for (double price : prices) sum += price;
        return sum;
    }

    public String getOrderSize() {
        int count = items.size();
        if (count == 0) return "Empty order";
        else if (count <= 3) return "Small";
        else if (count <= 6) return "Medium";
        else return "Large";
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getItemCount() {
        return items.size();
    }

    public String displayOrder() {
        return String.format(
                "Order for %s: %d items, Total: $%.2f, Size: %s",
                customerName, getItemCount(), getTotalAmount(), getOrderSize()
        );
    }
}

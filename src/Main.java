public class Main {
    public static void main(String[] args) {
        System.out.println("═══ Food Ordering System ═══\n");
        System.out.println("Creating orders and adding items...");

        Order order1 = new Order("Alice Johnson");
        Order order2 = new Order("Bob Smith");
        Order order3 = new Order("Charlie Brown");

        try {
            order1.addItem("Pizza", 8.25);
            System.out.println("Item 'Pizza' added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addMultipleItems(new String[]{"Burger", "Fries"}, 9.99, 6.50);
            System.out.println("Items added: Burger, Fries");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order2.addItem("Salad", -5.00);
            System.out.println("Item 'Salad' added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order2.addItem("", 7.50);
            System.out.println("Item '' added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        order2.addMultipleItems(new String[]{"Burger", "Fries", "Pizza", "Soda", "Wings"}, 6.99, 4.50, 9.99, 3.99, 7.98);
        order3.addMultipleItems(new String[]{"Sandwich", "Juice"}, 10.00, 5.50);

        System.out.println();

        System.out.println("Order Results:");
        System.out.println(order1.displayOrder());
        System.out.println(order2.displayOrder());
        System.out.println(order3.displayOrder());
        System.out.println();

        System.out.println("Total orders created: " + Order.getTotalOrders());

        Order[] allOrders = {order1, order2, order3};
        Order maxOrder = allOrders[0];
        for (Order o : allOrders) {
            if (o.getTotalAmount() > maxOrder.getTotalAmount()) {
                maxOrder = o;
            }
        }
        System.out.printf("Largest order: %s ($%.2f)\n", maxOrder.getCustomerName(), maxOrder.getTotalAmount());
    }
}

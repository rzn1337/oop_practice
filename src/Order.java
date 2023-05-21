import java.util.ArrayList;

public class Order {

    private static int ORDER_NUMBER = 10000;
    private int order_id;
    private String customer_name;
    private double order_amount;
    private ArrayList<Product> cart;

    public Order(String customer_name) {
        order_id = ORDER_NUMBER + 1;
        ORDER_NUMBER++;
        this.customer_name = customer_name;
        this.order_amount = order_amount;
        cart = new ArrayList<Product>();
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void add(Product p) {
        cart.add(p);
    }

    public void remove(Product p) {
        cart.remove(p);
    }

    public double getOrder_amount() {
        for (Product p : cart) {
            order_amount += p.getPrice();
        }
        return order_amount;
    }
}

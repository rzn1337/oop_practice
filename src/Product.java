public class Product {

    private String name;
    private String description;
    private static int PRODUCT_NUMBER = 1000;
    private int id;
    private int quantity;
    private double price;

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.id = PRODUCT_NUMBER + 1;
        PRODUCT_NUMBER++;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return (name + ", " + description + ", " + id + ", " + price + ", " + quantity);
    }
}

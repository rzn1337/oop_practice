public class Customer {

    private String name;
    private String address;
    private static int CUSTOMER_NUMBER = 7800;
    private int id;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = CUSTOMER_NUMBER + 1;
        CUSTOMER_NUMBER++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return (name + ", " + id + ", " + address);
    }
}

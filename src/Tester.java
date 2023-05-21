import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tester {

    public Tester() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {

        File products_file = new File("C:\\Users\\Syed Ali Rizwan\\IdeaProjects\\OnlineStore\\src\\data_files\\products.txt");
        File orderhistory_file = new File("C:\\Users\\Syed Ali Rizwan\\IdeaProjects\\OnlineStore\\src\\data_files\\orderhistory.txt");


        Product p1 = new Product("Slice", "Drink", 2.99, 3);
        Product p2 = new Product("Mars", "Chocolate",  4.45, 5);
        Product p3 = new Product("Catty Chins", "Corn Chips",7.60, 13);
        Product p4 = new Product("Lays Paprika", "Potato Chips",8.60, 9);


        Store store = new Store(products_file);


        store.add(p1);
        store.add(p2);
        store.add(p3);
        store.add(p4);

        Customer customer1 = new Customer("john doe", "b-980");
        Customer customer2 = new Customer("ana de armas", "c-456");

        Order order1 = new Order(customer1.getName());
        order1.add(p1);
        order1.add(p2);
        JOptionPane.showMessageDialog(null, order1.getOrder_amount(), "order 1 bill", 1);

        Order order2 = new Order(customer2.getName());
        order2.add(p3);
        order2.add(p4);
        JOptionPane.showMessageDialog(null, order2.getOrder_amount(), "order 2 bill", 1);

        try {
            store.saveProducts();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Check File",0);
        }


        OrderHistory history = new OrderHistory(orderhistory_file);

        history.saveOrder(order1);

        history.saveOrder(order2);



        CustomerLoyalty loyalty = new CustomerLoyalty(orderhistory_file);
        loyalty.saveLoyalty();


    }

}

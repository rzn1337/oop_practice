import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    static File file;

    ArrayList<Product> products_list;

    public Store(File file) throws FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException("no file found");
        } else {
            this.file = file;
        }

        this.products_list = new ArrayList<Product>();
    }

    public void add(Product p) {
        products_list.add(p);
    }

    public void remove(Product p) {
        products_list.remove(p);
    }

    public void saveProducts() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);

        for (Product p : products_list) {
            writer.println(p.toString());
        }
        writer.close();
    }

    public void readProducts() throws FileNotFoundException {
        Scanner reader = new Scanner(file);

        while (reader.hasNext()) {
            String s = reader.nextLine();
            String[] arr = s.split(", ");
            products_list.add(new Product(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3])));
        }
        reader.close();
    }

    public void displayProducts() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        String data = "";
        while (reader.hasNext()) {
            data = data + reader.nextLine() + "\n";
        }
        JOptionPane.showMessageDialog(null, data, "Available Products", 1);
        reader.close();
    }

    public void productListByMaxPrice(double price) {
        String data = "";
        for (Product p : products_list) {
            if (p.getPrice() <= 10) {
                data += p.toString();
            }
            JOptionPane.showMessageDialog(null, "Products by price less than " + price, "Filtered Products List", 0);
        }
    }

    public void productListByQuantity(int qty) {
        String data = "";
        for (Product p : products_list) {
            if (p.getQuantity() <= 10) {
                data += p.toString();
            }
            JOptionPane.showMessageDialog(null, data, "Filtered Product List", 0);
        }
    }

    public void searchProductByName(String name) {
        name = name.toLowerCase();
        for (Product p : products_list) {
            if (p.getName().toLowerCase() == name) {
                JOptionPane.showMessageDialog(null, p.toString(), "Filtered Product List", 0);
            }
        }
    }
}



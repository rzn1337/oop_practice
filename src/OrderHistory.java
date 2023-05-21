import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OrderHistory {

    static File file;
    PrintWriter writer;

    public OrderHistory(File file) throws FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException("no file found");
        } else {
            this.file = file;
            writer = new PrintWriter(file);
        }
    }

    public void saveOrder(Order order) throws FileNotFoundException {
        writer.println(order.getOrder_id() + ", " + order.getCustomer_name() + ", " + order.getOrder_amount());
        writer.flush();
    }








}

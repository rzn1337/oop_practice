import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerLoyalty {

   static File orderhistory_file;
   static File loyalty_file;
   private static final int LOYAL = 30000;
   private static final int GOOD = 10000;
   PrintWriter writer;

   public CustomerLoyalty(File orderhistory_file) throws FileNotFoundException {
      if (orderhistory_file == null || !(orderhistory_file.getName().equalsIgnoreCase("orderhistory.txt"))) {
         throw new FileNotFoundException("no file found");
      } else {
         this.orderhistory_file = orderhistory_file;
         writer = new PrintWriter(new File("C:\\Users\\Syed Ali Rizwan\\IdeaProjects\\OnlineStore\\src\\data_files\\customerloyalty.txt"));
      }
   }

   public void saveLoyalty() throws FileNotFoundException {
      Scanner reader = new Scanner(orderhistory_file);
      while (reader.hasNext()) {
      String s = reader.nextLine();
      String[] arr = s.split(", ");
      if (Double.parseDouble(arr[2]) >= LOYAL) {
         writer.println(arr[0] + ", " + arr[1] + ", LOYAL");
      } else if (Double.parseDouble(arr[2]) >= GOOD & Double.parseDouble(arr[2]) < LOYAL ) {
         writer.println(arr[0] + ", " + arr[1] + ", GOOD");
      } else {
         writer.println(arr[0] + ", " + arr[1] + ", CASUAL");
      }
      writer.flush();
      }
   }
}

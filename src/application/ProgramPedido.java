package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.OrderWithEnum;
import entities.Product;
import entities.enums.OrderStatus;

public class ProgramPedido {
  public static void main(String[] args) throws ParseException {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner (System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Enter cliente data:");
    System.out.print("Name: ");
    String nameClient = sc.nextLine();
    System.out.print("Email: ");
    String emailClient = sc.nextLine();
    System.out.print("Birth date (DD/MM/YYYY): ");
    Date birthDateClient = sdf.parse(sc.nextLine());
    Client dataClient = new Client(nameClient, emailClient, birthDateClient);
    System.out.print("Status: ");
    OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());

    OrderWithEnum order = new OrderWithEnum(new Date(), orderStatus, dataClient);

    System.out.print("ow many items to this order? ");
    int totalItems = sc.nextInt();

    for (int i=1; i<=totalItems; i++){
      System.out.println("Enter #"+i+" item data:");
      System.out.print("Product name: ");
      sc.nextLine();
      String productName = sc.nextLine();
      System.out.print("Product price: ");
      double productPrice = sc.nextDouble();
      Product product = new Product(productName, productPrice);

      System.out.print("Quantity: ");
      int quantity = sc.nextInt();
      OrderItem orderItem = new OrderItem(quantity, productPrice, product);

      order.additem(orderItem);
    }

    System.out.println("ORDER SUMMARY:");
    System.out.print(order);

    sc.close();

  }
}

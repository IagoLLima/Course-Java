package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

public class ProgramExerciciPolimorfismo {
  public static void main(String[] args) throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Enter the number of products: ");
    int n = sc.nextInt();

    List<Product> listProduct = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      System.out.println("Product #" + i + " data:");
      System.out.print("Common, used or imported (c/u/i)? ");
      char response = sc.next().charAt(0);

      System.out.print("Name: ");
      String name = sc.next();
      System.out.print("Price: ");
      double price = sc.nextDouble();

      if (response == 'u') {
        System.out.print("Manufacture date (DD/MM/YYYY): ");
        Date manufactureDate = sdf.parse(sc.next());
        listProduct.add(new UsedProduct(name, price, manufactureDate));
      } else if (response == 'i') {
        System.out.print("Customs fee: ");
        double customsFee = sc.nextDouble();
        listProduct.add(new ImportedProduct(name, price, customsFee));
      } else {
        listProduct.add(new Product(name, price));
      }
    }

    System.out.println();
    System.out.println("PRICE TAGS:");
    for (Product product : listProduct) {
      System.out.println(product.priceTag());      
    }

    sc.close();
  }
}

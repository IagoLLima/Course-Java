package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {
  public static void main(String[] args) {

    Order order = new Order(1080,new Date(),OrderStatus.PROCESSING);

    //convertando uma Sting informado pelo usário em enum
    OrderStatus os1 = OrderStatus.DELIVERED;

    OrderStatus os2 = OrderStatus.valueOf("DELIVERED");//conversão é esse comando
    System.out.println(os1);
    System.out.println(os2);

    System.out.println(order);

  }
}
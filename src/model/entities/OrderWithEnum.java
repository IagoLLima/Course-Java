package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.enums.OrderStatus;

public class OrderWithEnum {
  
  private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  private Date moment;
  private OrderStatus status;
  private Client client;
  private List<OrderItem> orderitem = new ArrayList<>();

  public OrderWithEnum (){}

  public OrderWithEnum(Date moment, OrderStatus status, Client client) {
    this.moment = moment;
    this.status = status;
    this.client = client;
  }

  
  public void additem (OrderItem item){
    orderitem.add(item);
  }

  public void removeitem (OrderItem item){
    orderitem.remove(item);
  }

  public Date getMoment() {
    return moment;
  }

  public void setMoment(Date moment) {
    this.moment = moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public List<OrderItem> getOrderitem() {
    return orderitem;
  }

  public double total (){
    double sum = 0;
    for (OrderItem orderItem2 : orderitem) {
      sum+=orderItem2.subTotal();
    }
    return sum;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Order moment: ");
    sb.append(sdf.format(moment)+"\n");
    sb.append("Order status: ");
    sb.append(status+"\n");
    sb.append("Client:");
    sb.append(client+"\n");
    sb.append("Order items:"+"\n");
    for (OrderItem item : orderitem) {
			sb.append(item + "\n");
		}
    sb.append("Total price: $"+String.format("%.2f",total()));
    return sb.toString();
  }

}

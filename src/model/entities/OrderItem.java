package model.entities;

public class OrderItem {

  private Integer quantity;
  private Double price;
  private Product product;

  public Double subTotal (){
    return quantity*price;
  }

  public OrderItem (){}

  public OrderItem(Integer quantity, Double price, Product product) {
    this.quantity = quantity;
    this.price = price;
    this.product = product;
  }

  public Integer getquantity() {
    return quantity;
  }

  public void setquantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String toString (){
    StringBuilder sb = new StringBuilder();
    sb.append(product.getName()+", ");
    sb.append("$"+String.format("%.2f", product.getPrice())+", ");
    sb.append("Quantity: "+quantity+", ");
    sb.append("Subtotal: $"+subTotal());
    return sb.toString();
  }
  

}

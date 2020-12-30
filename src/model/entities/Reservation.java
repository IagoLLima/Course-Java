package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
  
  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;

  SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

  public Reservation (){}

  public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Date getCheckin() {
    return checkIn;
  }

  public Date getCheckout() {
    return checkOut;
  }
  
  public void updateDates (Date checkIn, Date checkOut ){
    Date now = new Date();
    this.checkIn = checkIn;
		this.checkOut = checkOut;
  }
  
  public long duration() {
    long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

}

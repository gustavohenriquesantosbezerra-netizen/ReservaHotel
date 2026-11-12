package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Reservation {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        if (!checkout.after(checkin)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Integer duration(){
        Duration duration = Duration.between(checkin.toInstant(), checkout.toInstant());
        return (int)duration.toDays();
    }

    public void updateDates(Date checkin, Date checkout){
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkout.after(checkin)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Room: "
                + roomNumber
                + ", Check-in: "
                + sdf.format(checkin)
                + ", Check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " night(s)";


    }
}

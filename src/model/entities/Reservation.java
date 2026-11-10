package model.entities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Reservation {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
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

    public String updateDates(Date checkin, Date checkout){
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
            return "Error in resevation: Reservation dates for update must be future dates";
        }
        if (!checkout.after(checkin)){
            return "Error in reservation: Check-out date must be after check-in date";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
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

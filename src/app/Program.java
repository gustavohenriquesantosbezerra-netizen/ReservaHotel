package app;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Date checkin = sdf.parse(sc.next());
        Date checkout = sdf.parse(sc.next());
        Reservation reservation = new Reservation(310,checkin,checkout);
        System.out.println(reservation.duration());
    }
}

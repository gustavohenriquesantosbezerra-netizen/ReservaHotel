package app;

import model.entities.Reservation;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero do quarto: ");
        int roomNumber = sc.nextInt();
        System.out.print("Data de checkin (dia/mês/ano): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Data de checkout (dia/mês/ano): ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else {
            Reservation reservation = new Reservation(roomNumber,checkin,checkout);

            System.out.println("Reservation " + reservation);

            System.out.println("Entre com a data para atualizar a reserva:");
            System.out.print("Data de checkin (dia/mês/ano): ");
            Date checkinUpdate = sdf.parse(sc.next());
            System.out.print("Data de checkout (dia/mês/ano): ");
            Date checkoutUpdate = sdf.parse(sc.next());

            String error = reservation.updateDates(checkinUpdate, checkoutUpdate);
            if (error != null){
                System.out.println("Error in reservation: "+ error);
            }else {
                System.out.println("Reservation " + reservation);
            }


        }
    }
}

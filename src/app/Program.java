package app;

import model.entities.Reservation;
import model.exceptions.DomainException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    static void main() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Numero do quarto: ");
            int roomNumber = sc.nextInt();
            System.out.print("Data de checkin (dia/mês/ano): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Data de checkout (dia/mês/ano): ");
            Date checkout = sdf.parse(sc.next());


            Reservation reservation = new Reservation(roomNumber,checkin,checkout);

            System.out.println("Reservation " + reservation);

            System.out.println("Entre com a data para atualizar a reserva:");
            System.out.print("Data de checkin (dia/mês/ano): ");
            Date checkinUpdate = sdf.parse(sc.next());
            System.out.print("Data de checkout (dia/mês/ano): ");
            Date checkoutUpdate = sdf.parse(sc.next());

            reservation.updateDates(checkinUpdate, checkoutUpdate);
            System.out.println("Reservation " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format!");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }



    }
}

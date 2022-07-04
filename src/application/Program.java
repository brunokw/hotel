package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check in date (DD/MM/YYYY): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check out date (DD/MM/YYYY): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reserved = new Reservation(roomNumber, checkIn, checkOut);
            System.out.print(reserved);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(sc.next());

            reserved.updateDates(checkIn, checkOut);
            System.out.println(reserved);
        }

        catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error.");

        }

        sc.close();
        }
    }

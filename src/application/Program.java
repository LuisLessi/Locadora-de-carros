package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import services.CarRental;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try {
		System.out.println("Enter rental data:");
		System.out.print("Car model: ");
		String model = sc.nextLine();
		
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		Date initialInstant = sdf.parse(sc.nextLine());
		
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finalInstant = sdf.parse(sc.nextLine());
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		
		
		CarRental invoice = new CarRental(model, initialInstant, finalInstant, pricePerHour, pricePerDay);
		
		System.out.println(invoice.toString());
		
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		}

}

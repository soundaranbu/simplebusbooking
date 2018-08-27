package bus;

import java.math.BigInteger;
import java.util.Scanner;

public class Booking {
	
	public static Bus bus = new Bus();
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		NextOperation();		
		scan.close();
	}
	
	public static void NewBooking(){
		System.out.println("Select seat number");
		bus.getCurrentSeatAvailability();
		
		//print seat availability layout here
		int seatno = scan.nextInt();
		if(!bus.validateSeatNumber(seatno)){
			System.out.println("Please enter a valid seat number");
			NextOperation();
		}
		
		//get the passenger details here
		Passenger passenger = new Passenger();
		
		System.out.println("Enter passenger name");
		String name = scan.next();		
		passenger.setName(name);
		
		System.out.println("Enter passenger mobile number");
		BigInteger mobile = scan.nextBigInteger();
		passenger.setMobile(mobile);
		
		System.out.println("Your Booking Details: ");
		System.out.println("Seat No:" + seatno);
		System.out.println("Passenger Name:" + name);
		System.out.println("Passenger Mobile: " + mobile);
		System.out.println("Do you want to proceed booking? (Yes/No)");
		String proceed = scan.next();
		String choice = "Yes";
		if(proceed.equals(choice)){
			int bookingId = bus.doBooking(seatno,  passenger);
			if(bookingId > 0){
				System.out.println("Booking successful! Here's your booking Id: " + bookingId);
			}else{
				System.out.println("Booking failed");
			}
			
			NextOperation();
		}
	}
	
	
	public static void NextOperation(){
		String Operation = ReadOperation();
		SwitchOperation(Operation);
	}
	
	public static String ReadOperation(){
		System.out.println("---------------------------------------------------------");
		System.out.println("Enter opearation to perform:");
		System.out.println("('newbooking' | 'bookingchart' | 'seatsummary')");
		return scan.next();
	}
	
	
	public static void SwitchOperation(String operation){
		switch(operation){
		case "newbooking":
			NewBooking();
			break;
		case "bookingchart":
			bus.printBookingChart();
			NextOperation();
			break;
		case "seatsummary":
			bus.getSeatsSummary();
			NextOperation();
			break;
		case "exit":
			System.out.println("Abort.");
			break;
		}
	}	
}

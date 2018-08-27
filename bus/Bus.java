package bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bus {
	
	public static int _bookingId = 0;
	
	private static int _availableSeatsCount = 1;
	
	private static int _bookedSeatsCount = 1;
	
	private static int _totalSeatsCount = 1;
	
	public static Integer[][] seats = new Integer[20][2];
	
	private int seatrows;
	
	private int seatcolumns;
	
	public static Map<Integer, Passenger> bookings;;
	
	Bus(){
		seatrows = 10;
		seatcolumns = 2;
		InitializeSeats();
		bookings = new HashMap<Integer, Passenger>();
	}
	
	private void InitializeSeats(){
		for(int i = 0; i < seatrows ; i++){
			for(int j=0; j< seatcolumns; j++){
				seats[i][j] = 0;
			}
		}
	}
	
	public ArrayList<Passenger> getPassengerList(){
		//TODO
		return new ArrayList<Passenger>();
	}
	
	public void getCurrentSeatAvailability(){
		for(int i = 0; i < seatrows ; i++){
			for(int j=0; j< seatcolumns; j++){
				System.out.print(i+""+j+ "-" + getStatusString(seats[i][j]) + "\t");
			}
			System.out.println("\n");
		}
	}
	
	protected String getStatusString(int status){
		return status > 0 ? "Booked" : "Available";
	}

	public boolean checkSeatAvilability(int seatnumber){
		if(!bookings.containsKey(seatnumber)){
			return true;
		}else{
			System.out.println("Selected seat already booked");
			return false;
		}
	}
	
	/**
	 * 
	 * @param seatno
	 * @param passenger
	 * @return
	 */
	public int doBooking(int seatno, Passenger passenger){
		if(checkSeatAvilability(seatno)){
			bookings.put(seatno, passenger);
			_bookingId++;
			int x = seatno / 10;
			int y = seatno % 10;
			seats[x][y] = _bookingId;
			return _bookingId;
		}else{
			return 0;
		}
	}
	
	public void printBookingChart(){
		
		for(Map.Entry<Integer,Passenger> entry : bookings.entrySet()){
			Integer seatno = entry.getKey();
			Passenger passenger = entry.getValue();
			
			System.out.println(seatno + " - " + passenger.getName() + " - " + passenger.getMobile());
		}
	}
	
	public int getAvailableSeatsCount(){
		return _availableSeatsCount;
	}
	
	
	public int getBookedSeatsCount(){
		return _bookedSeatsCount;
	}
	
	public int getTotalSeatsCount(){
		return _totalSeatsCount;
	}
	
	public void getSeatsSummary(){
		refreshSeatsCount();
		System.out.println("Available Seats: " + getAvailableSeatsCount());
		System.out.println("Booked Seats: " + getBookedSeatsCount());
		System.out.println("---------------------------------------------------------");
		System.out.println("Total Seats: " + getTotalSeatsCount());
	}
	
	protected void refreshSeatsCount(){
		_availableSeatsCount = 0;
		_bookedSeatsCount = 0;
		_totalSeatsCount = 0;
		for(int i = 0; i < seatrows ; i++){
			for(int j=0; j< seatcolumns; j++){
				if(seats[i][j] == 0 ){
				   _availableSeatsCount++;
				}
				if(seats[i][j] > 0 ){
					_bookedSeatsCount++;
				}
				_totalSeatsCount++;
			}
		}
	}
	
	public boolean validateSeatNumber(Integer seatno){
		if(seatno > 0){
			int x = seatno / 10;
			int y = seatno % 10;	
			if(!(x < 0 || x >= seatrows || y < 0 || y >= seatcolumns)){
				return true;
			}
		}
		return false;
	}
}

package trunk;

public class Controller {

	private Hotel [] hotels;
		
	// This method should probably query the DB for hotels and then depending on what is returned, query the rooms for each hotel.	
	public Room [] getAvailability(int startDate, int nrOfDays){
		
		Room [] availableRooms = new Room[15];	// don't know how to determine the length of this array on the fly, or if it is in any way possible

	
		return availableRooms;
	}
	
	// This method should probably query the DB for hotels and then depending on what is returned, query the rooms for each hotel and set their availability.
	public void setAvailability(int startDate, int nrOfDays){
		
	
	}
	
	// This method should probably call the constructor of the Reservation class with the necessary information
	public void createReservation() {
		
	}
	
}

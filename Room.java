package trunk;

public class Room {
	
	private int hotelID;
	private int ROOM_NUMBER;
	private int TYPE = 2;			// Single = 1, Double = 2  .. spurning um að búa til aðra klasa sem erfa Room klasann, 
									// semsagt t.d. búa til SingleRoom klasa og DoubleRoom klasa.. ?
	private int MAX_PERSONS = 2;	
	private double price;
	
	private boolean [] availableDates;
	
	public Room(int roomNumber) {
		setRoomNumber(roomNumber);
		this.availableDates = new boolean[32];	// Með allan júnímánuð frían
		setAvailableDates(1, 30, true);
	}

	public int getRoomNumber() {
		return ROOM_NUMBER;
	}

	public void setRoomNumber(int i) {
		this.ROOM_NUMBER = i;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int type) {
		TYPE = type;
	}

	public int getMAX_PERSONS() {
		return MAX_PERSONS;
	}

	public void setMAX_PERSONS(int max) {
		MAX_PERSONS = max;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getAvailability(int startDate, int nrOfDays) {
		
		boolean isFree = true;
		
		return isFree;
	}

	public void setAvailableDates(int startDate, int nrOfDays, boolean value) {
		for(int i = startDate; i < startDate+nrOfDays; i++) {
			availableDates[i] = value;
		}
	}

	public int getHotelID() {
		return hotelID;
	}

}

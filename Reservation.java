package trunk;

public class Reservation {
	private int reservationID;
	private String hotelName;
	private int dateIn;
	private int nrOfNights;
	private int nrOfRooms;
	private int nrOfGuests;
	private String firstName;
	private String lastName;
	
	// This constructor should probably just write this information straight to the DB
	public Reservation(int id, String hotelname, int datein, int nrofnights, int nrofrooms, 
			int nrofguests, String firstname, String lastname) {
		this.setReservationID(id);
		this.setHotelName(hotelname);
		this.setDateIn(datein);
		this.setNrOfNights(nrofnights);
		this.setNrOfRooms(nrofrooms);
		this.setNrOfGuests(nrofguests);
		this.setFirstName(firstname);
		this.setLastName(lastname);
	}

	public int getNrOfRooms() {
		return nrOfRooms;
	}

	public void setNrOfRooms(int nrOfRooms) {
		this.nrOfRooms = nrOfRooms;
	}

	public int getNrOfGuests() {
		return nrOfGuests;
	}

	public void setNrOfGuests(int nrOfGuests) {
		this.nrOfGuests = nrOfGuests;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getNrOfNights() {
		return nrOfNights;
	}

	public void setNrOfNights(int nrOfNights) {
		this.nrOfNights = nrOfNights;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		String first = this.getFirstName();
		String last = this.getLastName();
		
		String full = first + " " + last;
		
		return full;
	}

	public int getDateIn() {
		return dateIn;
	}

	public void setDateIn(int dateIn) {
		this.dateIn = dateIn;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
}

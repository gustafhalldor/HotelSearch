package trunk;

public class Hotel {

	private String NAME;
	private String LOCATION_CITY;
	private String LOCATION_STREET;
	private int NR_OF_ROOMS;
	private int nrOfAvailableRooms;
	private Room [] rooms;

	public Hotel(String name, String locCity, String locStreet, int nrOfRooms) {
		this.setNAME(name);
		this.setLOCATION_CITY(locCity);
		this.setLOCATION_STREET(locStreet);
		this.setNR_OF_ROOMS(nrOfRooms);
		this.setNrOfAvailableRooms(nrOfRooms);
		this.rooms = new Room[nrOfRooms];
		createRooms();
	}
	
	// Create rooms at the time of the Hotel object creation
	// We number each room from 1 to NR_OF_ROOMS
	public void createRooms() {
		int k = this.getNR_OF_ROOMS();
		
		for(int i = 0; i < k; i++) {
			rooms[i] = new Room(i+1);
		}
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public String getLOCATION_CITY() {
		return LOCATION_CITY;
	}

	public void setLOCATION_CITY(String loc) {
		LOCATION_CITY = loc;
	}

	public String getLOCATION_STREET() {
		return LOCATION_STREET;
	}

	public void setLOCATION_STREET(String loc) {
		LOCATION_STREET = loc;
	}

	public int getNR_OF_ROOMS() {
		return NR_OF_ROOMS;
	}

	public void setNR_OF_ROOMS(int nr) {
		NR_OF_ROOMS = nr;
	}

	public int getNrOfAvailableRooms() {
		return nrOfAvailableRooms;
	}

	public void setNrOfAvailableRooms(int nr) {
		this.nrOfAvailableRooms = nr;
	}
	
//	public Room [] getRoomAvailability(int startDate, int nrOfDays){
//		
//		boolean isFree = true;
//		
//		for(int i = 0; i < getNR_OF_ROOMS(); i++)
//			
//			for(int j = 1; i < 31; i++) {
//				if(this.rooms[i].getAvailability(startDate, nrOfDays) == false)
//					isFree = false;
//			}
//		
//		return rooms[1];
//	}
}

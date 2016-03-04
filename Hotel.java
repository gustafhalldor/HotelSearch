package trunk;

public class Hotel {

	private int ID;
	private String NAME;
	private String LOCATION_CITY;
	private String LOCATION_STREET;
	private int NR_OF_ROOMS;
	private Room [] availableRooms;
	private Room [] rooms;

	public Hotel(int id, String name, String locCity, String locStreet, int nrOfRooms) {
		this.setID(id);
		this.setNAME(name);
		this.setLOCATION_CITY(locCity);
		this.setLOCATION_STREET(locStreet);
		this.setNR_OF_ROOMS(nrOfRooms);
//		this.setNrOfAvailableRooms(nrOfRooms);
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

//	public int getNrOfAvailableRooms() {
//		return nrOfAvailableRooms;
//	}
//
//	public void setNrOfAvailableRooms(int nr) {
//		this.nrOfAvailableRooms = nr;
//	}

	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public Room [] copyRooms() {
		Room [] avlRooms = new Room[getNR_OF_ROOMS()];
		avlRooms = this.rooms;
		
		return avlRooms;
	}
	
	public Room [] getRoomAvailability(int startDate, int nrOfDays){
		
		Room [] availableRooms = this.copyRooms();
		int index = 0;
		
		for(int i = 0; i < getNR_OF_ROOMS(); i++) {
			
			boolean isFree = true;
		
			for(int j = startDate; j < startDate + nrOfDays; j++) {
				if(this.rooms[i].getAvailability(startDate, nrOfDays) == false)
					isFree = false;
			}
			
			// CHECK THIS SHIT OUT
			// ALWAYS RETURNS SAME ROOM 3 TIMES IN A ROW
			if(isFree)
				rooms[i] = availableRooms[index++];
		}
		
		return availableRooms;
	}
	
	public Room [] getRooms() {
		return this.rooms;
	}
}

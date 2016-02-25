package hotSearch;

public class Room {
	
	private int ROOM_NUMBER;
	private int TYPE;			// Single = 1, Double = 2  .. spurning um að búa til aðra klasa sem erfa Room klasann, 
								// semsagt t.d. búa til SingleRoom klasa og DoubleRoom klasa.. ?
	private int MAX_PERSONS;	
	private double price;
	
	public Room(int roomNumber) {
		setRoomNumber(roomNumber);
	}

	public int getRoomNumber() {
		return ROOM_NUMBER;
	}

	public void setRoomNumber(int i) {
		this.ROOM_NUMBER = i;
	}
}

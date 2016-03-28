package trunk;

public class Reservation {
	private int reservationID;
	private int hotelId;
	private int roomId;
	private long checkIn;
	private long checkOut;
	private int guestId;
	
	
	public Reservation(int id, int hotelid, int roomId, long checkin, long checkout, int guestid) {
		this.setReservationID(id);
		this.setHotelId(hotelid);
		this.setRoomId(roomId);
		this.setCheckIn(checkin);
		this.setCheckOut(checkout);
//		this.setGuestId(guestid);
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelid) {
		this.hotelId = hotelid;
	}
	
	// Úfæra í DB query
//	public String getFullName() {
//		String first = this.getFirstName();
//		String last = this.getLastName();
//		
//		String full = first + " " + last;
//		
//		return full;
//	}

	public long getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(long checkin) {
		this.checkIn = checkin;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public long getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(long checkOut) {
		this.checkOut = checkOut;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
}

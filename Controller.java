package trunk;
import java.sql.*;

public class Controller {
	
	public static void main(String[] args) throws SQLException{
//		Connection conn = PostgresqlConnection.getConnection();
//		Statement stmt = conn.createStatement();
//		String sql;
//	    sql = "SELECT hotelID, name FROM hotels";
//	    ResultSet rs = stmt.executeQuery(sql);
//	    
//	    while(rs.next()){
//	         //Retrieve by column name
//	         int id  = rs.getInt("hotelid");
//	         String name = rs.getString("name");
//
//	         //Display values
//	         System.out.print("ID: " + id);
//	         System.out.println(" Name: " + name);
//	    }

//	    isOccupied(20160331, 20160405, 20160405, 20160406);
//	    getAvailability(20160405, 20160411, 16);
//		getHotel(1);
//	    setAvailability(2, 3, 3, 4);
//	    createReservation(1, 5, 20160328, 20160329, 1);
//	    createNewGuest("Gustaf", "Gustafsson");
	}
	

	// Limited functionality of this method as it doesn't work properly if there are 2 or more occupied rooms on the dates requested
	// not skilled enough in sql to do that..
	
	public Room[] getAvailability(int checkIn, int checkOut, int nrOfRooms) throws SQLException{

		if(checkOut <= checkIn) return null;
		
		Room[] avlRooms = new Room[nrOfRooms];
		
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		
	    sql = "select distinct rooms.roomid "
	    		+ "from rooms, occupied_room "
	    		+ "where rooms.roomid = occupied_room.roomid "
	    		+ "and ((check_in <= "+checkOut+" and "+checkOut+" <= check_out) "
	    		+ "or (check_in <= "+checkIn+" and "+checkIn+" < check_out) "
	    		+ "or ("+checkIn+" < check_in and "+checkOut+" > check_out))";		
	    
	    String sql2 = "SELECT * FROM rooms, ("+sql+") AS sup WHERE sup.roomid != rooms.roomid";
	    
	    ResultSet rs = stmt.executeQuery(sql2);		// rs contains rooms that are available on the specified dates
	    int i = 0; 
	    
	    while(rs.next()){
	    	avlRooms[i] = new Room(rs.getInt("roomid"), rs.getInt("hotelid"), "Double", rs.getDouble("price"));
	    	i++;
	    	if (i == nrOfRooms) return avlRooms;
	    }
	    
	    sql = "SELECT * from rooms";
	    ResultSet rsRooms = stmt.executeQuery(sql);
	    
	    
	    if(i == 0)	// If nothing got added in the while loop above, then we add whichever rooms we want from the rooms table
	    {
		    while(rsRooms.next()){
		    	avlRooms[i] = new Room(rsRooms.getInt("roomid"), rsRooms.getInt("hotelid"), "Double", rsRooms.getDouble("price"));
		    	i++;
		    	if (i == nrOfRooms) return avlRooms;
		    }
	    }

	    System.out.println("komst í gegn");
	    return null;	// if I got through the code directly above then it means no rooms were available, or there
	    				// weren't enough rooms available
	    
	}
	
	// dates are of the format 20160327, which means year 2016, month 03 and day 27.
	public void setAvailability(int roomid, int guestid, long checkin, long checkout) throws SQLException{
		
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into occupied_room values("+roomid+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		stmt.close();
	
	}
	
	// Returns instance of the newly created reservation and call setAvailability function
	public Reservation createReservation(int hotelid, int roomid, long checkin, long checkout, int guestid) throws SQLException {
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select id from reservations";
		ResultSet rs = stmt.executeQuery(sql);
		
		// Figure out the next reservation id in line
		// --------
		int id = -1;
		while(rs.next()){
			if(rs.isLast()) id = rs.getInt("id");
		}
		
		if(id != -1) id += 1;
		else id = 1;
		// --------
		
		sql = "insert into reservations values("+hotelid+","+roomid+","+id+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		
		Reservation newRes = new Reservation(id, hotelid, roomid, checkin, checkout, guestid);
		setAvailability(roomid, guestid, checkin, checkout);
		return newRes;
	}
	
	// Returns instance of the newly created guest
	public Guest createNewGuest(String firstname, String lastname) throws SQLException {
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select id from guest";
		ResultSet rs = stmt.executeQuery(sql);
		
		// Figure out the next guest id in line
		// --------
		int id = -1;
		while(rs.next()){
			if(rs.isLast()) id = rs.getInt("id");
		}
		
		if(id != -1) id += 1;
		else id = 1;
		// --------
	
		
		sql = "insert into guest values("+id+",'"+firstname+"', '"+lastname+"')";
		stmt.execute(sql);
		
		Guest newGuy = new Guest(id, firstname, lastname);
		return newGuy;
	}
	
	public Hotel getHotel(int id) throws SQLException{
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from hotels where hotelid ="+id;
		ResultSet rs = stmt.executeQuery(sql);
		
	    while(rs.next()){
	         //Retrieve by column name
	         int hotid  = rs.getInt("hotelid");
	         String name = rs.getString("name");
	         String locCity = rs.getString("location_city");
	         String locStreet = rs.getString("location_street");

	         //Display values
	         System.out.print("ID: " + hotid);
	         System.out.println(" Name: " + name);
	         System.out.println(" loccity: " + locCity);
	         System.out.println(" locstreet: " + locStreet);
	         Hotel hotel = new Hotel(hotid, name, locCity, locStreet);
	         return hotel;
	    }
		return null;	    
	    
	}
	
	// See if checkin/checkout clashes with "start" and "end" (the dates to check against)
	// 3 cases: checkin is before start and checkout is between start and end
	//				checkin --- start <= checkout <= end
	//
	//			checkin is between start and end and checkout is after end
	//				start <= checkin < end --- checkout
	//
	//			checkin is before start and checkout is after end
	//				checkin --- start --- end --- checkout
	//			
	public boolean isOccupied(long start, long end, long checkin, long checkout){
		
		if(start <= checkout && checkout <= end) {
			System.out.println("TRUE");
			return true;
		}
		
		if(start <= checkin && checkin < end) {
			System.out.println("TRUE");
			return true;
		} 
			
		if(checkin < start && checkout > end) {
			System.out.println("TRUE");
			return true;
		}
		
		System.out.println("FALSE");
		return false;
	}
		
}

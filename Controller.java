package trunk;
import java.sql.*;

public class Controller {
	
	public static void main(String[] args) throws SQLException{
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
	    sql = "SELECT hotelID, name FROM hotels";
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("hotelid");
	         String name = rs.getString("name");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.println(" Name: " + name);
	    }

//	    getAvailability();
	    getHotel(1);
//	    setAvailability(2, 3, 3, 4);
//	    createReservation(1, 5, 20160328, 20160329, 1);
//	    createNewGuest("Gustaf", "Gustafsson");
	}
	

	// Returning random hardcoded data because it's just too complicated to fully program this method
	
	public static Room [] getAvailability(){
	
	
		int rand = (int) (Math.random()*5);
		if (rand == 0){
			Room[] availableRooms = new Room[3];

			availableRooms[0] = new Room(1, 1, "Double", 90);
			availableRooms[1] = new Room(5, 2, "Double", 100);
			availableRooms[2] = new Room(9, 3, "Double", 110);
			
			return availableRooms;
		}
		
		else if(rand == 1){
			Room[] availableRooms = new Room[3];

			availableRooms[0] = new Room(4, 2, "Double", 90);
			availableRooms[1] = new Room(8, 3, "Double", 100);
			availableRooms[2] = new Room(12, 4, "Double", 110);
			
			return availableRooms;
		}
		
		else if (rand == 2){
			Room[] availableRooms = new Room[3];

			availableRooms[0] = new Room(7, 3, "Double", 90);
			availableRooms[1] = new Room(11, 4, "Double", 100);
			availableRooms[2] = new Room(15, 5, "Double", 110);
			
			return availableRooms;
		}
		
		else if (rand == 3){
			Room[] availableRooms = new Room[3];

			availableRooms[0] = new Room(10, 4, "Double", 90);
			availableRooms[1] = new Room(14, 5, "Double", 100);
			availableRooms[2] = new Room(3, 1, "Double", 110);
			
			return availableRooms;
		}
		
		else {
			Room[] availableRooms = new Room[3];

			availableRooms[0] = new Room(13, 5, "Double", 90);
			availableRooms[1] = new Room(2, 1, "Double", 100);
			availableRooms[2] = new Room(6, 2, "Double", 110);
			
			return availableRooms;
		}

	}
	
	// dates are of the format 20160327, which means year 2016, month 03 and day 27.
	public static int setAvailability(int roomid, int guestid, long checkin, long checkout) throws SQLException{
		/*Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into occupied_room values("+roomid+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		stmt.close();*/
		
		//skilum bara random t�lu
		int bokunarNR = (int)(Math.random()*100);
		return bokunarNR;
	
	}
	
	// Returns instance of the newly created reservation
	// mock objecti� fyrir �etta ver�ur fyrir db
	public static Reservation createReservation(int hotelid, int roomid, long checkin, long checkout, int guestid) throws SQLException {
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
		return newRes;
	}
	
	// Returns instance of the newly created guest
	public static Guest createNewGuest(String firstname, String lastname) throws SQLException {
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
	
	public static Hotel getHotel(int id) throws SQLException{
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
		
}

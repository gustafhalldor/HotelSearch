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
	    
	    setAvailability(2, 3, 3, 4);
	    createReservation(1, 5, 20160328, 20160329, 1);
	    createNewGuest("Gustaf", "Gustafsson");
	}
	

	//GERA ÞETTA MEÐ DUMMY DRASLI, RETURN-A BARA RANDOM HERBERGJUM
	
//	public Room [] getAvailability(int startDate, int nrOfDays){
//	
//		Room[] availableRooms = null;
//	
//		stmt = conn.createStatement();
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
//	    
//	      rs.close();
//	      stmt.close();
//	      conn.close();
//
//	
//		return availableRooms;
//	}
	
	// dates are of the format 20160327, which means year 2016, month 03 and day 27.
	public static void setAvailability(int roomid, int guestid, long checkin, long checkout) throws SQLException{
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into occupied_room values("+roomid+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		stmt.close();
	
	}
	
	// Returns instance of the newly created reservation
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
	
		
}

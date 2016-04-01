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
	    getAvailability(20160405, 20160409, 2);
//		getHotel(1);
//	    setAvailability(2, 3, 3, 4);
//	    createReservation(1, 5, 20160328, 20160329, 1);
//	    createNewGuest("Gustaf", "Gustafsson");
	}
	

	// Returning random hardcoded data because it's just too complicated to fully program this method
	
	// Hinsvegar... ein pæling:
	// Ef við notum long/int fyrir dagsetningar þá væri hægt að skoða occupied_rooms töfluna og sjá hvort að checkin/checkout
	// tölurnar sem við fáum inní fallið séu einhversstaðar á milli checkin/checkout talnanna fyrir hvert herbergi í 
	// occupied_room töflunni. Ef svo, þá er herbergið ekki laust.
	// Dæmi: herbergi er á leigu frá 20160331 til 20160405 og það er í töflunni. Við fáum inn getAvailability(20160403, 20160408)
	// Þá er checkin dagsetningin *****403 vissulega á milli *****331 og *****401 og herbergið þá ekki í hópi þeirra sem eru laus.
	// Þetta er ekkert spes lausn, en virkar fyrir svona lítið prógramm eins og við erum með. Ef herbergin væru fleiri, þá væri þetta glatað.
	
	// Skilar fyrstu herbergjunum sem eru laus, án tillits til staðsetningar eða verðs.
	
//	public static Room [] getAvailability(long checkIn, long checkOut, int nrOfRooms){
	
	public static Room[] getAvailability(int checkIn, int checkOut, int nrOfRooms) throws SQLException{
//		ControllerMockTrue mocker = new ControllerMockTrue();
//		return mocker.getAvailability(checkIn, checkOut, nrOfRooms);

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
	    
	    ResultSet rs = stmt.executeQuery(sql2);		//Hérna eru öll herbergi sem eru laus þennar dagsetningar
	    
	    int i = 0;
	    
	    while(rs.next()){
	    	avlRooms[i] = new Room(rs.getInt("roomid"), rs.getInt("hotelid"), "Double", rs.getDouble("price"));
	    	i++;
	    	if (i == nrOfRooms) return avlRooms;
	    }
	   
	    System.out.println("komst í gegn");
	    return null;	// if I got through the code directly above then it means no rooms were available, or there
	    				// weren't enough rooms available
	    
	    		
	
//		int rand = (int) (Math.random()*5);
//		if (rand == 0){
//			Room[] availableRooms = new Room[3];
//
//			availableRooms[0] = new Room(1, 1, "Double", 90);
//			availableRooms[1] = new Room(5, 2, "Double", 100);
//			availableRooms[2] = new Room(9, 3, "Double", 110);
//			
//			return availableRooms;
//		}
//		
//		else if(rand == 1){
//			Room[] availableRooms = new Room[3];
//
//			availableRooms[0] = new Room(4, 2, "Double", 90);
//			availableRooms[1] = new Room(8, 3, "Double", 100);
//			availableRooms[2] = new Room(12, 4, "Double", 110);
//			
//			return availableRooms;
//		}
//		
//		else if (rand == 2){
//			Room[] availableRooms = new Room[3];
//
//			availableRooms[0] = new Room(7, 3, "Double", 90);
//			availableRooms[1] = new Room(11, 4, "Double", 100);
//			availableRooms[2] = new Room(15, 5, "Double", 110);
//			
//			return availableRooms;
//		}
//		
//		else if (rand == 3){
//			Room[] availableRooms = new Room[3];
//
//			availableRooms[0] = new Room(10, 4, "Double", 90);
//			availableRooms[1] = new Room(14, 5, "Double", 100);
//			availableRooms[2] = new Room(3, 1, "Double", 110);
//			
//			return availableRooms;
//		}
//		
//		else {
//			Room[] availableRooms = new Room[3];
//
//			availableRooms[0] = new Room(13, 5, "Double", 90);
//			availableRooms[1] = new Room(2, 1, "Double", 100);
//			availableRooms[2] = new Room(6, 2, "Double", 110);
//			
//			return availableRooms;
//		}

	}
	
	// dates are of the format 20160327, which means year 2016, month 03 and day 27.
	public int setAvailability(int roomid, int guestid, long checkin, long checkout) throws SQLException{
		int bokunarNR = (int)(Math.random()*100);
		return bokunarNR;
		
		
		/*Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into occupied_room values("+roomid+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		stmt.close();*/
		
		//skilum bara random tölu
		// Gústaf edit: Skila breytu sem heitir bokunarNR úr setAvailability fallinu? hmmm... Ekki createReservation fallinu?
		
	
	}
	
	// Returns instance of the newly created reservation
	// mock objectið fyrir þetta verður fyrir db
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
	public static boolean isOccupied(long start, long end, long checkin, long checkout){
		
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

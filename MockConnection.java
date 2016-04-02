package trunk;

import java.sql.*;

public class MockConnection {
	
	ResultSet rs;
	Connection conn;
	
	public Connection getConnectionMock(){
		
//		int random sem væri annaðhvor 1 eða 0
//		svo skilum við annaðhvort að connectionið gangi eða faili, byggt á random
		
		return conn;
	}
	
	public Room[] getRooms(int x){
		
		if (x == 1){
			Room[] availableRooms = new Room[3];

			availableRooms[0] = new Room(1, 1, "Double", 90);
			availableRooms[1] = new Room(5, 2, "Double", 100);
			availableRooms[2] = new Room(9, 3, "Double", 110);
			
			return availableRooms;
		}

		else return null;
	}
}

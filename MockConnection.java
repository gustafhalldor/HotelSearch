package trunk;

import java.sql.*;

public class MockConnection {
	
	ResultSet rs;
	Connection conn;
	
	public Connection getConnectionMock(){
		
//		int random sem v�ri anna�hvor 1 e�a 0
//		svo skilum vi� anna�hvort a� connectioni� gangi e�a faili, byggt � random
		
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

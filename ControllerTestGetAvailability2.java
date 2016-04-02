package trunk;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTestGetAvailability2 {
	int dateIn;
	int dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	
	@Before
	public void setUp1() throws Exception {
		nrOfRooms = 15;
		dateIn = 20160402;
		dateOut = 20160406;
	}
	@Test
	public void testGetAvailability() throws SQLException {
		Room[] rooms = Controller.getAvailability(dateIn, dateOut, nrOfRooms);
		
		assertNull(rooms);
	}
	@After
	public void tearDown1() throws Exception {
		nrOfRooms = 2;
		dateIn = 0;
		dateOut = 0;
	}

}

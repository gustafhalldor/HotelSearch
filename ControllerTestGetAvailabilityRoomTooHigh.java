package trunk;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTestGetAvailabilityRoomTooHigh {
	int dateIn;
	int dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	
	@Before
	public void setUp() {
		nrOfRooms = 16;		// Nr of rooms is too high. There aren't that many rooms available.
		dateIn = 20160405;
		dateOut = 20160411;
	}
	@Test
	public void testGetAvailability() throws SQLException {
		Room[] rooms = cont.getAvailability(dateIn, dateOut, nrOfRooms);
		
		assertNull(rooms);
	}
	@After
	public void tearDown() {
		nrOfRooms = 0;
		dateIn = 0;
		dateOut = 0;
	}

}

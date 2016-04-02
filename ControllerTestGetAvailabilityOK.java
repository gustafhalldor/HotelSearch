package trunk;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTestGetAvailabilityOK {
	int dateIn;
	int dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	
	@Before
	public void setUp(){
		nrOfRooms = 2;
		dateIn = 20160402;
		dateOut = 20160406;
	}
	@Test
	public void testGetAvailability() throws SQLException {
		Room[] rooms = cont.getAvailability(dateIn, dateOut, nrOfRooms);
		
		assertNotNull(rooms);
	}
	@After
	public void tearDown() {
		nrOfRooms = 0;
		dateIn = 0;
		dateOut = 0;
	}
}

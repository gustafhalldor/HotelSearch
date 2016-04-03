package trunk;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ControllerTestGetAvailabilityDates {
	int dateIn;
	int dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	ExpectedException exception = ExpectedException.none(); 
	
	@Before
	public void setUp() {
		nrOfRooms = 2;
		dateIn = 20160405;
		dateOut = 20160403;		// dateOut is before dateIn in time!
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

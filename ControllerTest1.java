package trunk;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest1 {
	long dateIn;
	long dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	
	@Before
	public void setUp2() throws Exception {
		dateIn = 20160602;
		dateOut = 20160702;
		nrOfRooms = 2;
	}

	@Test
	public void testNrOfRoom() throws SQLException {
		assertTrue(cont.getAvailability(dateIn, dateOut, nrOfRooms));
	}
	
	@After
	public void tearDown2() throws Exception {
		dateIn = 0;
		dateOut = 0;
		nrOfRooms = 0;
	}

}

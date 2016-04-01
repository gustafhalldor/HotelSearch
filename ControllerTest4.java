package trunk;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest4 {

	long dateIn;
	long dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	
	@Before
	public void setUp3() throws Exception {
		dateIn = 20160602;
		dateOut = 20160502;
		nrOfRooms = 2;
	}

	@Test
	public void testRoomNr() throws SQLException {
		assertTrue(cont.getAvailability(dateIn, dateOut, nrOfRooms));
	}
	@After
	public void tearDown3() throws Exception {
		dateIn = 0;
		dateOut = 0;
		nrOfRooms = 0;
	}
}






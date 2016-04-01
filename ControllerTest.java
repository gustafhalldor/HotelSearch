package trunk;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	int roomid;
	int guestid;
	long dateIn;
	long dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	
	@Before
	public void setUp1() throws Exception {
		roomid = 1;
		guestid = 2;
		dateIn = 20160602;
		dateOut = 20160702;
	}
	@Test
	public void testSetAvailability() throws SQLException {
		int bokunarNr = cont.setAvailability(roomid, guestid, dateIn, dateOut);
		System.out.println(bokunarNr);
		assertTrue(bokunarNr <100 && bokunarNr >=0);
	}
	@After
	public void tearDown1() throws Exception {
		roomid = 0;
		guestid = 0;
		dateIn = 0;
		dateOut = 0;
	}

}

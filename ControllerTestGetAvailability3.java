package trunk;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ControllerTestGetAvailability3 {
	int dateIn;
	int dateOut;
	int nrOfRooms;
	Controller cont = new Controller();
	ExpectedException exception = ExpectedException.none(); 
	
	@Before
	public void setUp1() throws Exception {
		nrOfRooms = 0;
		dateIn = 20160402;
		dateOut = 20160406;
	}
	@Test
	public void testGetAvailability() throws SQLException {
		Controller.getAvailability(dateIn, dateOut, nrOfRooms);
		exception.expect(NullPointerException.class);
	}
	@After
	public void tearDown1() throws Exception {
		nrOfRooms = 2;
		dateIn = 0;
		dateOut = 0;
	}

}

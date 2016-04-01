package trunk;

public class ControllerMockTrue {
	public boolean getAvailability(long dateIn, long dateOut, int nrOfRooms){
		
		if (nrOfRooms<=0) return false;
		if (nrOfRooms>100) return false;
		if (dateOut < dateIn) return false;
		return true;
	}
}

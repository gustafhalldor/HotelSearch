package trunk;

public class TESTING_STUFF {
	public static void main(String[] sup) {
		Hotel hot1 = new Hotel(1, "Adam", "Reykjavik", "Skolavordustigur", 3);
		Hotel hot2 = new Hotel(2, "101", "Reykjavik", "Hverfisgata", 3);
		Hotel hot3 = new Hotel(3, "Centrum", "Reykjavik", "Adalstraeti", 3);

		
		System.out.println(hot1.getNAME());
		System.out.println(hot2.getNAME());
		System.out.println(hot3.getNAME());
		System.out.println(hot3.getLOCATION_CITY());
		System.out.println(hot3.getLOCATION_STREET());
	}
}

package local.java.excercise.datapresentation;

import java.util.Comparator;

public class MapComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		SexAndAge s1 = (SexAndAge) o1;
		SexAndAge s2 = (SexAndAge) o2;
		
		//return s1.toString().compareTo(s2.toString());
		return s1.Age.compareTo(s2.Age);
	}


}

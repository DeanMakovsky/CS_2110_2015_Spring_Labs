package Lab4_Feb9_10;

import java.util.ArrayList;

public class Lab4Driver {

	public static void main(String[] args) {
		
//		ArrayList<String> list1 = new ArrayList<String>();
		 UniqueArrayList<String> list2 = new UniqueArrayList<String>();
		 BoundedArrayList<String> list3 = new BoundedArrayList<String>(5);
		
		 ArrayList<String> listAlias = list3;  // change this to test each kind of list
			
		String[] hamlet = { "to", "be", "or", "not", "to", "be" };
		for (int i=0; i < hamlet.length; ++i) {
			listAlias.add( hamlet[i] );
		}
		System.out.println(listAlias);

	}

}

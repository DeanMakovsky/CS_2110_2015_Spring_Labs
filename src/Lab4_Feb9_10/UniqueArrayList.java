package Lab4_Feb9_10;

import java.util.ArrayList;
import java.util.Collection;

public class UniqueArrayList<T> extends ArrayList<T> {

	// the Override checks to make sure your inheritance structure is correct
	@Override
	public boolean add(T item) {
		if (super.contains(item)) {
			return false;
		}

		super.add(item); // fun fact! calling this.add(item) would result in
							// infinite recursive loop.
		return true;

	}

	public boolean addAll(Collection<? extends T> c) {
		// the reason we have to write "? extends E" is because we don't really
		// care what class is passed in -- just as long as it inherits from type
		// T at some point.
		boolean retVal = false; // see official documentation for return value
								// specs
		for (T value : c) { // because c is a Collection, we can do this
							// (Collection implements *iterable*)
			if (this.add(value)) { // this performs the addition as well as
									// tells us if something changed
				retVal = true;
			}
		}

		return retVal;
	}

	/*
	 * Other methods that could be similarly implemented:
	 * 		*add(int index, T item)
	 * 		*addAll(int index, collection...)
	 * 		*set(int index, T item)
	 * 
	 * Also applies to BoundedArrayList
	 * 
	 */
	
}

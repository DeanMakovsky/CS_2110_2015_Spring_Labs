package Lab4_Feb9_10;

import java.util.ArrayList;

public class BoundedArrayList<T> extends ArrayList<T> {
	private int cap;
	public BoundedArrayList(int cap) {
		super();
		this.cap = cap;
	}
	@Override
	public boolean add(T item) {
		if (super.size() >= cap) { // we can use either super or this
			return false;
		}
		super.add(item);
		return true;
	}
	// addAll, et al. should also be implemented
}

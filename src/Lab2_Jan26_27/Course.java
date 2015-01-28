package Lab2_Jan26_27;

import java.util.ArrayList;

public class Course {
	private String id;
	private String name;
	private ArrayList<Student> roll;

	public Course(String id, String name) {
		if (id == null || id.equals("") || name == null || name.equals("")) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name = name;
		this.roll = new ArrayList<Student>();
	}

	public boolean add(Student s) {
		if (!roll.contains(s)) {
			roll.add(s);
			s.add(this);
			return true;
		}
		return false;
	}

	public boolean drop(Student s) {
		if (roll.contains(s)) {
			roll.remove(s);
			s.drop(this);
			return true;
		}
		return false;
	}

	public void cancel() {
		for (int i = roll.size() - 1; i >= 0; i--) {
			drop(roll.get(i));
		}
	}

	public double averageGPA() {
		double sum = 0;
		for (Student s : roll) {
			sum += s.getGpa();
		}
		return sum / roll.size();
	}

	@Override
	public String toString() {
		String temp = "";
		for (Student s : roll) {
			temp += s.fromString();
		}
		return "[" + id + ", " + name + ", students: " + temp + "]";
	}

	public String fromString() {
		return "[" + id + ", " + name + "]";
	}

	/*
	 * EQUALS METHOD
	 * 
	 * The reason we don't need an equals(Object o) method in Course is because
	 * of certain assumptions under which we are running this code. We are
	 * assuming that we only instantiate a particular university course at most
	 * once, meaning CS2110 will only have one object created for it in this
	 * program. Yes, the ArrayLists's 'contains()' method does call the equals
	 * method, but because we are assuming all identical classes are the same
	 * object, comparing memory addresses is enough (default behavior of
	 * Object's equals method is to use '==') to determine if a student is in a
	 * class or not.
	 */

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Student> getRoll() {
		return roll;
	}

}

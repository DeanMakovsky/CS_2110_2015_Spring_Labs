package Lab2_Jan26_27;

import java.util.ArrayList;

public class Student {
	private String name;
	private double gpa;
	private ArrayList<Course> courses;

	public Student(String name, double gpa) {
		if (name == null || name.equals("") || gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException(); // All exceptions are objects
													// in Java- you are
													// literally creating a new
													// Exception object. Think
													// ArrayIndexOutOfBoundsException
		}
		this.name = name;
		this.gpa = gpa;
		this.courses = new ArrayList<Course>();
	}

	public Student(String name) {
		this(name, 0); // just pass to constructor we just wrote
	}

	public boolean add(Course c) {
		if (!courses.contains(c)) {
			this.courses.add(c);
			c.add(this);
			return true;
		}
		return false;
	}

	public boolean drop(Course c) {
		if (courses.contains(c)) {
			courses.remove(c);
			c.drop(this);
			return true;
		}
		return false;
	}

	public void dropAll() {
		//backwards to make sure we don't skip any
		for (int i = courses.size() - 1; i >= 0; i--) {
			// no need to duplicate code for making sure Course stays in sync
			this.drop(courses.get(i));
		}
	}

	@Override
	public String toString() {
		String temp = "";
		//for each loop -- think iterating over all elements in arraylist
		for (Course c : courses) {
			temp += c.fromString(); // prevent infinite loop
		}
		return "[" + name + ", " + gpa + ", in: " + temp + "]";
	}
	
	public String fromString() {
		return "[" + name + ", " + gpa + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Student) {
			return ((Student)o).getName().equals(this.getName());
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		if (gpa >= 0 && gpa <= 4) {
			this.gpa = gpa;
		}
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	// spec unclear if this should be included
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

}

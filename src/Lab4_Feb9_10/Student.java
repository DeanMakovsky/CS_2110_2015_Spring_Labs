package Lab4_Feb9_10;

import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student> {

	private double gpa;
	private String name;

	public Student(double gpa, String name) {
		if (gpa > 4) {
			this.gpa = 4;
		} else if (gpa < 0) {
			this.gpa = 0;
		} else {
			this.gpa = gpa;
		}
		this.name = name;
	}

	/* Part of Comparable */
	@Override
	public int compareTo(Student other) {
		double gpaDif = other.getGpa() - this.getGpa(); // could reverse
														// ordering by changing
														// these two terms
		if (Math.abs(gpaDif) < 0.000001) { // for practical reasons, if their
											// GPAs are close enough, then they
											// can be considered equal
			return this.getName().compareTo(other.getName());
		} else if (gpaDif < 0) {
			// could have also used Double.compare(this.getGpa(), other.getGpa());
			return -1;
		} else {
			return 1;
		}
		/*
		 * Note that we CANNOT return gpaDif because Java will automatically
		 * cast this double to an int. During this casting, 0.5 would be casted
		 * to 0, which would be wrong.
		 */
	}

	public String getName() {
		return name;
	}

	public double getGpa() {
		return this.gpa;
	}

	/* Part of Comparator */
	@Override
	public int compare(Student one, Student two) {
		/*
		 * Note that we should not use "this" in this method. That is because
		 * "this" refers to the current object, not necessarily the two that we
		 * are comparing. "this" is just acting as something that can compare
		 * two other things.
		 */

		int temp = one.getName().compareTo(two.getName());
		if (temp == 0) {
			return one.compareTo(two); // will compare by gpa next.
		} else {
			return temp;
		}
		
		/*  If you don't like that version, here is an equivalent statement:
		 * 
		int temp = one.getName().compareTo(two.getName());
		if (temp == 0) {
			double gpaDif = two.getGpa() - one.getGpa(); 
			if (Math.abs(gpaDif) < 0.000001) {
				return one.getName().compareTo(two.getName());
			} else if (gpaDif < 0) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return temp;
		} */
	}

	public static void main(String[] args) {
		Student s1 = new Student(3.9, "Jimmy");
		Student s2 = new Student(1.564, "Yacob");
		Student s3 = new Student(2.333, "Stew Pendous");
		Student s4 = new Student(2.333, "Other name");

		// Note that the actual return values do not have to be -1,0,or 1.
		// compareTo specifies that the return value should be either negative,
		// zero, or positive
		System.out.println(s1.compareTo(s2)); // should be -1 (negative)
		System.out.println(s3.compareTo(s4)); // should be 1 (positive)
		System.out.println(s4.compareTo(s3)); // should be -1 (negative)
		System.out.println(s4.compareTo(s4)); // should be 0

	}

}

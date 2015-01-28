package Lab2_Jan26_27;

public class Test {

	public static void main(String[] args) {
		try {
			Student a = new Student("Dean", -1.555585);
			System.out.println("Failed!");
		} catch (IllegalArgumentException e) {
			System.out.println("passed!");
		}
		try {
			Student a = new Student("Dean", 4.88874521478);
			System.out.println("Failed!");
		} catch (IllegalArgumentException e) {
			System.out.println("passed!");
		}
		
		Student a = new Student("Dean", 2.3);
		Student b = new Student("Aaren'sparentsdon'tknowhowtospell", 2.5);
		Student c = new Student("Her", 4.0);
		Student d = new Student("Areallybadstudent");
		Course aa = new Course("cs2110", "intro to soft matters");
		Course bb = new Course("psyc2150", "metacognition");
		
		System.out.println(a);
		System.out.println(aa);
		a.add(aa); // test add in Student + Course
		a.add(aa); // but should not add twice
		System.out.println(a);
		System.out.println(aa);
		a.add(bb); // test adding 2 Courses
		System.out.println(a);
		a.drop(aa); // test dropping
		System.out.println(a);
		System.out.println(aa);
		a.add(aa); // test multiple people in class then one student dropping all
		b.add(aa);
		c.add(bb);
		System.out.println(aa);
		a.dropAll();
		System.out.println(a);
		System.out.println(aa);
		System.out.println(bb);
		a.drop(aa); // try to drop something that is not there
		System.out.println(a);
		aa.add(a);
		aa.add(b);
		aa.add(c);
		aa.add(d);
		System.out.println(a);
		System.out.println(aa);
		System.out.println(aa.averageGPA());
	}

}

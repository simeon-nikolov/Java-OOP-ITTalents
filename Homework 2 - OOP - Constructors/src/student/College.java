package student;

public class College {

	public static void main(String[] args) {
		Student student1 = new Student("Pesho Peshov", "Informatics", 4.5, (byte)1, (byte)19, false, 0);
		Student student2 = new Student("Homer Simpson", "Biology", 3.1, (byte)1, (byte)19, false, 0);
		Student student3 = new Student("Jack Sparrow", "Informatics", 4.9, (byte)1, (byte)19, false, 0);
		Student student4 = new Student("John Cena", "Biology", 5.5, (byte)1, (byte)19, false, 0);
		Student student5 = new Student("Mike Schmidt", "Informatics", 4.2, (byte)1, (byte)19, false, 0);
		student1.receiveScholarship(4.5, 300);
		student3.receiveScholarship(4.5, 300);
		student5.receiveScholarship(4.5, 300);
		student2.upYear();
		student4.upYear();
		StudentGroup groupA = new StudentGroup("Informatics");
		StudentGroup groupB = new StudentGroup("Biology");
		groupA.addStudent(student1);
		groupA.addStudent(student3);
		groupA.addStudent(student5);
		groupB.addStudent(student2);
		groupB.addStudent(student4);
		System.out.println(groupA.theBestStudent());
		System.out.println(groupB.theBestStudent());
		System.out.println();
		System.out.println("Group A:");
		groupA.printStudentsInGroup();
		System.out.println("Group B:");
		groupB.printStudentsInGroup();
	}

}

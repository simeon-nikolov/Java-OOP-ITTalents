package student;

public class StudentGroup {
	private static final String STUDENT_IS_NULL_MESSAGE = "Student is null!";
	private static final int DEFAULT_FREE_PLACES = 5;
	private static final int MIN_FREE_PLACES = 1;
	
	private String groupSubject;
	private Student[] students;
	private int freePlaces;
	private int lastStudentIndex;
	
	public StudentGroup() {
		this.freePlaces = DEFAULT_FREE_PLACES;
		this.students = new Student[DEFAULT_FREE_PLACES];
		this.lastStudentIndex = 0;
	}
	
	public StudentGroup(String groupSubject) {
		this();
		this.setGroupSubject(groupSubject);
	}
	
	public void addStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException(STUDENT_IS_NULL_MESSAGE);
		}
		
		if (this.freePlaces >= MIN_FREE_PLACES && 
				student.getSubject().equals(this.groupSubject)) {
			if (this.lastStudentIndex < this.students.length) {
				this.students[this.lastStudentIndex] = student;
				this.lastStudentIndex++;
				this.freePlaces--;
			}
		}
	}
	
	public void emptyGroup() {
		this.students = new Student[DEFAULT_FREE_PLACES];
	}
	
	public String theBestStudent() {
		String name = "";
		double maxGrade = Student.MIN_GRADE;
		
		for (int index = 0; index < students.length; index++) {
			if (students[index] != null && 
					students[index].getGrade() > maxGrade) {
				name = students[index].getName();
				maxGrade = students[index].getGrade();
			}
		}
		
		return name;
	}
	
	public void printStudentsInGroup() {
		for (int index = 0; index < students.length; index++) {
			if (students[index] != null) {
				System.out.println(students[index]);
			}
		}
	}

	public String getGroupSubject() {
		return this.groupSubject;
	}
	
	public void setGroupSubject(String groupSubject) {
		if (groupSubject != null && groupSubject != "") {
			this.groupSubject = groupSubject;
		}
	}
	
	public int getFreePlaces() {
		return this.freePlaces;
	}
}

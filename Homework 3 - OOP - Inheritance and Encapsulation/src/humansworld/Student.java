package humansworld;

public class Student extends Person {
	private static final String INVALID_SCORE_MESSAGE = "Invalid Parameter! Score must be between 2 and 6!";
	
	private double score;

	public Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		this.score = score;
	}
	
	public void showStudentInfo() {
		super.showPersonInfo();
		System.out.println("Score: " + this.score);
	} 

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		if (score < 2.0 || score > 6.0) {
			throw new IllegalArgumentException(INVALID_SCORE_MESSAGE);
		}
		
		this.score = score;
	}
}

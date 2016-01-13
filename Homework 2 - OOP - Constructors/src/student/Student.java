package student;

public class Student {
	private static final String ALREADY_DEGREED_MESSAGE = "The student has already degreed!";
	private static final int MAX_AGE_FOR_SCHOLARSHIP = 30;
	private static final boolean DEFAULT_IS_DEGREE_VALUE = false;
	private static final double DEFAULT_GRADE = 4.0f;
	private static final double MIN_MONEY_FROM_SCHOLARSHIP = 0.0f;
	private static final int MAX_AGE = 120;
	private static final int MIN_AGE = 0;
	private static final byte MAX_YEAR_IN_COLLEGE = 4;
	private static final byte MIN_YEAR_IN_COLLEGE = 1;
	private static final double MAX_GRADE = 6.0f;
	public static final double MIN_GRADE = 2.0f;

	private String name;
	private String subject;
	private double grade;
	private byte yearInCollege;
	private byte age;
	private boolean isDegree;
	private double money;
	
	public Student() {
		this.setGrade(DEFAULT_GRADE);
		this.setYearInCollege(MIN_YEAR_IN_COLLEGE);
		this.setIsDegree(DEFAULT_IS_DEGREE_VALUE);
		this.setMoney(MIN_MONEY_FROM_SCHOLARSHIP);
	}
	
	public Student(String name, String subject, double grade,
			byte yearInCollege, byte age, boolean isDegree, double money) {
		this();
		this.setName(name);
		this.setSubject(subject);
		this.setGrade(grade);
		this.setYearInCollege(yearInCollege);
		this.setAge(age);
		this.setIsDegree(isDegree);
		this.setMoney(money);
	}
	
	public void upYear() {
		if (!this.isDegree) {
			this.yearInCollege++;
			
			if (this.yearInCollege == MAX_YEAR_IN_COLLEGE) {
				this.setIsDegree(true);
			}
		} else {
			System.out.println(ALREADY_DEGREED_MESSAGE);
		}
	}
	
	public double receiveScholarship(double minGrade, double amount) {
		if (this.grade >= minGrade && this.age < MAX_AGE_FOR_SCHOLARSHIP) {
			if (amount >= MIN_MONEY_FROM_SCHOLARSHIP) {
				this.money += amount;
			}
		}
		
		return this.money;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name != null && !name.equals("")) {
			this.name = name;
		}
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		if (subject != null && !subject.equals("")) {
			this.subject = subject;
		}
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public void setGrade(double grade) {
		if (MIN_GRADE <= grade && grade <= MAX_GRADE) {
			this.grade = grade;
		}
	}
	
	public byte getYearInCollege() {
		return this.yearInCollege;
	}
	
	public void setYearInCollege(byte yearInCollege) {
		if (MIN_YEAR_IN_COLLEGE <= yearInCollege && yearInCollege <= MAX_YEAR_IN_COLLEGE) {
			this.yearInCollege = yearInCollege;
		}
	}
	
	public byte getAge() {
		return this.age;
	}
	
	public void setAge(byte age) {
		if (MIN_AGE <= age && age <= MAX_AGE) {
			this.age = age;
		}
	}
	
	public boolean isDegree() {
		return this.isDegree;
	}
	
	public void setIsDegree(boolean isDegree) {
		this.isDegree = isDegree;
	}
	
	public double getMoney() {
		return this.money;
	}
	
	public void setMoney(double money) {
		if (MIN_MONEY_FROM_SCHOLARSHIP <= money) {
			this.money = money;
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Grade: " + grade + 
				", Subject: " + subject + ", Age: " + age  + 
				", Year: " + yearInCollege + ", Money: " + money;
	}
}

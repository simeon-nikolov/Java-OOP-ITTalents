package humansworld;

public class Employee extends Person {
	private static final double OVERTIME_SALARY_COEFFICIENT = 1.5;
	private static final int WORKING_HOURS = 8;
	private static final int ADULT_AGE = 18;
	private static final double ZERO_SALARY = 0.0;
	
	private double daySalary;

	public Employee(String name, int age, boolean isMale, double daySalary) {
		super(name, age, isMale);
		this.setDaySalary(daySalary);
	}
	
	public double calculateOvertime(double hours) {
		if (this.getAge() < ADULT_AGE) {
			return ZERO_SALARY;
		}
		
		double salaryPerHour = this.daySalary / WORKING_HOURS;
		double overtimeSalary = salaryPerHour * hours * OVERTIME_SALARY_COEFFICIENT;
		
		return overtimeSalary;
	}
	
	public void showEmployeeInfo() {
		super.showPersonInfo();
		System.out.println("Daily salary: $" + this.daySalary);
	}

	public double getDaySalary() {
		return this.daySalary;
	}

	public void setDaySalary(double daySalary) {
		if (daySalary < ZERO_SALARY) {
			throw new IllegalArgumentException("Invalid parameter! Salary can't be negative value!");
		}
		
		this.daySalary = daySalary;
	}
	
	
}

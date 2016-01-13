package employee;

public class Company {

	public static void main(String[] args) {
		Employee spiro = new Employee("Spiro");
		Task homework = new Task("Do homework", 5040);
		spiro.setCurrentTask(homework);
		spiro.work();

	}

}

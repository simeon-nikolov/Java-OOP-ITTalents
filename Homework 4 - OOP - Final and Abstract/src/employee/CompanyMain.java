package employee;

public class CompanyMain {
	private static final int MAX_HOURS = 25;
	private static final int MIN_HOURS = 3;
	private static final int MIN_TASKS = 10;
	private static final int MAX_TASKS = 12;
	private static final int MIN_EMPLOYEES = 3;
	private static final int MAX_EMPLOYEES = 4;

	public static void main(String[] args) {
		AllWork allWork = new AllWork();
		int numberOfTasks = getRandomInteger(MIN_TASKS, MAX_TASKS);

		for (int taskCount = 0; taskCount < numberOfTasks; taskCount++) {
			int hours = (int) getRandomInteger(MIN_HOURS, MAX_HOURS);
			Task task = new Task("Task " + (taskCount + 1), hours);
			allWork.addTask(task);
		}

		int numberOfEmployees = (int) Math.random()
				* (MAX_EMPLOYEES - MIN_EMPLOYEES) + MIN_EMPLOYEES;
		Employee[] employees = new Employee[numberOfEmployees];
		String[] names = { "Claudio Rueckert", "Lawerence Patenaude",
				"Athena Christofferse", "Mirna Schubert",
				"Elizebeth Schaffner", "Shan Kondo", "Albertha Hao",
				"Carlo Rodriguz", "Madelene Sally", "Carlita Beecher",
				"Kaylene Kerney", "Adam Macaluso", "Hilde Zimmerman",
				"Ty Freeland", "Eva Culbert", "Gregorio Galliher", "Burma Lai",
				"Lyman Runnels", "Raymundo Marsden", "Valentine Mccoll" };

		for (int emp = 0; emp < employees.length; emp++) {
			int nameIndex = getRandomInteger(0, names.length - 1);
			employees[emp] = new Employee(names[nameIndex]);
			employees[emp].setAllWork(allWork);
		}

		int day = 1;

		while (!allWork.isAllWorkDone()) {
			boolean endDay = false;
			System.out.println("Day " + day + ":");

			for (Employee employee : employees) {
				employee.startWorkingDay();
			}

			while (!endDay) {
				for (Employee employee : employees) {
					employee.work();
				}

				if (allWork.isAllWorkDone()) {
					break;
				}

				endDay = true;

				for (Employee employee : employees) {
					if (employee.getHoursLeft() > 0
							&& employee.getCurrentTask() != null) {
						endDay = false;
						break;
					}
				}
			}

			System.out.println();
			day++;
		}
	}

	private static int getRandomInteger(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

}

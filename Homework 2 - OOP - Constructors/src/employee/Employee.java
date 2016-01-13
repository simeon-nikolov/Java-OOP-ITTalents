package employee;

public class Employee {
	private static final String TASK_IS_NULL_MESSAGE = "The task is null! No tasks are set to the employee! The employee is free to go for today, yay! ^_^";
	private static final int DEFAULT_HOURS_LEFT = 8;
	private static final String INVALID_HOURS_lEFT_MESSAGE = "Invalid number of working hours for the day! Set to dafault value!";
	private static final String INVALID_NAME_MESSAGE = "Invalid employee name! Name set to default!";
	private static final String DEFAULT_EMPLOYEE_NAME = "Employee Name";
	
	private String name;
	private Task currentTask;
	private int hoursLeft;
	
	public Employee(String name) {
		this.setName(name);
		this.setHoursLeft(DEFAULT_HOURS_LEFT);
	}
	
	public void work() {
		if (this.currentTask != null) {
			if (this.hoursLeft >= this.currentTask.getWorkingHours()) {
				this.hoursLeft -= this.currentTask.getWorkingHours();
				this.currentTask.setWorkingHours(Task.ZERO_HOURS);
			} else {
				int hours = this.currentTask.getWorkingHours() - this.hoursLeft;
				this.currentTask.setWorkingHours(hours);
				this.hoursLeft = Task.ZERO_HOURS;
			}
		}
		
		this.showReport();
	}
	
	public void showReport() {
		System.out.println("Name of employee: " + this.name);
		
		if (this.currentTask != null) {
			System.out.println("Task: " + this.currentTask.getTaskName());
		}
		
		System.out.println("Employee hours left for the day: " + this.hoursLeft);
		
		if (this.currentTask != null) {
			System.out.println("Current task hours left: " + this.currentTask.getWorkingHours());
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name != null && !name.equals("")) {
			this.name = name;
		} else {
			System.out.println(INVALID_NAME_MESSAGE);
			this.name = DEFAULT_EMPLOYEE_NAME;
		}
	}

	public int getHoursLeft() {
		return this.hoursLeft;
	}

	public void setHoursLeft(int hoursLeft) {
		if (hoursLeft > Task.ZERO_HOURS) {
			this.hoursLeft = hoursLeft;
		} else {
			System.out.println(INVALID_HOURS_lEFT_MESSAGE);
			this.hoursLeft = DEFAULT_HOURS_LEFT;
		}
	}

	public Task getCurrentTask() {
		return this.currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		if (currentTask != null) {
			this.currentTask = currentTask;
		} else {
			System.out.println(TASK_IS_NULL_MESSAGE);
		}
	}
}

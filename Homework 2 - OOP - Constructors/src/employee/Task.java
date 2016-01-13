package employee;

public class Task {
	private static final String INVALID_WORKING_HOURS_MESSAGE = "Invalid number of working hours!";
	private static final String INVALID_TASK_NAME_MESSAGE = "Invalid task name!";
	private static final int DEFAULT_WORKING_HOURS = 8;
	private static final String DEFAULT_TASK_NAME = "Task";
	public static final int ZERO_HOURS = 0;
	
	private static int tasksCount = 0;
	private String taskName;
	private int workingHours;
	
	private Task() {
		Task.tasksCount++;
		this.setTaskName(DEFAULT_TASK_NAME + Task.tasksCount);
		this.setWorkingHours(DEFAULT_WORKING_HOURS);
	}
	
	public Task(String taskName, int workingHours) {
		this();
		this.setTaskName(taskName);
		this.setWorkingHours(workingHours);
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public void setTaskName(String taskName) {
		if (taskName != null && !taskName.equals("")) {
			this.taskName = taskName;
		} else {
			System.out.println(INVALID_TASK_NAME_MESSAGE);
		}
	}
	
	public int getWorkingHours() {
		return this.workingHours;
	}
	
	public void setWorkingHours(int workingHours) {
		if (workingHours >= ZERO_HOURS) {
			this.workingHours = workingHours;
		} else {
			System.out.println(INVALID_WORKING_HOURS_MESSAGE);
		}
	}
}

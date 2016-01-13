package employee;

public class Task {
	private static final String INVALID_TASK_NAME = "Task name must be more than 3 letters!";
	private static final int MIN_TASK_NAME_LETTERS = 3;
	private static final String NULL_TASK_NAME_MESSAGE = "Task name is null!";
	private static final String INVALID_WORKING_HOURS_MESSAGE = "Invalid number of working hours!";
	private static final int DEFAULT_WORKING_HOURS = 8;
	private static final String DEFAULT_TASK_NAME = "Task";
	public static final int ZERO_HOURS = 0;
	
	private String taskName;
	private int workingHours;
	
	public Task(String taskName, int workingHours) {
		if (taskName == null) {
			throw new IllegalArgumentException(NULL_TASK_NAME_MESSAGE);
		}
		
		if (taskName.length() <= MIN_TASK_NAME_LETTERS) {
			throw new IllegalArgumentException(INVALID_TASK_NAME);
		}
		
		this.taskName = taskName;
		this.setWorkingHours(workingHours);
	}
	
	public String getTaskName() {
		return this.taskName;
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

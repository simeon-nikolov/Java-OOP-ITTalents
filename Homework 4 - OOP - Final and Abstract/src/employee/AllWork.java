package employee;

public class AllWork {
	private static final String TASK_IS_NULL_MESSAGE = "Task is null!";
	private static final String TASKS_IS_FULL_MESSAGE = "The list of tasks is full!";

	private static final int NUMBER_OF_TASKS = 12;
	
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignetTask;
	
	
	public AllWork() {
		this.tasks = new Task[NUMBER_OF_TASKS];
		this.freePlacesForTasks = NUMBER_OF_TASKS;
		this.currentUnassignetTask = 0;
	}
	
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException(TASK_IS_NULL_MESSAGE);
		}
		
		if (this.freePlacesForTasks == 0) {
			throw new ArrayIndexOutOfBoundsException(TASKS_IS_FULL_MESSAGE);
		}
		
		int index = this.tasks.length - this.freePlacesForTasks;
		this.tasks[index] = task;
		this.freePlacesForTasks--;
	}
	
	public Task getNextTask() {
		Task task = null;
		
		if (this.currentUnassignetTask < this.tasks.length) {
			task = this.tasks[this.currentUnassignetTask];
			this.currentUnassignetTask++;
		}
		
		return task;
	}
	
	public boolean isAllWorkDone() {
		for (Task task : this.tasks) {
			if (task != null && task.getWorkingHours() > 0) {
				return false;
			}
		}
		
		return true;
	}
}

package employee;

public class Employee {
	private static final String ALL_WORK_IS_NULL_MESSAGE = "The reference for all work tasks is null!";
	private static final int DEFAULT_WORKING_HOURS_LEFT = 8;
	private static final String NAME_IS_NULL_MESSAGE = "Employee name is null!";
	private static final String TASK_IS_NULL_MESSAGE = "The task is null!";
	private static final String INVALID_HOURS_lEFT_MESSAGE = "Invalid number of working hours for the day! Set to dafault value!";
	private static final String INVALID_NAME_MESSAGE = "Invalid employee name!";

	private String name;
	private Task currentTask;
	private int hoursLeft;
	private AllWork allWork;

	public Employee(String name) {
		this.setName(name);
		this.setHoursLeft(DEFAULT_WORKING_HOURS_LEFT);
	}

	public void startWorkingDay() {
		this.setHoursLeft(DEFAULT_WORKING_HOURS_LEFT);
		System.out.println("Employee " + this.name
				+ " starts the new working day with " + this.hoursLeft
				+ " working hours.");
	}

	public void work() {
		boolean endOfWorkingDay = false;

		while (!endOfWorkingDay) {
			if (this.currentTask != null) {
				if (this.hoursLeft >= this.currentTask.getWorkingHours()) {
					this.hoursLeft -= this.currentTask.getWorkingHours();
					this.currentTask.setWorkingHours(Task.ZERO_HOURS);
					System.out.println("Employee " + this.name
							+ " has finished the task: "
							+ this.currentTask.getTaskName());
					this.currentTask = null;
				} else {
					int hours = this.currentTask.getWorkingHours()
							- this.hoursLeft;
					this.currentTask.setWorkingHours(hours);
					this.hoursLeft = Task.ZERO_HOURS;
					endOfWorkingDay = true;
					System.out
							.println("Employee "
									+ this.name
									+ " finished their working hours for the day. They still need "
									+ this.currentTask.getWorkingHours()
									+ " hours to finish the task. Waiting for another day!");
				}
			} else {
				Task task = this.allWork.getNextTask();

				if (task == null) {
					endOfWorkingDay = true;
					System.out.println("There are no more tasks. Employee "
							+ this.name + " is going home to have a rest.");
				} else {
					this.setCurrentTask(task);
					System.out.println("Employee " + this.name
							+ " took a new task: "
							+ this.currentTask.getTaskName()
							+ " and it will take "
							+ this.currentTask.getWorkingHours()
							+ " hours to finish it.");
				}
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(NAME_IS_NULL_MESSAGE);
		}

		if (name.equals("")) {
			throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
		}

		this.name = name;
	}

	public int getHoursLeft() {
		return this.hoursLeft;
	}

	public void setHoursLeft(int hoursLeft) {
		if (hoursLeft > Task.ZERO_HOURS) {
			this.hoursLeft = hoursLeft;
		} else {
			throw new IllegalArgumentException(INVALID_HOURS_lEFT_MESSAGE);
		}
	}

	public AllWork getAllWork() {
		return this.allWork;
	}

	public void setAllWork(AllWork allWork) {
		if (allWork == null) {
			throw new IllegalArgumentException(ALL_WORK_IS_NULL_MESSAGE);
		}

		this.allWork = allWork;
	}

	public Task getCurrentTask() {
		return this.currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		if (currentTask != null) {
			this.currentTask = currentTask;
		} else {
			throw new IllegalArgumentException(TASK_IS_NULL_MESSAGE);
		}
	}
}

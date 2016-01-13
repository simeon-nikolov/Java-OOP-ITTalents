package computer;

public class Computer {
	private static final String NOT_ENOUGH_FREE_MEMORY = "Not enough free memory!";
	private static final String MEMORY_IS_INVALID_VALUE = "Memory is invalid value!";
	private static final String UNKNOWN_OPERATION_SYSTEM = "Unknown";
	private static final String DEFAULT_OPERATION_SYSTEM = "Win XP";
	private static final int MIN_FREE_MEMORY = 0;
	private static final int MIN_HARD_DISK_SPACE = 0;
	private static final int MIN_PRICE = 0;
	private static final int MIN_YEAR = 0;
	
	private int year;
	private double price;
	private boolean isNotebook;
	private double hardDiskMemory; // in GB
	private double freeMemory; // in MB
	private String operationSystem;

	public Computer() {
		this.isNotebook = false;
		this.operationSystem = DEFAULT_OPERATION_SYSTEM;
	}
	
	public Computer(int year, double price, double hardDiskMemory, double freeMemory) {
		this();
		this.setYear(year);
		this.setPrice(price);
		this.setHardDiskMemory(hardDiskMemory);
		this.setFreeMemory(freeMemory);
	}
	
	public Computer(int year, double price, boolean isNotebook, double hardDiskMemory, 
			double freeMemory, String operationSystem) {
		this(year, price, hardDiskMemory, freeMemory);
		this.isNotebook = isNotebook;
		this.setOperationSystem(operationSystem);
	}

	private void setOperationSystem(String operationSystem) {
		if (operationSystem != null) {
			this.operationSystem = operationSystem;
		} else {
			this.operationSystem = UNKNOWN_OPERATION_SYSTEM;
		}
	}

	private void setFreeMemory(double freeMemory) {
		if (freeMemory >= MIN_FREE_MEMORY) {
			this.freeMemory = freeMemory;
		}
	}

	private void setHardDiskMemory(double hardDiskMemory) {
		if (hardDiskMemory >= MIN_HARD_DISK_SPACE) {
			this.hardDiskMemory = hardDiskMemory;
		}
	}

	public void setPrice(double price) {
		if (price >= MIN_PRICE) {
			this.price = price;
		}
	}

	private void setYear(int year) {
		if (year >= MIN_YEAR) {
			this.year = year;
		}
	}

	public void changeOperationSystem(String newOperationSystem) {
		if (newOperationSystem != null) {
			this.operationSystem = newOperationSystem;
		}
	}

	public void useMemory(int memory) {
		if (memory < MIN_FREE_MEMORY) {
			System.out.println(MEMORY_IS_INVALID_VALUE);
			return;
		}

		if (memory > freeMemory) {
			System.out.println(NOT_ENOUGH_FREE_MEMORY);
			return;
		}

		this.freeMemory -= memory;
	}
	
	public int comparePrice(Computer otherComputer) {
		if (otherComputer == null) {
			//System.out.println("The parameter for other computer is null!");
			return -1; // Non-existing computer has no price at all and therefore it's less than the price of the current computer
		}
		
		if (this.price > otherComputer.price) {
			return -1;
		}
		
		if (this.price < otherComputer.price) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public String toString(){
		String notebookOrPc = (isNotebook) ? "Notebook" : "PC";
		String output = notebookOrPc + "\nYear: " + this.year + "\nPrice: $" + this.price + 
				"\nHard Disk: " + this.hardDiskMemory + " GB\nFree Memory: " + this.freeMemory + 
				" MB\nOperation System: " + this.operationSystem;

		return output;
	}
}

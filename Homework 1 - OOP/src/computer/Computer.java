package computer;
import java.util.Calendar;

public class Computer {
	private static final String DEFAULT_OPERATION_SYSTEM = "Unknown";
	private static final int MIN_FREE_MEMORY = 0;
	private static final int MIN_HARD_DISK_SPACE = 0;
	private static final int MIN_PRICE = 0;
	private static final int MIN_YEAR = 0;
	
	private int year;
	private int price;
	private boolean isNotebook;
	private float hardDiskMemory; // in GB
	private int freeMemory; // in MB
	private String operationSystem;

	public Computer() {
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.price = 1000;
		this.isNotebook = false;
		this.hardDiskMemory = 1024.0f;
		this.freeMemory = 8145;
		this.operationSystem = "Windows 10";
	}

	public Computer(int year, int price, boolean isNotebook,
			float hardDiskMemory, int freeMemory, String operatingSystem) {
		this();
		
		if (year > MIN_YEAR) {
			this.year = year;
		}
		
		if (price > MIN_PRICE) {
			this.price = price;
		}
		
		if (hardDiskMemory > MIN_HARD_DISK_SPACE) {
			this.hardDiskMemory = hardDiskMemory;
		}
		
		if (freeMemory > MIN_FREE_MEMORY) {
			this.freeMemory = freeMemory;
		}
		
		if (operatingSystem != null) {
			this.operationSystem = operatingSystem;
		} else {
			this.operationSystem = DEFAULT_OPERATION_SYSTEM;
		}
		
		this.isNotebook = isNotebook;
	}

	public void changeOperationSystem(String newOperationSystem) {
		if (newOperationSystem != null) {
			this.operationSystem = newOperationSystem;
		}
	}

	public void useMemory(int memory) {
		if (memory < MIN_FREE_MEMORY) {
			System.out.println("Memory is invalid value!");
			return;
		}

		if (memory > freeMemory) {
			System.out.println("Not enough free memory!");
			return;
		}

		this.freeMemory -= memory;
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

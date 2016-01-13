package computer;

public class ComputerDemo {

	public static void main(String[] args) {
		Computer pc = new Computer(2015, 1234, false, 1024.0f, 8145, "Windows 10"); 
		Computer laptop = new Computer(2015, 1000, true, 1024.0f, 4072, "Ubuntu 15.10");
		
		pc.useMemory(100);
		laptop.changeOperationSystem("Windows 8.1");
		
		System.out.println(pc.toString());
		System.out.println();
		System.out.println(laptop.toString());

	}

}

package computer;

public class ComputerDemo {

	public static void main(String[] args) {
		Computer pc1 = new Computer(2015, 2200, false, 2046.0f, 8145.0f, "Windows 10"); 
		Computer pc2 = new Computer(2015, 1400, false, 1024.0f, 4072.0f, "Windows 8.1"); 
		Computer pc3 = new Computer(2015, 950, false, 512.0f, 4072.0f, "Windows 7"); 
		Computer pc4 = new Computer(2015, 650, false, 512.0f, 3000.0f, "Windows XP"); 
		Computer laptop1 = new Computer(2015, 1000, true, 1024.0f, 4072, "Ubuntu 15.10");
		Computer laptop2 = new Computer(2015, 1000, true, 1024.0f, 4072, "Lubuntu 15.04");
		Computer laptop3 = new Computer(2015, 1000, true, 1024.0f, 4072, "Red Hat");
		Computer laptop4 = new Computer(2015, 1000, true, 1024.0f, 4072, "Kali Linux");
		
		if (pc2.comparePrice(laptop2) < 0) {
			System.out.println(pc2 + "\n\nis more expensive than:\n\n" + laptop2);
		} else {
			if (pc2.comparePrice(laptop2) > 0) {
				System.out.println(laptop2 + "\n\nis more expensive than:\n\n" + pc2);
			} else {
				System.out.println(pc2 + "\n\nand\n\n" + laptop2 + " cost the same price!");
			}
		}
		

	}

}

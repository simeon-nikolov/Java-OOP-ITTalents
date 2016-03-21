package court;

public abstract class Citizen extends Person implements IPerson {
	private int age;
	private String address;
	
	public Citizen(String name, String duty) {
		super(name, duty);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age is not valid!");
		}
		
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address is not valid!");
		}
		
		this.address = address;
	}
}

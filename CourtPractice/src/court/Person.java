package court;

public class Person implements IPerson {
	private String fullName;
	private String duty;
	
	public Person(String name, String duty) {
		this.setFullName(name);
		this.setDuty(duty);
	}
	
	@Override
	public String getFullName() {
		return fullName;
	}
	
	private void setFullName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name is null!");
		}
		
		this.fullName = name;
	}
	
	@Override
	public String getDuty() {
		return duty;
	}
	
	private void setDuty(String duty) {
		if (duty == null) {
			throw new IllegalArgumentException("Duty is null!");
		}
		
		this.duty = duty;
	}
}

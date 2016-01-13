package humansworld;

public class Person {
	private static final String AGE_IS_NEGATIVE_VALUE_MESSAGE = "Invalid parameter! Age is negative value!";
	private static final String NAME_IS_EMPTY_STRING_MESSAGE = "Invalid parameter! The name is an empty string!";
	private static final String NAME_IS_NULL_MESSAGE = "Invalid parameter! The name is null!";
	
	private String name;
	private int age;
	private boolean isMale;
	
	public Person(String name, int age, boolean isMale) {
		this.setName(name);
		this.setAge(age);
		this.setIsMale(isMale);
	}
	
	public void showPersonInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		String gender = this.isMale ? "Male" : "Female";
		System.out.println("Gender: " + gender);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(NAME_IS_NULL_MESSAGE);
		}
		
		if (name.equals("")) {
			throw new IllegalAccessError(NAME_IS_EMPTY_STRING_MESSAGE);
		}
		
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException(AGE_IS_NEGATIVE_VALUE_MESSAGE);
		}
		
		this.age = age;
	}
	
	public boolean isMale() {
		return this.isMale;
	}
	
	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}
}

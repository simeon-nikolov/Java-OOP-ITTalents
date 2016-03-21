package court;

public abstract class LegalEntity extends Person implements IPerson {
	private int yearsPractice;
	private int casesCount;
	
	public LegalEntity(String name, String duty) {
		super(name, duty);	
	}
	
	public int getYearsPractice() {
		return yearsPractice;
	}

	public void setYearsPractice(int yearsPractice) {
		if (yearsPractice < 0) {
			throw new IllegalArgumentException("Illegal years value!");
		}
		
		this.yearsPractice = yearsPractice;
	}

	public int getCasesCount() {
		return casesCount;
	}

	public void setCasesCount(int casesCount) {
		if (casesCount < 0) {
			throw new IllegalArgumentException("Illegal cases count!");
		}
		
		this.casesCount = casesCount;
	}
	
	public void increaseYearsPractice() {
		this.yearsPractice++;
	}

	public abstract void askQuestion(IPerson person);
	public abstract void takeNotes(String notes);
}

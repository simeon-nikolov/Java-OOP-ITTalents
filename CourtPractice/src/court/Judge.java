package court;

public class Judge extends LegalEntity {
	private static final int MIN_YEARS = 3;
	private static final int MAX_YEARS = 40;
	private static final String DUTY = "Judge";

	public Judge(String name) {
		super(name, DUTY);
	}
	
	public double chooseSentence() {
		return Math.random() * (MAX_YEARS - MIN_YEARS) + MIN_YEARS;
	}
	
	@Override
	public void askQuestion(IPerson person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void takeNotes(String notes) {
		// TODO Auto-generated method stub

	}

}

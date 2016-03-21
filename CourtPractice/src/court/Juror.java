package court;

public class Juror extends LegalEntity {
	private static final String DUTY = "Juror";

	public Juror(String name) {
		super(name, DUTY);
	}
	
	public boolean isGuilty() {
		return Math.random() > 0.5;
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

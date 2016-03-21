package court;

public class Lawyer extends LegalEntity {
	private static final String DUTY = "Lawyer";

	public Lawyer(String name) {
		super(name, DUTY);
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

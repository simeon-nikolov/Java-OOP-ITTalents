package court;

public class Defendant extends CaseParty {
	private static final String DUTY = "Defendant";

	public Defendant(String name) {
		super(name, DUTY);
	}
}

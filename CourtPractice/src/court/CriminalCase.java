package court;

public class CriminalCase extends Case {
	private Prosecutor prosecutor;
	
	public CriminalCase(Judge judge, Defendant defendant, Prosecutor prosecutor) {
		super(judge, defendant);
		this.setProsecutor(prosecutor);
	}

	public Prosecutor getProsecutor() {
		return prosecutor;
	}

	private void setProsecutor(Prosecutor prosecutor) {
		if (prosecutor == null) {
			throw new IllegalArgumentException("Prosecutor is null!");
		}
		
		this.prosecutor = prosecutor;
	}
	
}

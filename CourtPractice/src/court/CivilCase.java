package court;

public class CivilCase extends Case {
private Accuser accuser;
	
	public CivilCase(Judge judge, Defendant defendant, Accuser accuser) {
		super(judge, defendant);
		
		this.setAccuser(accuser);
	}

	public Accuser getAccuser() {
		return accuser;
	}

	private void setAccuser(Accuser accuser) {
		if (accuser == null) {
			throw new IllegalArgumentException("Accuser is null!");
		}
		
		this.accuser = accuser;
	}
}

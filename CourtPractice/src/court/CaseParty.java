package court;

import java.util.ArrayList;

public abstract class CaseParty extends Citizen {
	private ArrayList<Lawyer> lawyers;

	public CaseParty(String name, String duty) {
		super(name, duty);
		this.lawyers = new ArrayList<Lawyer>();
	}

	public ArrayList<Lawyer> getLawyers() {
		ArrayList<Lawyer> result = new ArrayList<Lawyer>();
		result.addAll(this.lawyers);
		return result;
	}
	
	public void addLawyer(Lawyer lawyer) {
		if (lawyer == null) {
			throw new IllegalArgumentException("Lawyeror is null!");
		}
		
		for (Lawyer existingLawyer : lawyers) {
			if (lawyer == existingLawyer) {
				throw new IllegalArgumentException("Lawyer already exists!");
			}
		}
		
		this.lawyers.add(lawyer);
	}
}

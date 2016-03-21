package court;

import java.util.ArrayList;

public abstract class Case {
	private static int count = 0;
	
	private int id;
	private Judge judge;
	private ArrayList<Juror> jury;
	private Defendant defendant;
	private ArrayList<Witness> witnesses;
	private Chronology chronology;
	
	public Case(Judge judge, Defendant defendant) {
		this.setJudge(judge);
		this.setDefendant(defendant);
		this.jury = new ArrayList<Juror>();
		this.witnesses = new ArrayList<Witness>();
		this.chronology = new Chronology();
		count++;
		this.id = count;
	}

	public Judge getJudge() {
		return judge;
	}

	private void setJudge(Judge judge) {
		this.judge = judge;
	}

	public ArrayList<Juror> getJury() {
		ArrayList<Juror> result = new ArrayList<Juror>();
		result.addAll(jury);
		return result;
	}
	
	public void addJuror(Juror juror) {
		if (juror == null) {
			throw new IllegalArgumentException("Juror is null!");
		}
		
		for (Juror existingJuror : jury) {
			if (juror == existingJuror) {
				throw new IllegalArgumentException("Juror already exists!");
			}
		}
		
		this.jury.add(juror);
	}

	public Defendant getDefendant() {
		return defendant;
	}

	private void setDefendant(Defendant defendant) {
		if (defendant == null) {
			throw new IllegalArgumentException("Defendant is null!");
		}
		
		this.defendant = defendant;
	}

	public ArrayList<Witness> getWitnesses() {
		ArrayList<Witness> result = new ArrayList<Witness>();
		result.addAll(witnesses);
		return result;
	}

	public void addWitness(Witness witness) {
		if (witness == null) {
			throw new IllegalArgumentException("Witness is null!");
		}
		
		for (Witness existingWitness : witnesses) {
			if (witness == existingWitness) {
				throw new IllegalArgumentException("Witness already exists!");
			}
		}
		
		this.witnesses.add(witness);
	}
	
	@Override
	public String toString() {
		return this.id + "";
	}

}

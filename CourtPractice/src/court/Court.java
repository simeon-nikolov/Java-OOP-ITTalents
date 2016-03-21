package court;

import java.util.ArrayList;

public class Court {
	private String name;
	private String address;
	private ArrayList<LegalEntity> legalEntities;
	private ArrayList<Case> cases;

	public Court(String name, String address) {
		this.legalEntities = new ArrayList<LegalEntity>();
		this.cases = new ArrayList<Case>();
		this.setName(name);
		this.setAddress(address);
	}

	public ArrayList<LegalEntity> getLegalEntities() {
		ArrayList<LegalEntity> result = new ArrayList<LegalEntity>();
		result.addAll(this.legalEntities);
		return result;
	}

	public void addLegalEntity(LegalEntity legalEntity) {
		if (legalEntity == null) {
			throw new IllegalArgumentException("Legal entity is null!");
		}
		
		for (LegalEntity existingLegalEntity : legalEntities) {
			if (legalEntity == existingLegalEntity) {
				throw new IllegalArgumentException("Legal entity already exists!");
			}
		}
		
		this.legalEntities.add(legalEntity);
	}

	public ArrayList<Case> getCases() {
		ArrayList<Case> result = new ArrayList<Case>();
		result.addAll(this.cases);
		return result;
	}

	public void addCase(Case legalCase) {
		if (legalCase == null) {
			throw new IllegalArgumentException("Case is null!");
		}
		
		for (Case existingCase : cases) {
			if (legalCase == existingCase) {
				throw new IllegalArgumentException("Case already exists!");
			}
		}
		
		this.cases.add(legalCase);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name is null!");
		}

		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address is null!");
		}

		this.address = address;
	}

	public void conductCases() {
		for (Case legalCase : cases) {
			Chronology chronology = new Chronology();
			
			// increase years practice
			for (LegalEntity entity : this.legalEntities) {
				entity.increaseYearsPractice();
				chronology.addParticipant(entity);
			}

			// lawyers ask questions
			if (legalCase instanceof CivilCase) {
				ArrayList<Lawyer> lawyers = ((CivilCase) legalCase).getAccuser().getLawyers();
				
				for (Lawyer lawyer : lawyers) {
					for (int question = 0; question < 3; question++) {
						lawyer.askQuestion(legalCase.getDefendant());
						chronology.addQuestion(lawyer.getFullName() + " asked " + legalCase.getDefendant().getFullName());
					}
					
					for (int question = 0; question < 2; question++) {
						for (Witness witness : legalCase.getWitnesses()) {
							lawyer.askQuestion(witness);
							chronology.addQuestion(lawyer.getFullName() + " asked " + witness.getFullName());
						}
					}
				}
			}
			
			if (legalCase instanceof CriminalCase) {
				Prosecutor prosecutor = ((CriminalCase) legalCase).getProsecutor();
				
				for (int question = 0; question < 5; question++) {
					prosecutor.askQuestion(legalCase.getDefendant());
					chronology.addQuestion(prosecutor.getFullName() + " asked " + legalCase.getDefendant().getFullName());
				}
				
				for (int question = 0; question < 5; question++) {
					for (Witness witness : legalCase.getWitnesses()) {
						prosecutor.askQuestion(witness);
						chronology.addQuestion(prosecutor.getFullName() + " asked " + witness.getFullName());
					}
				}
			}
			
			// defendant lawyers ask questions
			ArrayList<Lawyer> lawyers = legalCase.getDefendant().getLawyers();
			
			for (Lawyer lawyer : lawyers) {
				for (int question = 0; question < 5; question++) {
					for (Witness witness : legalCase.getWitnesses()) {
						lawyer.askQuestion(witness);
						chronology.addQuestion(lawyer.getFullName() + " asked " + witness.getFullName());
					}
				}
			}
			
			// jury make decision:
			int countGuilty = 0;
			
			for (Juror juror : legalCase.getJury()) {
				if (juror.isGuilty()) {
					countGuilty++;
				}
			}
			
			// is guilty?
			boolean isGuilty = countGuilty > (legalCase.getJury().size() / 2);
			chronology.setIsGuilty(isGuilty);
			double yearsSentence = 0.0;
			
			if (isGuilty) {
				yearsSentence = legalCase.getJudge().chooseSentence();
			}
			
			chronology.setYearsSentence(yearsSentence);
			chronology.saveToFile("Case" + legalCase.toString() + ".txt");
		}
	}
}

package court;

public class CourtDemo {

	public static void main(String[] args) {
		Court velikoTarnovoCourt = new Court("Veliko Tarnoco Court",
				"Veliko Tarnoco");
		Judge[] judges = new Judge[3];
		Juror[] jury = new Juror[13];
		Lawyer[] lawyers = new Lawyer[5];
		Prosecutor[] prosecutors = new Prosecutor[2];
		Accuser[] accusers = new Accuser[5];
		Defendant[] defendants = new Defendant[accusers.length];
		Witness[] witnesses = new Witness[2 * accusers.length];

		// add legal entities
		for (int i = 0; i < judges.length; i++) {
			judges[i] = new Judge("Jd" + i);
			velikoTarnovoCourt.addLegalEntity(judges[i]);
		}

		for (int i = 0; i < jury.length; i++) {
			jury[i] = new Juror("Jr" + i);
			velikoTarnovoCourt.addLegalEntity(jury[i]);
		}

		for (int i = 0; i < lawyers.length; i++) {
			lawyers[i] = new Lawyer("L" + i);
			velikoTarnovoCourt.addLegalEntity(lawyers[i]);
		}

		for (int i = 0; i < prosecutors.length; i++) {
			prosecutors[i] = new Prosecutor("P" + i);
			velikoTarnovoCourt.addLegalEntity(prosecutors[i]);
		}

		// add citizens

		for (int i = 0; i < accusers.length; i++) {
			accusers[i] = new Accuser("A" + i);
			defendants[i] = new Defendant("D" + i);
		}
		
		for (int w = 0; w < witnesses.length; w++) {
			witnesses[w] = new Witness("Wi" + w);
		}

		// make cases

		CivilCase[] civilCases = new CivilCase[3];
		CriminalCase[] criminalCases = new CriminalCase[3];

		for (int i = 0; i < civilCases.length; i++) {
			Judge judge = (Judge) getRadom(judges);
			Defendant defendant = (Defendant) getRadom(defendants);
			Accuser accuser = (Accuser) getRadom(accusers);
			civilCases[i] = new CivilCase(judge, defendant, accuser);

			for (int w = 0; w < 10; w++) {
				Witness witness = witnesses[w];
				civilCases[i].addWitness(witness);
			}

			for (int j = 0; j < 3; j++) {
				Juror juror = jury[j];
				civilCases[i].addJuror(juror);
			}
			
			velikoTarnovoCourt.addCase(civilCases[i]);
		}

		for (int i = 0; i < criminalCases.length; i++) {
			Judge judge = (Judge) getRadom(judges);
			Defendant defendant = (Defendant) getRadom(defendants);
			Prosecutor prosecutor = (Prosecutor) getRadom(prosecutors);
			criminalCases[i] = new CriminalCase(judge, defendant, prosecutor);

			for (int w = 0; w < 10; w++) {
				Witness witness = witnesses[w];
				criminalCases[i].addWitness(witness);
			}

			for (int j = 0; j < jury.length; j++) {
				criminalCases[i].addJuror(jury[j]);
			}
			
			velikoTarnovoCourt.addCase(criminalCases[i]);
		}
		
		velikoTarnovoCourt.conductCases();

		System.out.println("end");
	}

	public static IPerson getRadom(IPerson[] people) {
		int min = 0;
		int max = people.length - 1;
		int randIndex = (int) (Math.random() * (max - min) - min);

		return people[randIndex];
	}

}

package court;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Chronology {
	private ArrayList<IPerson> participants;
	private ArrayList<String> askedQuestions;
	private boolean isGuilty;
	private double yearsSentence;
	
	public Chronology() {
		this.participants = new ArrayList<IPerson>();
		this.askedQuestions = new ArrayList<String>();
	}

	public boolean getIsGuilty() {
		return isGuilty;
	}

	public void setIsGuilty(boolean isGuilty) {
		this.isGuilty = isGuilty;
	}

	public double getYearsSentence() {
		return yearsSentence;
	}

	public void setYearsSentence(double yearsSentence) {
		if (yearsSentence < 0.0) {
			throw new IllegalArgumentException("Years is invalid value!");
		}
		
		this.yearsSentence = yearsSentence;
	}
	
	public void addParticipant(IPerson participant) {
		this.participants.add(participant);
	}
	
	public void addQuestion(String question) {
		this.askedQuestions.add(question);
	}
	
	public void saveToFile(String filename) {
		String contents = this.toString();
		
		try {
			PrintWriter out = new PrintWriter(filename);
			out.println(contents);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (IPerson person : participants) {
			sb.append(person.getFullName() + " " + person.getDuty() + "\r\n");
		}
		
		sb.append("\r\n");
		
		for (String question : askedQuestions) {
			sb.append(question + "\r\n");
		}
		
		return sb.toString();
	}
}

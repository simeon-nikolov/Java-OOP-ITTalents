package gsm;

public class GSM {
	private static final String NUMBER_FIRST_DIGITS = "08";
	private static final int SIM_NUMBER_LENGHT = 10;
	private static final String DEFAULT_MODEL = "Unknown";
	
	private String model;
	private boolean hasSimCard;
	private String simMobileNumber;
	private float outgoingCallsDuration;
	private Call lastIncomingCall;
	private Call lastOutgoingCall;
	
	public GSM() {
		this.model = DEFAULT_MODEL;
	}
	
	public GSM(String model, String simMobileNumber) {
		this();
		
		if (model != null) {
			this.model = model;
		}
		
		this.insertSimCard(simMobileNumber);
	}
	
	public void insertSimCard(String simMobileNumber) {
		if (simMobileNumber == null) {
			System.out.println("The SIM Mobile Number is Null!");
			return;
		}
		
		if (simMobileNumber.length() != SIM_NUMBER_LENGHT) {
			System.out.println("The mobile number must be 10 digits!");
			return;
		}
		
		if (!simMobileNumber.startsWith(NUMBER_FIRST_DIGITS)) {
			System.out.println("The mobile number must start with \"08\"!");
			return;
		}
		
		this.simMobileNumber = simMobileNumber;
		this.hasSimCard = true;
	}
	
	public void removeSimCard() {
		this.simMobileNumber = null;
		this.hasSimCard = false;
	}
	
	public void call(GSM receiver, float duration) {
		if (receiver == null) {
			System.out.println("Receiver is null!");
			return;
		}
		
		if (duration < 0.0f) {
			System.out.println("Invalid call duration!");
			return;
		}
		
		if (this.equals(receiver)) {
			System.out.println("Invalid receiver! The receiver is the same as caller!");
			return;
		}
		
		if (!this.hasSimCard || !receiver.hasSimCard) {
			System.out.println("The receiver or the caller or both don't have a sim card!");
			return;
		}
		
		Call call = new Call(this, receiver, duration);
		this.lastOutgoingCall = call;
		receiver.setLastIncomingCall(call);
		this.outgoingCallsDuration += duration;
	}
	
	public void setLastIncomingCall(Call call) {
		if (call == null) {
			System.out.println("Call is null!");
			return;
		}
		
		this.lastIncomingCall = call;
	}
	
	public float getSumForCall() {
		float sum = ((int) this.outgoingCallsDuration) * Call.priceForAMinute;
		
		return sum;
	}
	
	public void printInfoForTheLastOutgoingCall() {
		if (this.lastOutgoingCall != null) {
			System.out.println(this.lastOutgoingCall.toString());
		} else {
			System.out.println("There's no last outgoing call!");
		}
	}
	
	public void printInfoForTheLastIncomingCall() {
		if (this.lastIncomingCall != null) {
			System.out.println(this.lastIncomingCall.toString());
		} else {
			System.out.println("There's no last incoming call!");
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (other.getClass() != this.getClass()) {
			return false;
		}
		
		GSM otherGSM = (GSM) other;
		boolean result = false;
		
		if (this.simMobileNumber != null && otherGSM.simMobileNumber != null) {
			result = this.simMobileNumber.equals(otherGSM.simMobileNumber);
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		String output = "";
		
		if (this.hasSimCard) {
			output = this.simMobileNumber + " - " + this.model;
		}
		
		return output;
	}
}

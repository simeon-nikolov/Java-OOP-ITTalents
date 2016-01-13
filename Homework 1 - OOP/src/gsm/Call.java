package gsm;

public class Call {
	private static final float MIN_DURATION = 0.0f;

	public static float priceForAMinute = 0.5f;
	
	private GSM caller;
	private GSM receiver;
	private float duration;
	
	public Call(GSM caller, GSM receiver, float duration) {
		if (caller != null) {
			this.caller = caller;
		} else {
			System.out.println("Caller is null!");
		}
		
		if (receiver != null) {
			this.receiver = receiver;
		} else {
			System.out.println("Receiver is null!");
		}
		
		if (duration > MIN_DURATION) {
			this.duration = duration;
		}
	}
	
	@Override
	public String toString() {
		String output = "Caller: ";
		
		if (this.caller != null) {
			 output += this.caller.toString();
		} 
		
		output += "\nReceiver: ";
		
		if (this.receiver != null) {
			output +=  this.receiver.toString();
		}
				 
		output += "\nDuration: " + this.duration + " minutes";
		
		return output;
	}
}

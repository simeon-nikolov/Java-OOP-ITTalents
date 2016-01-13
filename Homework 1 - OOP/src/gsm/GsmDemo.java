package gsm;

public class GsmDemo {

	public static void main(String[] args) {
		GSM nokia3210 = new GSM("Nokia 3210", "0876123456");
		GSM sonyXperiaZ3 = new GSM("Sony Xperia Z3", "0888654321");
		
		nokia3210.call(sonyXperiaZ3, 3.40f);
		nokia3210.printInfoForTheLastOutgoingCall();
		System.out.println();
		sonyXperiaZ3.printInfoForTheLastIncomingCall();
		System.out.println();
		System.out.println("Please pay me: $" + nokia3210.getSumForCall());
		System.out.println("Please pay me: $" + sonyXperiaZ3.getSumForCall());
		nokia3210.removeSimCard();
		sonyXperiaZ3.removeSimCard();
		nokia3210.insertSimCard("0888654321");
		sonyXperiaZ3.insertSimCard("0876123456");
		System.out.println();
		sonyXperiaZ3.insertSimCard(null);
		sonyXperiaZ3.insertSimCard("08761234564376587");
		sonyXperiaZ3.insertSimCard("1087612345");
		System.out.println();
		nokia3210.call(nokia3210, 5.0f);
		System.out.println();
		nokia3210.removeSimCard();
		sonyXperiaZ3.removeSimCard();
		nokia3210.call(sonyXperiaZ3, 5.0f);
	}

}

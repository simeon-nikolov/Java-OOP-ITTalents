package notepad;

public class NotepadDemo {
	public static void main(String[] args) {
		String title = "Lorem ipsum";
		String text = "Lorem ipsum dolor sit amet, consectetur " + Page.NEW_LINE
				+ "adipiscing elit. Nunc faucibus lacinia sapien quis tempus. " + Page.NEW_LINE
				+ "Etiam vel fringilla purus. Quisque hendrerit cursus lacus id " + Page.NEW_LINE
				+ "interdum. Maecenas fringilla nunc velit, placerat blandit ex " + Page.NEW_LINE
				+ "mollis sed. Vestibulum ultricies orci quis nibh lacinia, ut " + Page.NEW_LINE
				+ "condimentum mi finibus. Sed in ex eget velit ornare malesuada. " + Page.NEW_LINE
				+ "Praesent in blandit erat. Ut euismod, metus eget malesuada bibendum, " + Page.NEW_LINE
				+ "augue massa placerat nisi, nec ornare est leo non libero. In hac " + Page.NEW_LINE
				+ "habitasse platea dictumst. Nunc in malesuada tellus. Sed dictum mauris " + Page.NEW_LINE
				+ "sapien, sit amet scelerisque magna egestas ut. Morbi non sapien risus. " + Page.NEW_LINE
				+ "Vestibulum nec efficitur sem. Proin libero tellus, tincidunt nec lacinia "  + Page.NEW_LINE
				+ "id, sodales id nibh.";

		// Page testing:
		
		System.out.println("--- Testing Page ---");
		
		Page pageTest = new Page();
		pageTest.changeTitle(title);
		pageTest.addText(text);
		System.out.println(pageTest.viewPage());
		pageTest.deleteText();
		pageTest.changeTitle("");
		System.out.println(pageTest.viewPage());
		
		// SimpleNotepad testing:
		
		System.out.println("--- Testing SimpleNotepad ---");

		INotepad theVampireDieries = new SimpleNotepad();
		System.out.println("Add text to first page: ");
		theVampireDieries.rewritePage(0, "Hello");
		theVampireDieries.printAllPages();
		System.out.println("Rewrite the first page and add text to the second page: ");
		theVampireDieries.rewritePage(0, text);
		theVampireDieries.appendText(1, text);
		theVampireDieries.appendText(1, text);
		theVampireDieries.printAllPages();
		System.out.println("Delete the second page: ");
		theVampireDieries.deleteText(1);
		theVampireDieries.printAllPages();
		
		// SecuredNotepad testing:
		
		System.out.println("--- Testing SecuredNotepad ---");
		String password = "1a2s3D";
		
		ISecuredNotepad thePentagonDocuments = new SecuredNotepad(password);
		thePentagonDocuments.appendText(password, 0, text);
		thePentagonDocuments.appendText(1, text);
		thePentagonDocuments.printAllPages();
		thePentagonDocuments.printAllPages(password);
		thePentagonDocuments.deleteText(password, 0);
		thePentagonDocuments.printAllPages(password);
		
		// ElectronicSecuredNotepad testing:
		
		System.out.println("--- Testing ElectronicSecuredNotepad ---");
		
		ElectronicSecuredNotepad kindle = new ElectronicSecuredNotepad(password);
		kindle.appendText(password, 0, text + " 12344");
		kindle.printAllPagesWithDigits(password);
		kindle.start();
		kindle.appendText(password, 0, text + " 12344");
		kindle.printAllPagesWithDigits(password);
		System.out.println("Find amet: " + kindle.searchWord(password, "amet"));
		System.out.println("Find hello: " + kindle.searchWord(password, "hello"));
		System.out.println("Stopping device..");
		kindle.stop();
		System.out.println("Find ipsum: " + kindle.searchWord(password, "ipsum"));
	}
}

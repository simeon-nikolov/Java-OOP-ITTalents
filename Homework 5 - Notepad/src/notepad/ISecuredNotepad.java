package notepad;

public interface ISecuredNotepad extends INotepad {
	void appendText(String password, int pageNumber, String text);
	void rewritePage(String password, int pageNumber, String text);
	void deleteText(String password, int pageNumber);
	void printAllPages(String password);
	boolean searchWord(String password, String word);
	void printAllPagesWithDigits(String password);
}

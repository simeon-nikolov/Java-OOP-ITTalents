package notepad;

public interface INotepad {
	void appendText(int pageNumber, String text);
	void rewritePage(int pageNumber, String text);
	void deleteText(int pageNumber);
	void printAllPages();
	boolean searchWord(String word);
	void printAllPagesWithDigits();
}

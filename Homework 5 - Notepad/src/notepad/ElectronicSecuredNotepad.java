package notepad;

public class ElectronicSecuredNotepad extends SecuredNotepad implements
		IElectronicDevice {
	private boolean isStarted;
	
	public ElectronicSecuredNotepad(String password) {
		super(password);
		this.isStarted = false;
	}
	
	@Override
	public void start() {
		this.isStarted = true;
	}

	@Override
	public void stop() {
		this.isStarted = false;
	}

	@Override
	public boolean isStarted() {
		return this.isStarted;
	}
	
	@Override
	public void appendText(String password, int pageNumber, String text) {
		if (this.isStarted()) {
			super.appendText(password, pageNumber, text);
		}
	}

	@Override
	public void rewritePage(String password, int pageNumber, String text) {
		if (this.isStarted()) {
			super.rewritePage(password, pageNumber, text);
		}
	}

	@Override
	public void deleteText(String password, int pageNumber) {
		if (this.isStarted()) {
			super.deleteText(password, pageNumber);
		}
	}

	@Override
	public void printAllPages(String password) {
		if (this.isStarted()) {
			super.printAllPages(password);
		}
	}
	
	@Override
	public boolean searchWord(String password, String word) {
		if (this.isStarted()) {
			return super.searchWord(password, word);
		}

		return false;
	}

	@Override
	public void printAllPagesWithDigits(String password) {
		if (this.isStarted()) {
			super.printAllPagesWithDigits(password);
		}
	}
}

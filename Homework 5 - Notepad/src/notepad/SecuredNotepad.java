package notepad;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad {
	private static final String PASSWORD_IS_NULL_MESSAGE = "Password is null!";
	private static final String WEAK_PASSWORD_MESSAGE = "The password is not strong enough! "
			+ "It should be at least 5 symbols including at least one digit, one small letter "
			+ "and one big letter!";
	private static final int MIN_PASSWORD_LENGTH = 5;

	private String password;
	private boolean isPaswordEnetered;

	public SecuredNotepad(String password) {
		if (!this.validatePassword(password)) {
			throw new IllegalArgumentException(WEAK_PASSWORD_MESSAGE);
		}

		this.password = password;
		this.isPaswordEnetered = false;
	}

	private boolean validatePassword(String password) {
		boolean isValid = this.validateString(password);

		if (isValid) {
			boolean hasDigit = false;
			boolean hasSmallLetter = false;
			boolean hasBigLetter = false;

			for (char c : password.toCharArray()) {
				if ('0' <= c && c <= '9') {
					hasDigit = true;
				}

				if ('a' <= c && c <= 'z') {
					hasSmallLetter = true;
				}

				if ('A' <= c && c <= 'Z') {
					hasBigLetter = true;
				}
			}
			
			isValid = password.length() >= MIN_PASSWORD_LENGTH;
			isValid = isValid && hasDigit && hasSmallLetter && hasBigLetter;
		} else {
			throw new IllegalArgumentException(PASSWORD_IS_NULL_MESSAGE);
		}

		return isValid;
	}

	@Override
	public void appendText(String password, int pageNumber, String text) {
		if (this.checkPassword(password)) {
			this.appendText(pageNumber, text);
		}
	}

	@Override
	public void rewritePage(String password, int pageNumber, String text) {
		if (this.checkPassword(password)) {
			this.rewritePage(pageNumber, text);
		}
	}

	@Override
	public void deleteText(String password, int pageNumber) {
		if (this.checkPassword(password)) {
			this.deleteText(pageNumber);
		}

	}

	@Override
	public void printAllPages(String password) {
		if (this.checkPassword(password)) {
			this.printAllPages();
		}

	}

	@Override
	public void appendText(int pageNumber, String text) {
		if (this.isPasswordEntered()) {
			super.appendText(pageNumber, text);
		}
	}

	@Override
	public void rewritePage(int pageNumber, String text) {
		if (this.isPasswordEntered()) {
			super.rewritePage(pageNumber, text);
		}
	}

	@Override
	public void deleteText(int pageNumber) {
		if (this.isPasswordEntered()) {
			super.deleteText(pageNumber);
		}
	}

	@Override
	public void printAllPages() {
		if (this.isPasswordEntered()) {
			super.printAllPages();
		}
	}

	private boolean isPasswordEntered() {
		boolean result = this.isPaswordEnetered;

		if (this.isPaswordEnetered) {
			this.isPaswordEnetered = false;
		}

		return result;
	}

	private boolean checkPassword(String password) {
		boolean isPasswordValid = this.password.equals(password);
		this.isPaswordEnetered = isPasswordValid;
		return isPasswordValid;
	}

	@Override
	public boolean searchWord(String password, String word) {
		if (this.checkPassword(password)) {
			return this.searchWord(word);
		}

		return false;
	}

	@Override
	public void printAllPagesWithDigits(String password) {
		if (this.checkPassword(password)) {
			this.printAllPagesWithDigits();
		}
	}
	
	@Override
	public boolean searchWord(String word) {
		if (this.isPasswordEntered()) {
			return super.searchWord(word);
		}
		
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		if (this.isPasswordEntered()) {
			super.printAllPagesWithDigits();
		}
	}

}

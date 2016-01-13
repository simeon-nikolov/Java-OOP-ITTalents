package notepad;

public class Page {
	public static final String NEW_LINE = "\n";
	private static final char[] TRIM_CHARS = new char[] { ',', '.', '!', '?',
			'\'', '"', '\n', '\t', '\\', '-', ':', ';', '(', ')' };

	private String title;
	private String text;

	public Page() {
		this.title = new String();
		this.text = new String();
	}

	public void changeTitle(String title) {
		if (this.validateString(title)) {
			this.title = title;
		}
	}

	public void addText(String text) {
		if (text != null) {
			this.text += text;
		}
	}

	public void deleteText() {
		this.text = new String();
	}

	public String viewPage() {
		String page = this.title + NEW_LINE + this.text;

		return page;
	}

	public boolean searchWord(String word) {
		if (this.validateString(word)) {
			String text = this.title + " " + this.text;
			String[] words = text.split(" ");

			for (String wordFromText : words) {
				this.trimWord(wordFromText, TRIM_CHARS);

				if (word.equalsIgnoreCase(wordFromText)) {
					return true;
				}
			}
		}

		return false;
	}
	
	public boolean containsDigits() {
		String text = this.title + " " + this.text;
		
		for (char c : text.toCharArray()) {
			if ('0' <= c && c <= '9') {
				return true;
			}
		}
		
		return false;
	}

	private boolean validateString(String text) {
		return text != null;
	}

	private void trimWord(String word, char[] chars) {
		if (this.validateString(word)) {
			boolean isTrimed = true;
		
			while (isTrimed) {
				isTrimed = false;
				
				for (char c : chars) {
					if (word.startsWith(c + "")) {
						word = word.substring(1);
						isTrimed = true;
					}

					if (word.endsWith(c + "")) {
						word = word.substring(0, word.length() - 1);
						isTrimed = true;
					}
				}
			}
		}
	}
}

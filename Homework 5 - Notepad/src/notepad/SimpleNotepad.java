package notepad;

import java.util.ArrayList;

public class SimpleNotepad implements INotepad {
	private int PAGES_COUNT = 100;

	private ArrayList<Page> pages;

	public SimpleNotepad() {
		this.pages = new ArrayList<Page>();

		for (int pageIndex = 0; pageIndex < PAGES_COUNT; pageIndex++) {
			Page page = new Page();
			this.pages.add(page);
		}
	}

	@Override
	public void appendText(int pageNumber, String text) {
		if (this.validatePageNumber(pageNumber) && this.validateString(text)) {
			this.pages.get(pageNumber).addText(text);
		}
	}

	@Override
	public void rewritePage(int pageNumber, String text) {
		if (this.validatePageNumber(pageNumber) && this.validateString(text)) {
			this.pages.get(pageNumber).deleteText();
			this.pages.get(pageNumber).addText(text);
		}
	}

	@Override
	public void deleteText(int pageNumber) {
		if (this.validatePageNumber(pageNumber)) {
			this.pages.get(pageNumber).deleteText();
		}

	}

	@Override
	public boolean searchWord(String word) {
		if (this.validateString(word)) {
			for (Page page : this.pages) {
				if (page.searchWord(word)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int pageIndex = 0; pageIndex < this.pages.size(); pageIndex++) {
			Page page = this.pages.get(pageIndex);

			if (page.containsDigits()) {
				this.printPage(pageIndex, page);
			}
		}
	}

	@Override
	public void printAllPages() {
		for (int pageIndex = 0; pageIndex < this.pages.size(); pageIndex++) {
			Page page = this.pages.get(pageIndex);

			this.printPage(pageIndex, page);
		}
	}

	private void printPage(int pageIndex, Page page) {
		if (!page.viewPage().equals(Page.NEW_LINE)
				&& !page.viewPage().equals("")) {
			System.out.println("Page " + (pageIndex + 1));
			System.out.println(page.viewPage());
			System.out.println(Page.NEW_LINE);
		}
	}

	protected boolean validatePageNumber(int pageNumber) {
		return (0 <= pageNumber) && (pageNumber < pages.size());
	}

	protected boolean validateString(String text) {
		return text != null;
	}
}

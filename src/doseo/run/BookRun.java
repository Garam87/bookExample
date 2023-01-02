package doseo.run;

import doseo.model.service.BookService;

public class BookRun {

	public static void main(String[] args) {

		BookService service = new BookService();
		
		service.displayMenu();
	}

}

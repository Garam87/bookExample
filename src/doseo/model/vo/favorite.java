package doseo.model.vo;

public class favorite extends Book {

	private String favorites;    // 즐겨찾기
	
	
	public favorite() {
		
	}

	public favorite(int bookId, String bookName, String author) {
		super.setBookId(bookId);
		super.setBookName(bookName);
		super.setAuthor(author);
		
	}

	public favorite(int bookId, String bookName, String author, String favorites) {
		super(bookId, bookName, author);
		this.favorites = favorites;
	}



	public String getFavorites() {
		return favorites;
	}

	public void setFavorites(String favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "도서등록번호 = " + super.getBookId() + ", 도서명 = " + super.getBookName() + ", 저자 = "  + super.getAuthor() + "\n";
	}

	

	
	
	
	
	
	
	
}

package doseo.model.vo;

public class Book {

	// Field
	private int bookId;          // 도서번호
	private String bookName;     // 도서명
	private String author;		 // 지은이
	private int price;           // 가격
	private String publisher;    // 출판사
	
	
	
	
	// Constructor
	public Book() {}
	
	public Book(int bookId, String bookName, String author) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}
	
	
	public Book(int bookId, String bookName, String author, int price, String publisher) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}



	// Method
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	

	@Override
	public String toString() {
		return "도서번호 = " + bookId + ", 도서명 = " + bookName + ", 저자 = " + author + ", 가격 = " + price
				+ "원, 출판사 = " + publisher;
	}
	
	
	

	
	

	
	
	
}

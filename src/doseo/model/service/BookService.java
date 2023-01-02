package doseo.model.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import doseo.model.vo.Book;
import doseo.model.vo.favorite;

public class BookService {

	private Scanner sc = new Scanner(System.in);
	private List<Book> book = new ArrayList<Book>();
	private List<favorite> favor = new ArrayList<favorite>();
	public static int count = 0;
	
	
	// 메뉴
	public void displayMenu() {
		int inputNum = 0;
		do {
			System.out.println("===== 도서 목록 프로그램 =====");
			System.out.println("1. 등록 ");
			System.out.println("2. 조회 ");
			System.out.println("3. 수정 ");
			System.out.println("4. 삭제 ");
			System.out.println("5. 즐겨찾기 ");
			System.out.println("0. 프로그램종료 ");
			
			try {
				System.out.print("메뉴입력 >>> ");
				inputNum = sc.nextInt();
				
				switch(inputNum) {
				case 1 : System.out.println(create()); break;
				case 2 : read(); break;
				case 3 : update(); break;
				case 4 : delete(); break;
				case 5 : favorites(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("위의 메뉴중에서 입력하세요");	
				}
			} catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
				inputNum = -1;
			}
		} while(inputNum != 0);
	}
	
	
	// 등록/조회/수정/삭제 메서드
	public String create() throws Exception {
		System.out.println("\n===== 도서등록 ======");
		System.out.print("1. 도서번호 : ");
		int num = sc.nextInt();
		System.out.print("2. 도서명 : ");
		String bookName = sc.next();
		System.out.print("3. 저자 : ");
		String author = sc.next();
		System.out.print("4. 가격 : ");
		int price = sc.nextInt();
		System.out.print("5. 출판사 : ");
		String publisher = sc.next();
		
		book.add(new Book(num, bookName, author, price, publisher));
		return "@@ 등록이 완료되었습니다 @@";
	}
	
	public void read() throws Exception {
		System.out.println("\n===== 도서목록 =====");
		if(book.isEmpty()) {
			System.out.println("\n!! 등록된 책이 없습니다 !!\n");
		} else {
			for (Book bk : book) {
				System.out.println(bk);
			}
		}
	}
			
	public void update() throws Exception {
	
		System.out.println("===== 도서수정 =====");
		if(book.isEmpty()) {
			System.out.println("\n!! 등록된 책이 하나도 없습니다 !!\n");
		} else {
			System.out.print("수정할 책이름 : ");
			String bookName = sc.next();
			for (Book bk : book) {
				if(bookName.equals(bk.getBookName())) {
					System.out.print("책이름 : ");
					String bookName2 = sc.next();
					bk.setBookName(bookName2);
					
					System.out.print("저자 : ");
					String author = sc.next();
					bk.setAuthor(author);
					
					System.out.print("가격 : ");
					int price = sc.nextInt();
					bk.setPrice(price);
					
					System.out.print("출판사 : ");
					String publisher = sc.next();
					bk.setPublisher(publisher);
					
					System.out.println("\n@@ 정상적으로 수정이 완료되었습니다. @@\n");
				
				} else {
					System.out.println("\n!! 찾으시는 책이 없습니다. !!\n");
				}
			} 
		}
	}		
			
	public void delete() throws Exception {
			
		System.out.println("\n===== 도서목록 삭제 =====");
		
		if(book.isEmpty()) {
			System.out.println("!! 등록된 책이 하나도 없습니다 !!");
		} else {
			System.out.print("삭제할 도서제목 : ");
			String name = sc.next();
			
			for (int i = 0; i < book.size(); i++) {
				if(name.equals(book.get(i).getBookName())) {
					
					System.out.print(book.get(i).getBookName() + "의 도서정보를 삭제 하시겠습니까? (y/n) : ");
					char input = sc.next().toUpperCase().charAt(0);
					
					if(input == 'Y') {
						Book temp = book.remove(i);
						break;
					} else if(input == 'N') {
						System.out.println("취소");
						break;
					}
				}
			}
		}
	}			
			
	public void favorites() throws Exception {
		if(book.isEmpty()) {
			System.out.println("책 등록 먼저 해주세요");
		} else {
			read();
			System.out.println("\n===== 즐겨찾기 =====");
			System.out.print("즐겨찾기 할 책 이름 : ");
			String bookName = sc.next();
			
			for(int i = 0; i < book.size(); i++) {
				if(bookName.equals(book.get(i).getBookName())) {
					int bookNum = count++;
					String title = book.get(i).getBookName();
					String author = book.get(i).getAuthor();
					
					if(favor.add(new favorite(bookNum, title, author))) {
						System.out.println(title + "의 도서가 즐겨찾기에 추가되었습니다.");
					}
					break;
				} else {
					System.out.println("입력된 정보가 없습니다.");
				}
			}
		}
					
	}
			
			

	public void text() {
	
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("favorites.txt");
			
			for (favorite fv : favor) {
				String str = fv.toString();
				fw.write(str);
			}
			
		} catch(IOException e) {
			System.out.println("파일을 읽어올수 없습니다.");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
					
					
				
	
	
		
	}
			
	
	
	
	
	
	
}

package edu.kh.book.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Book2 {

	private List<Map<String, Object>> book = new ArrayList<Map<String, Object>>();
	private Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		int inputNum = 0;
		do {
			System.out.println("===== 도서 목록 프로그램 =====");
			System.out.println("1. 등록 ");
			System.out.println("2. 조회 ");
			System.out.println("3. 수정 ");
			System.out.println("4. 삭제 ");
			System.out.println("5. 즐겨찾기 ");
			System.out.println("6. 즐겨찾기 삭제 ");
			System.out.println("0. 프로그램종료 ");
			
			try {
				System.out.print("메뉴입력 >>> ");
				inputNum = sc.nextInt();
				
				switch(inputNum) {
				case 1 : create(); break;
				case 2 : read(); break;
				case 3 : update(); break;
				case 4 :  break;
				case 5 :  break;
				case 6 :  break;
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
	
	public void create() {
		System.out.println("===== 등록 =====");
		System.out.print("도서명 : ");
		String bookName = sc.next();
		
		System.out.print("저자 : ");
		String author = sc.next();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("출판사 : ");
		String publisher = sc.next();
		
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("도서명", bookName);
		map.put("저자", author);
		map.put("가격", price);
		map.put("출판사", publisher);
		
		book.add(map);
	}

	public void read() {
		System.out.println("===== 조회 =====");
		if(book.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
		} else {
			for (Map<String, Object> map : book) {
				System.out.println(map);
			}
		}
	}
	
	public void update() {
		System.out.println("===== 수정 =====");
		if(book.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
		} else {
			System.out.print("바꾸실 책이름 : ");
			String name = sc.next();
			
			for (int i = 0; i < book.size(); i++) {
				if(name.equals(book.get(i).get("도서명"))) {
					System.out.print("도서명 : ");
					String bookName = sc.next();
					System.out.print("저자 : ");
					String author = sc.next();
					System.out.print("가격 : ");
					int price = sc.nextInt();
					System.out.print("출판사 : ");
					String publisher = sc.next();
					
					Map<String, Object> map = new TreeMap<String, Object>();
					map.put("도서명", bookName);
					map.put("저자", author);
					map.put("가격", price);
					map.put("출판사", publisher);
					
					Map<String, Object> temp = book.set(i, map);
					System.out.println("변경완료");
					
				} 
					
			}
		}
	}

	public void delete() {
		System.out.println("===== 삭제 =====");
		if(book.isEmpty()) {
			System.out.println("등록된 책이 없습니다.");
		} else {
			
		}
	}
				
			
		
		
		
	
	
}

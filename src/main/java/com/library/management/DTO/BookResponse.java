package com.library.management.DTO;

public class BookResponse {

	Long id;
	String bookName;
	String author;
	Long price;
	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public BookResponse(Long id, String bookName, String author, Long price, String status) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.status = status;
	}

	public BookResponse() {
		super();
	}

}

package com.library.management.DTO;

import org.antlr.v4.runtime.misc.NotNull;

public class CreateBookRequest {

	Long id;

	@SuppressWarnings("deprecation")
	@NotNull
	String bookName;

	@SuppressWarnings("deprecation")
	@NotNull
	String author;

	@NotNull
	Long price;

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

	public CreateBookRequest() {
		super();
	}

	public CreateBookRequest(Long id, String bookName, String author, Long price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}

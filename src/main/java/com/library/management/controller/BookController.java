package com.library.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.DTO.BookResponse;
import com.library.management.DTO.CreateBookRequest;
import com.library.management.DTO.UpdateBookRequest;
import com.library.management.model.Book;
import com.library.management.service.BookNotFoundException;
import com.library.management.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;
	private final Logger logger = LoggerFactory.getLogger(BookController.class);

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/getById/{id}")
	public BookResponse fetchBookById(@PathVariable Long id) {
		logger.debug("Inside fetchBookById:", id);
		return bookService.getBooksById(id);
	}

	@GetMapping("/getAll")
	public List<Book> FetchAllBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping
	public ResponseEntity<BookResponse> createBook(@Validated @RequestBody CreateBookRequest request) {
		BookResponse response = bookService.createBook(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookResponse> updateBook(@PathVariable Long id,
			@Validated @RequestBody UpdateBookRequest request) {
		BookResponse response = bookService.updateBook(id,request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) throws BookNotFoundException {
		System.out.printf("Inside deleteBook: %d%n", id);
		boolean deleted = bookService.removeBook(id);
		if (deleted) {
			return ResponseEntity.noContent().build(); // 204 No Content
		} else {
			return ResponseEntity.notFound().build(); // 404 Not Found
		}
	}
}

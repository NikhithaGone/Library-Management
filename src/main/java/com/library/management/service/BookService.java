package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.library.management.DTO.BookResponse;
import com.library.management.DTO.CreateBookRequest;
import com.library.management.DTO.UpdateBookRequest;
import com.library.management.model.Book;
import com.library.management.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {

	private static final String created = null;
	private static final BookResponse BookResponse = null;
	private static final String updated = null;
	private static final String Fetched = null;
	private static final String deleted = null;
	private final BookRepository bookRepository;
	private final Logger logger = LoggerFactory.getLogger(BookService.class);

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public BookResponse createBook(CreateBookRequest request) {
		logger.debug("Create Book request:", request);
		Book book = new Book();
		book.setAuthor(request.getAuthor());
		book.setBookName(request.getBookName());
		book.setPrice(request.getPrice());
		
		Book savedBook = bookRepository.save(book);
		return new BookResponse(savedBook.getId(),savedBook.getBookName(),savedBook.getAuthor(), savedBook.getPrice(), created);
	}

	public BookResponse updateBook (Long id, UpdateBookRequest request) {
		logger.debug("Update Book Request:", request);
		Book book = new Book();
		book.setId(id);
		book.setAuthor(request.getAuthor());
		book.setBookName(request.getBookName());
		book.setPrice(request.getPrice());
		
		Book savedBook = bookRepository.save(book);
		return new BookResponse(savedBook.getId(),savedBook.getBookName(),savedBook.getAuthor(), savedBook.getPrice(), updated);
	}
	public BookResponse getBooksById(Long id) {
		Book book = new Book();
		book = bookRepository.getById(id);
		return new BookResponse(book.getId(),book.getBookName(),book.getAuthor(),book.getPrice(), Fetched);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public boolean removeBook(Long id) throws BookNotFoundException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			bookRepository.deleteById(id);
			return true;
		} else {
			throw new BookNotFoundException("Not Found");
		}
	}

}

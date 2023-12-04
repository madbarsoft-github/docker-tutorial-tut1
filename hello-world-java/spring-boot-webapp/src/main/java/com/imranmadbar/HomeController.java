package com.imranmadbar;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.book.BookRepository;

@RestController
public class HomeController {

	@Autowired
	private BookRepository bookRepository;

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/book-update")
	public List getBookList() {
		logger.info("Get book list");
		return bookRepository.findAll();
	}

	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to JavaSpringBootWebApplication");
		return "Welcome to JavaSpringBootWebApplication";
	}

}
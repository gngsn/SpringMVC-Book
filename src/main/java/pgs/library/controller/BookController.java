package pgs.library.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import pgs.library.domain.BookDTO;

@Controller
@RequestMapping("/books/*")
@Log4j
public class BookController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// TEST URI :
	// http://localhost:8080/GyeongSeonPark01/books/registerBook?title=title01&author=pgs01&genre=fiction&price=1000&pubdate=2020/20/02
	@GetMapping("/registerBook")
	public String registerBook(@ModelAttribute("book") BookDTO book) {
		log.info("title: " + book.getTitle());
		log.info("author : " + book.getAuthor());
		log.info("genre : " + book.getGenre());
		log.info("price : " + book.getPrice());
		log.info("pubdate : " + book.getPubdate());

		return "registerBook";
	}

	@GetMapping("/getBook")
	public ResponseEntity<String> getBook(@ModelAttribute("book") BookDTO book) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         
        
		String msg = "{\"title\": \"" + book.getTitle() + 
					"\", \"author\": \"" + book.getAuthor() +
					"\", \"genre\": \"" + book.getGenre() + 
					"\", \"price\": \"" + book.getPrice() +
					"\", \"pubdate\": \"" + book.getPubdate() + 
					"\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}

}
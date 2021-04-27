package pgs.library.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookDTO {
	private String title;
	private String author;
	private String genre;
	private int price;
	private Date pubdate;
}
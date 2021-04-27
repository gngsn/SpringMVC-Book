package pgs.library.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import pgs.library.domain.BookVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BookMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(book -> log.info(book)); 
	}
	
	@Test public void testInsert() {
		BookVO book = new BookVO();
		book.setTitle("새로운 제목1"); 
		book.setAuthor("새로운 저자1"); 
		book.setGenre("새로운 장르1");
		book.setPrice(7777);
		book.setPubdate(new Date(2021, 7, 7));
		mapper.insert(book); 
		log.info("\n\n\n" + book + "\n\n\n");
	}
	
	 
	@Test
	public void testInsertSelectKey() {
		BookVO book = new BookVO();
		book.setTitle("새로운 제목2"); 
		book.setAuthor("새로운 저자2"); 
		book.setGenre("새로운 장르2");
		book.setPrice(8888);
		book.setPubdate(new Date(2021, 8, 8));
		mapper.insertSelectKey(book); 		
		log.info("\n\n\n" + book + "\n\n\n");
	}
	
	 
	@Test
	public void testRead() {
		BookVO book = mapper.read(2L);
		log.info("\n\n\n" + book + "\n\n\n");
	}
	
	 
	@Test
	public void testDelete() {
		log.info("\n\n\nDELETE COUNT: " + mapper.delete(3L) + "\n\n\n");
	}
	
	 
	@Test
	public void testUpdate() {
		BookVO book = new BookVO();
		book.setBno(1); 
		book.setTitle("변경된 제목"); 
		book.setAuthor("변경된 저자"); 
		book.setGenre("변경된 장르");
		book.setPrice(7777);
		int count = mapper.update(book); 
		log.info("\n\n\nUPDATE COUNT: " + count);
		log.info("\n" + book + "\n\n\n");
	}
}

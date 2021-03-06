package pgs.library.mapper;

import java.util.List;

import pgs.library.domain.BookVO;

public interface BookMapper {
	
	public List<BookVO> getList();
	
	public void insert(BookVO book);
	
	public Integer insertSelectKey(BookVO book);
	
	public BookVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BookVO book);
}

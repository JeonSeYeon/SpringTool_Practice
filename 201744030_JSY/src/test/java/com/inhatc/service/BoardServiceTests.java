package com.inhatc.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inhatc.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardServiceTests{
	

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@Test
	public void testExist() {

		log.info("존재하는지 알아보자아 " + service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("스프링 첫 과제");
		board.setContent("희희이제시험이닷");
		board.setWriter("전세연");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호는: " + board.getBno());
	}

	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	public void testGet() {
		
		log.info(service.get(1L));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제된 결과: " +service.remove(1L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목을 수정한다아");
		log.info("수정한 결과는: " +service.modify(board));
	}
}
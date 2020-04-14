package com.inhatc.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inhatc.domain.BoardVO1;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardService1Tests{
	

	@Setter(onMethod_ = { @Autowired })
	private BoardService1 service;

	@Test
	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO1 board = new BoardVO1();
		board.setTitle("새로 작성하는 글이다");
		board.setContent("새로 작성하는 내용이다");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호는: " + board.getBno());
	}

	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(1L));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제 결과: " +service.remove(2L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO1 board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목을 수정합니다.");
		log.info("수정한 결과: " +service.modify(board));
	}
}
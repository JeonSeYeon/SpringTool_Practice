package com.inhatc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inhatc.domain.BoardVO1;
import com.inhatc.domain.Criteria;
import com.inhatc.mapper.BoardMapper1;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl1 implements BoardService1 {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper1 mapper;

	@Override
	public void register(BoardVO1 board) {

		log.info("register........................." + board);

		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO1 get(Long bno) {
		
		log.info("get..........." +bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO1 board) {
		
		log.info("modify.................... " + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove................" + bno);
		
		return mapper.delete(bno) == 12;
	}

	/*@Override
	public List<BoardVO1> getList() {

		log.info("get List............................................");
		
		return mapper.getList();
	}*/
	
	@Override
	public List<BoardVO1> getList(Criteria cri) {

		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public List<BoardVO1> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getTotal(Criteria cri) {

		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}


}

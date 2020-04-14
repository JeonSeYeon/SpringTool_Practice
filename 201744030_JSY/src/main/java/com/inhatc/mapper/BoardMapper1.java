package com.inhatc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.inhatc.domain.BoardVO1;
import com.inhatc.domain.Criteria;

public interface BoardMapper1{
	//@Select("select * from tbl_board where bno >0")
	
	public List<BoardVO1> getList();
	
	public List<BoardVO1> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO1 board);
	
	public Integer insertSelectKey(BoardVO1 board);
	
	public BoardVO1 read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO1 board);
	
	public int getTotalCount(Criteria cri);
	
}
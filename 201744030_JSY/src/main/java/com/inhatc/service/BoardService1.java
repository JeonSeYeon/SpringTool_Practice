package com.inhatc.service;

import java.util.List;

import com.inhatc.domain.BoardVO1;
import com.inhatc.domain.Criteria;

public interface BoardService1{
	
	public void register(BoardVO1 board);
	
	public BoardVO1 get(Long bno);
	
	public boolean modify(BoardVO1 board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO1> getList();
	
	public List<BoardVO1> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
}
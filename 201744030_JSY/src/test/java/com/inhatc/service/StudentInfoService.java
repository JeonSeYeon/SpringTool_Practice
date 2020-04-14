package com.inhatc.service;

import java.util.List;

import com.inhatc.domain.StudentInfoVO;

public interface StudentInfoService{
	
	public void register(StudentInfoVO vo);
	
	public StudentInfoVO get(Long id);
	
	public boolean modify(StudentInfoVO vo);
	
	public boolean remove(Long id);
	
	public List<StudentInfoVO> getList();


}
package com.inhatc.mapper;

import java.util.List;
import com.inhatc.domain.StudentInfoVO;

public interface StudentInfoMapper{
	
	public List<StudentInfoVO> getList();
	
	public void insert(StudentInfoVO vo);
	
	public StudentInfoVO read(Long id);
	
	public int delete(Long id);
	
	public int update(StudentInfoVO vo);
	
}
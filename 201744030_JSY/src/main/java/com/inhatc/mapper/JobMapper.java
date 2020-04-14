package com.inhatc.mapper;

import java.util.List;
import com.inhatc.domain.JobVO;

public interface JobMapper{
	
	public List<JobVO> getList();
	
	public void insert(JobVO vo);
	
	public JobVO read(String comName);
	
	public int delete(String comName);
	
	public int update(JobVO vo);
	
}
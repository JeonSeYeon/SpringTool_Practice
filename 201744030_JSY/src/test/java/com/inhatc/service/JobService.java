package com.inhatc.service;

import java.util.List;

import com.inhatc.domain.JobVO;

public interface JobService{
	
	public void register(JobVO vo);
	
	public JobVO get(String comName);
	
	public boolean modify(JobVO vo);
	
	public boolean remove(String comName);
	
	public List<JobVO> getList();
}
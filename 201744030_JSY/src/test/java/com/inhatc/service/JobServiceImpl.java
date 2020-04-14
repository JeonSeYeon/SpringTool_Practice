package com.inhatc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inhatc.domain.JobVO;
import com.inhatc.mapper.JobMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

	@Setter(onMethod_ = @Autowired)
	private JobMapper mapper;

	@Override
	public void register(JobVO vo) {

		log.info("@@@@@@register........................." + vo);

		mapper.insert(vo);
	}
	
	@Override
	public JobVO get(String comName) {
		
		log.info("@@@@@@get..........." +comName);
		
		return mapper.read(comName);
	}

	@Override
	public boolean modify(JobVO vo) {
		
		log.info("@@@@@@modify.................... " + vo);
		
		return mapper.update(vo) == 0;
	}
	
	@Override
	public boolean remove(String comName) {
		log.info("@@@@@@remove................" + comName);
		
		return mapper.delete(comName) == 0;
				
	}

	@Override
	public List<JobVO> getList() {

		log.info("@@@@@@get List............................................");
		
		return mapper.getList();
	}



}

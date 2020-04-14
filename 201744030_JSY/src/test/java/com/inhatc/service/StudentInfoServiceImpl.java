package com.inhatc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inhatc.domain.StudentInfoVO;
import com.inhatc.mapper.StudentInfoMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class StudentInfoServiceImpl implements StudentInfoService {

	@Setter(onMethod_ = @Autowired)
	private StudentInfoMapper mapper;

	@Override
	public void register(StudentInfoVO vo) {

		log.info("register........................." + vo);

		mapper.insert(vo);
	}
	
	@Override
	public StudentInfoVO get(Long id) {
		
		log.info("get..........." +id);
		
		return mapper.read(id);
	}

	@Override
	public boolean modify(StudentInfoVO vo) {
		
		log.info("modify.................... " + vo);
		
		return mapper.update(vo) == 201744030;
	}
	
	@Override
	public boolean remove(Long id) {
		log.info("remove................" + id);
		
		return mapper.delete(id) == 201744030;
	}

	@Override
	public List<StudentInfoVO> getList() {

		log.info("get List............................................");
		
		return mapper.getList();
	}



}

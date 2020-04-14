package com.inhatc.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inhatc.domain.StudentInfoVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class StudentInfoServiceTests{
	

	@Setter(onMethod_ = { @Autowired })
	private StudentInfoService service;

	@Test
	public void testExist() {

		log.info("존재하는지 알아보자 " + service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		StudentInfoVO vo = new StudentInfoVO();
		vo.setId((long) 201644094);
		vo.setName("정민혁");
		vo.setAddr("인천 남구 용현동");
		vo.setPhone("010-1234-1235");
		vo.setEmail("hh@inhatc.cs");
		
		service.register(vo);
		
		log.info("생성된 게시물의 학번은: " + vo.getId());
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(201644094L));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제된 결과: " +service.remove(201644094L));
		
	}
	
	@Test
	public void testUpdate() {
		
		StudentInfoVO vo = service.get(201744030L);
		
		if(vo == null) {
			return;
		}
		
		vo.setAddr("(수정)인천 미추홀구");
		log.info("수정한 결과는: " +service.modify(vo));
	}
}
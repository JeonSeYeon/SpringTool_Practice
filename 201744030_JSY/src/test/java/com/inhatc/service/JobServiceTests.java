package com.inhatc.service;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inhatc.domain.JobVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class JobServiceTests{
	

	@Setter(onMethod_ = { @Autowired })
	private JobService service;

	@Test
	public void testExist() {

		log.info("존재하는지 알아보자 " + service);
		assertNotNull(service);
	}
	@Test
	public void testRegister() {
		
		JobVO vo = new JobVO();
		vo.setComName("에코시안");
		vo.setClassifcation("개발자");
		vo.setMoney("3400");
		vo.setOfficeName("박충규");
		vo.setWorkDate("5년");
		vo.setIdCard("정보처리산업기사");
		
		
		service.register(vo);
		
		log.info("@@@@@@생성된 게시물의 회사이름은: " + vo.getComName());
	}
	@Test
	public void testGet() {
		
		log.info(service.get("에코시안"));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제된 결과: " + service.remove("에코시안"));
		
	}

	@Test
	public void testUpdate() {
		
		JobVO vo = service.get("웨이츠");
		
		if(vo == null) {
			return;
		}
		
		vo.setMoney("(수정)3500");
		log.info("수정한 결과는:" +service.modify(vo));
	}
}
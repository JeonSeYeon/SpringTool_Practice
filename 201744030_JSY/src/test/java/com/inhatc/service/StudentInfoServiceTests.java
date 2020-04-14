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

		log.info("�����ϴ��� �˾ƺ��� " + service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		StudentInfoVO vo = new StudentInfoVO();
		vo.setId((long) 201644094);
		vo.setName("������");
		vo.setAddr("��õ ���� ������");
		vo.setPhone("010-1234-1235");
		vo.setEmail("hh@inhatc.cs");
		
		service.register(vo);
		
		log.info("������ �Խù��� �й���: " + vo.getId());
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(201644094L));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("������ ���: " +service.remove(201644094L));
		
	}
	
	@Test
	public void testUpdate() {
		
		StudentInfoVO vo = service.get(201744030L);
		
		if(vo == null) {
			return;
		}
		
		vo.setAddr("(����)��õ ����Ȧ��");
		log.info("������ �����: " +service.modify(vo));
	}
}
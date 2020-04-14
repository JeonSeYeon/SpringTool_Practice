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

		log.info("�����ϴ��� �˾ƺ��� " + service);
		assertNotNull(service);
	}
	@Test
	public void testRegister() {
		
		JobVO vo = new JobVO();
		vo.setComName("���ڽþ�");
		vo.setClassifcation("������");
		vo.setMoney("3400");
		vo.setOfficeName("�����");
		vo.setWorkDate("5��");
		vo.setIdCard("����ó��������");
		
		
		service.register(vo);
		
		log.info("@@@@@@������ �Խù��� ȸ���̸���: " + vo.getComName());
	}
	@Test
	public void testGet() {
		
		log.info(service.get("���ڽþ�"));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("������ ���: " + service.remove("���ڽþ�"));
		
	}

	@Test
	public void testUpdate() {
		
		JobVO vo = service.get("������");
		
		if(vo == null) {
			return;
		}
		
		vo.setMoney("(����)3500");
		log.info("������ �����:" +service.modify(vo));
	}
}
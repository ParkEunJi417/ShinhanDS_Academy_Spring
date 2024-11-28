package com.shinhan.myapp;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// �������� ������ ��û �н�

@Controller
public class SampleController3 {
	
	Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	/* ��û�� �ּҰ� ���� �Ѿ���� �Ķ���͵� Ȯ��
	 * ���� : name=userid�� value=pej && name=userpw�� ���縸 �ϸ� �� && name=email�� �����ϸ� �ȵ�
	 */
	@RequestMapping(value = "/second4.do", params = {"userid=pej", "userpw", "!email"})
	public String f3(String userid, int userpw) {
		logger.info("���̵�� "+ userid);
		logger.info("�н������ "+ userpw);
		
		 return "jsptest/second3";
	}
	
	@RequestMapping(value = {"/second3.do"}, method = RequestMethod.POST)
	public String f2(@RequestParam("userid") String userid2, 
					 @RequestParam("userpw") int userpw2) {
		logger.info("���̵�� "+ userid2);
		logger.info("�н������ "+ userpw2);
		
		return "jsptest/second3";
	}

	@RequestMapping(value = {"/second1.do","/second2.do"}, method = RequestMethod.GET)
	public String f1() {
		
		return "jsptest/first1";
	}
}

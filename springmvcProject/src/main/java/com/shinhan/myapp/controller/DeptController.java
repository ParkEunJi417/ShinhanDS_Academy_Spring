package com.shinhan.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shinhan.myapp.SampleController4;
import com.shinhan.myapp.model.DeptService;
import com.shinhan.myapp.vo.DeptDTO;

// �μ��� CRUD�۾� : Controller �� Service �� DAO
// ������� ��û �� DispatcherServlet �� Controller ã��
// component-scan�� ���ؼ� Bean ����


/* 
 @Controller : ��û���� page�� return 
 
 @RestController : ��û�� �޾Ƽ� ���� �����͸� return
 == @Controller + @ResponseBody
 
 @ResponseBody : �ش� Annotation�� ����� method ���� return�� �ϸ� ������ ��ü�� �����ϴ� ��
 == request.getWriter().append()
*/

@Controller 
public class DeptController {
	
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	DeptService dService;
	
	@GetMapping("/dept/detail.do")
	public String detailGet(int deptid, Model model) {
		model.addAttribute("deptInfo",dService.selectByIdService(deptid));
		
		return "dept/deptDetail";
	}
	
	/* �󼼺����Ŀ� ����� �����ְ� 1���� list�� ����
	@PostMapping("/dept/detail.do")
	public String detailPost(@ModelAttribute("dept") DeptDTO dept) {
		logger.info(dept.toString());
		
		dService.updateService(dept);
		
		return "dept/result";
	}*/
	
	@PostMapping("/dept/detail.do")
	public String detailPost(DeptDTO dept) {
		logger.info(dept.toString());
		
		dService.updateService(dept);
		
		return "redirect:/dept/list.do"; // redirect: == response.sendRedirect()
	}
	
	@GetMapping("/dept/insert.do")
	public String insertGet() {
		
		return "dept/deptInsert";
	}
	
	@PostMapping("/dept/insert.do")
	public String insertPost(DeptDTO dept) {
		
		dService.insertService(dept);
		
		return "redirect:/dept/list.do";
	}
	
	@GetMapping("/dept/delete.do")
	public String deleteGet() {
		
		return "dept/deptInsert";
	}
	
	@RequestMapping(value="/dept/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int deptid) {
		dService.deleteService(deptid);
		
		return "redirect:/dept/list.do";
	}
	
	
	@RequestMapping("/dept/list.do")
	public String f1(Model model) {
		List<DeptDTO> deptlist = dService.selectAllService();
		
		model.addAttribute("deptlist", deptlist);
		
		return "dept/deptlist"; // forward, include
	}
}

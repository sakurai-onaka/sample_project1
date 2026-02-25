package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.service.DeleteService;

@Controller
public class DeleteController {
	@Autowired
	DeleteService deleteService;
	@Autowired
	EmployeeRepository empRepository;

	@RequestMapping(path = "/delete/check", method = RequestMethod.GET)
	public String checkDelete(Integer empId, Model model) {
		if (empId == null) {
			return "redirect:/list";
		}
		EmployeeBean empBean = deleteService.getUpdateEmpInfo(empId);
		model.addAttribute("employeeBean", empBean);
		return "delete/delete_check";
	}

	@RequestMapping(path = "/delete/do-delete")
	public String doDelete(Integer empId) {
		empRepository.deleteById(empId);
		return "redirect:/delete/complete";
	}

	@RequestMapping(path = "/delete/complete")
	public String completeDelete(String empId, Model model) {
		return "delete/delete_complete";
	}
}

package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.service.ListService;
import jp.co.sss.crud.util.BeanCopy;

@Controller
public class ListController {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ListService listService;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("empList", BeanCopy.empListToEmpBeanList(employeeRepository.findAll()));
		return "list/list";
	}

	@RequestMapping(path = "/list/empName", method = RequestMethod.GET)
	public String findByEmpName(String empName, Model model) {
		model.addAttribute("empList",
				BeanCopy.empListToEmpBeanList(employeeRepository.findByEmpNameContaining(empName)));
		return "list/list";
	}

	@RequestMapping(path = "/list/deptId", method = RequestMethod.GET)
	public String findByDeptId(Integer deptId, Model model) {
		model.addAttribute("empList",
				BeanCopy.empListToEmpBeanList(listService.findEmpByDept(deptId)));
		return "list/list";
	}
}

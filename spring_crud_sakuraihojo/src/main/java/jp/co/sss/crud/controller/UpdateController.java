package jp.co.sss.crud.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.service.UpdateService;

@Controller
public class UpdateController {
	@Autowired
	UpdateService updateService;

	@RequestMapping(path = "/update/input", method = RequestMethod.GET)
	public String inputUpdate(Integer empId, @ModelAttribute EmployeeForm employeeForm, Model model) {
		EmployeeBean empBean = updateService.getUpdateEmpInfo(empId);
		model.addAttribute("employeeBean", empBean);
		return "update/update_input";
	}

	@RequestMapping(path = "/update/check", method = RequestMethod.POST)
	public String checkUpdate(@Valid @ModelAttribute EmployeeForm employeeForm, BindingResult result, Model model) {
		return "";
	}
}

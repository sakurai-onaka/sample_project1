package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.service.RegistrationService;
import jp.co.sss.crud.util.BeanCopy;

@Controller
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;

	@RequestMapping(path = "/regist/input", method = RequestMethod.GET)
	public String inputRegist(@ModelAttribute EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeBean", registrationService.createDefaultEmpBean());
		return "regist/regist_input";
	}

	@RequestMapping(path = "/regist/check", method = RequestMethod.POST)
	public String checkRegist(@Valid @ModelAttribute EmployeeForm employeeForm, BindingResult result, Model model) {
		model.addAttribute("employeeBean", BeanCopy.empFormToEmpBean(employeeForm));
		if (result.hasErrors()) {
			return "regist/regist_input";
		}
		return "regist/regist_check";
	}

	@RequestMapping(path = "/regist/do-register", method = RequestMethod.POST)
	public String doRegister(EmployeeForm employeeForm) {
		registrationService.insertEmployee(employeeForm);
		return "redirect:/regist/complete";
	}

	@RequestMapping(path = "/regist/complete", method = RequestMethod.GET)
	public String completeRegist(EmployeeForm employeeForm) {
		return "regist/regist_complete";
	}

	@RequestMapping(path = "/regist/back", method = RequestMethod.POST)
	public String backInputRegist(@ModelAttribute EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeBean", BeanCopy.empFormToEmpBean(employeeForm));
		return "regist/regist_input";
	}
}

package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.service.UpdateService;
import jp.co.sss.crud.util.BeanCopy;

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
		model.addAttribute("employeeBean", BeanCopy.empFormToEmpBean(employeeForm));
		if (result.hasErrors()) {
			return "update/update_input";
		}
		return "update/update_check";
	}

	@RequestMapping(path = "/update/do-update", method = RequestMethod.POST)
	public String doUpdate(EmployeeForm employeeForm) {
		updateService.updateEmployee(employeeForm);
		return "redirect:/update/complete";
	}

	@RequestMapping(path = "/update/complete", method = RequestMethod.GET)
	public String completeUpdate(EmployeeForm employeeForm, HttpSession session) {
		return "update/update_complete";
	}

	@RequestMapping(path = "/update/back", method = RequestMethod.POST)
	public String backInputUpdate(@ModelAttribute EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeBean", BeanCopy.empFormToEmpBean(employeeForm));
		return "update/update_input";
	}

}

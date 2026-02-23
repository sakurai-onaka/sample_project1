package jp.co.sss.crud.service;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.repository.EmployeeRepository;

@Service
public class LoginService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	HttpSession session;

	public String checkLogin(LoginForm loginForm) {
		Employee targetemp = employeeRepository.findByEmpIdAndEmpPass(loginForm.getEmpId(),
				loginForm.getEmpPass());
		if (targetemp == null) {
			return "index";
		} else {
			session.setAttribute("loginUser", targetemp);
			return "redirect:/list";
		}
	}
}

package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.repository.DepartmentRepository;
import jp.co.sss.crud.repository.EmployeeRepository;

@Service
public class LoginService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	HttpSession session;

	public boolean checkLogin(LoginForm loginForm) {
		Employee targetemp = employeeRepository.findByEmpIdAndEmpPass(loginForm.getEmpId(),
				loginForm.getEmpPass());
		if (targetemp == null) {
			return false;
		} else {
			session.setAttribute("deptList", departmentRepository.findAllByOrderByDeptIdAsc());
			session.setAttribute("loginUser", targetemp);
			return true;
		}
	}
}

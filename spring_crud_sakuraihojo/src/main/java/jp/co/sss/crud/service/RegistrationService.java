package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.DepartmentRepository;
import jp.co.sss.crud.repository.EmployeeRepository;

@Service
public class RegistrationService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public EmployeeBean createDefaultEmpBean() {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setDepartment(new Department());
		return employeeBean;
	}

	public EmployeeForm returnDefaultEmpForm(EmployeeForm employeeForm) {
		employeeForm.setGender(1);
		employeeForm.setDeptId(1);
		return employeeForm;
	}

	public void insertEmployee(EmployeeForm employeeForm) {
		Employee emp = new Employee();
		emp.setEmpPass(employeeForm.getEmpPass());
		emp.setEmpName(employeeForm.getEmpName());
		emp.setGender(employeeForm.getGender());
		emp.setAddress(employeeForm.getAddress());
		emp.setBirthday(employeeForm.getBirthday());
		emp.setAuthority(employeeForm.getAuthority());
		Department dept = departmentRepository.getReferenceById(employeeForm.getDeptId());
		emp.setDepartment(dept);
		employeeRepository.save(emp);
	}

}

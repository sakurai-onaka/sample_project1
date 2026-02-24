package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.DepartmentRepository;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanCopy;

@Service
public class UpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public EmployeeBean getUpdateEmpInfo(Integer empId) {
		Employee emp = employeeRepository.getReferenceById(empId);
		EmployeeBean empBean = BeanCopy.empToEmpBean(emp);

		return empBean;
	}

	public void updateEmployee(EmployeeForm employeeForm) {
		Employee emp = new Employee();
		emp.setEmpId(employeeForm.getEmpId());
		emp.setEmpPass(employeeForm.getEmpPass());
		emp.setEmpName(employeeForm.getEmpName());
		emp.setGender(employeeForm.getGender());
		emp.setAddress(employeeForm.getAddress());
		emp.setBirthday(employeeForm.getBirthday());
		emp.setAuthority(employeeForm.getAuthority());
		Department dept = departmentRepository.getReferenceById(employeeForm.getDeptId());
		emp.setDepartment(dept);
		System.out.println(dept);
		employeeRepository.save(emp);
	}
}

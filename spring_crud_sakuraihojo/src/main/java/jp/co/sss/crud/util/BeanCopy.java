package jp.co.sss.crud.util;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;

public class BeanCopy {
	public static List<EmployeeBean> empListToEmpBeanList(List<Employee> empList) {
		List<EmployeeBean> empBeanList = new ArrayList<>();
		for (Employee emp : empList) {
			EmployeeBean empBean = new EmployeeBean();
			empBean.setEmpId(emp.getEmpId());
			empBean.setEmpPass(emp.getEmpPass());
			empBean.setEmpName(emp.getEmpName());
			empBean.setGender(emp.getGender());
			empBean.setAddress(emp.getAddress());
			empBean.setBirthday(emp.getBirthday());
			empBean.setAuthority(emp.getAuthority());
			empBean.setDepartment(emp.getDepartment());
			empBeanList.add(empBean);
		}
		return empBeanList;
	}

	public static EmployeeBean empToEmpBean(Employee emp) {
		EmployeeBean empBean = new EmployeeBean();
		empBean.setEmpId(emp.getEmpId());
		empBean.setEmpPass(emp.getEmpPass());
		empBean.setEmpName(emp.getEmpName());
		empBean.setGender(emp.getGender());
		empBean.setAddress(emp.getAddress());
		empBean.setBirthday(emp.getBirthday());
		empBean.setAuthority(emp.getAuthority());
		empBean.setDepartment(emp.getDepartment());
		return empBean;
	}

	public static EmployeeBean empFormToEmpBean(EmployeeForm employeeForm) {
		EmployeeBean empBean = new EmployeeBean();
		empBean.setEmpId(employeeForm.getEmpId());
		empBean.setEmpPass(employeeForm.getEmpPass());
		empBean.setEmpName(employeeForm.getEmpName());
		empBean.setGender(employeeForm.getGender());
		empBean.setAddress(employeeForm.getAddress());
		empBean.setBirthday(employeeForm.getBirthday());
		empBean.setAuthority(employeeForm.getAuthority());
		Department dept = new Department();
		dept.setDeptId(employeeForm.getDeptId());
		empBean.setDepartment(dept);
		return empBean;
	}
}

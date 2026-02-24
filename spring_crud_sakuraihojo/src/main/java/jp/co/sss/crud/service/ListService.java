package jp.co.sss.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;

@Service
public class ListService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findEmpByDept(Integer deptId) {
		Department dept = new Department();
		dept.setDeptId(deptId);
		List<Employee> empList = employeeRepository.findByDepartmentOrderByEmpIdAsc(dept);
		return empList;
	}

}

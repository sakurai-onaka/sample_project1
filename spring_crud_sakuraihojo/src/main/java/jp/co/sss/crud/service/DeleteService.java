package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanCopy;

@Service
public class DeleteService {
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeBean getUpdateEmpInfo(Integer empId) {
		Employee emp = employeeRepository.getReferenceById(empId);
		EmployeeBean empBean = BeanCopy.empToEmpBean(emp);

		return empBean;
	}
}

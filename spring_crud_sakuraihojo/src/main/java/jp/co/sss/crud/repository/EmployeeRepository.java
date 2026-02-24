package jp.co.sss.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findAllByOrderByEmpIdAsc();
	
	Employee findByEmpIdAndEmpPass(Integer empId, String empName);
	
	List<Employee> findByEmpNameContainingOrderByEmpIdAsc(String empName);
	
	List<Employee> findByDepartmentOrderByEmpIdAsc(Department department); 
}

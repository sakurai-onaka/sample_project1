package jp.co.sss.crud.bean;

import java.io.Serializable;
import java.util.Date;

import jp.co.sss.crud.entity.Department;

public class EmployeeBean implements Serializable {
	private Integer empId;

	private String empPass;

	private String empName;

	private Integer gender;

	private String address;

	private Date birthday;

	private Integer authority;

	private Department department;

	private String genderStr;
	
	private String authorityStr;

	public String getAuthorityStr() {
		return authorityStr;
	}

	public void setAuthorityStr(String authorityStr) {
		this.authorityStr = authorityStr;
	}

	public String getGenderStr() {
		return genderStr;
	}

	public void setGenderStr(String genderStr) {
		this.genderStr = genderStr;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		if (gender == 1) {
			this.genderStr = "男性";
		} else if (gender == 2) {
			this.genderStr = "女性";
		}
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		if (authority == 1) {
			this.authorityStr = "一般";
		} else if (authority == 2) {
			this.authorityStr = "管理者";
		}
		this.authority = authority;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}

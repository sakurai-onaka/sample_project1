package jp.co.sss.crud.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class LoginForm {
	@Max(value=999)
	private Integer empId;
	
	@NotBlank
	private String empPass;

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

}

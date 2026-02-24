package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.entity.Employee;

public class AccountCheckFilter extends HttpFilter {
	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String requestURL = request.getRequestURI();
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("loginUser");
		//一般ユーザーの登録・削除を防ぐ
		if (requestURL.contains("regist") || requestURL.contains("delete")) {
			if (emp.getAuthority() == 1) {
				session.invalidate();
				response.sendRedirect("/spring_crud/");
				return;
			}
		}
		//一般ユーザーが自身以外のユーザーを更新する動作を防ぐ
		if (requestURL.contains("update") && emp.getAuthority() == 1) {
			String empIdParam = request.getParameter("empId");
			int updateEmpId = Integer.parseInt(empIdParam);
			//ログインユーザーと更新対象のユーザーが一致しない
			if (!(updateEmpId == emp.getEmpId())) {
				session.invalidate();
				response.sendRedirect("/spring_crud/");
				return;
			}
		}
		chain.doFilter(request, response);
	}
}

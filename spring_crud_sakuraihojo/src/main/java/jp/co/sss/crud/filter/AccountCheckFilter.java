package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.util.Constant;

public class AccountCheckFilter extends HttpFilter {
	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String requestURL = request.getRequestURI();
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute(Constant.SESSION_SCAPE_LOGINUSER);
		//一般ユーザーの登録・削除を防ぐ
		if (requestURL.contains(Constant.URL_REGIST) || requestURL.contains(Constant.URL_DELETE)) {
			if (emp.getAuthority() == Constant.AUTHORITY_GENERAL_USER) {
				session.invalidate();
				response.sendRedirect(Constant.URL_WELCOME_PAGE);
				return;
			}
		}
		//一般ユーザーが自身以外のユーザーを更新する動作を防ぐ
		if (requestURL.contains(Constant.URL_UPDATE) && emp.getAuthority() == Constant.AUTHORITY_GENERAL_USER) {
			String empIdParam = request.getParameter(Constant.PRAM_NAME_EMPID);
			if (empIdParam == null) {
				chain.doFilter(request, response);
				return;
			}
			int updateEmpId = Integer.parseInt(empIdParam);
			//ログインユーザーと更新対象のユーザーが一致しない
			if (!(updateEmpId == emp.getEmpId())) {
				session.invalidate();
				response.sendRedirect(Constant.URL_WELCOME_PAGE);
				return;
			}
		}
		chain.doFilter(request, response);
	}
}

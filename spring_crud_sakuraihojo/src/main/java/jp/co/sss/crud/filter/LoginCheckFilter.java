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

public class LoginCheckFilter extends HttpFilter {
	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// リクエストURLを取得 
		String requestURL = request.getRequestURI();
		if (requestURL.indexOf(Constant.URL_HTML) != -1 ||
				requestURL.indexOf(Constant.URL_CSS) != -1 ||
				requestURL.indexOf(Constant.URL_IMG) != -1 ||
				requestURL.indexOf(Constant.URL_JS) != -1 ||
				requestURL.endsWith(Constant.URL_LOGIN) ||
				requestURL.endsWith(Constant.URL_INDEX)) {
			chain.doFilter(request, response);
		} else {
			//セッション情報を取得  
			HttpSession session = request.getSession(); //セッション情報からユーザのログイン情報(セッション属性 userId)を取得  
			Employee emp = (Employee) session.getAttribute(Constant.SESSION_SCAPE_LOGINUSER);

			if (emp == null) {
				//ログイン情報が存在しない場合（ログイン情報(userId) が null の場合）、  
				//ログイン画面にリダイレクトする  
				response.sendRedirect(Constant.URL_WELCOME_PAGE);
				return;
			} else {
				chain.doFilter(request, response);
			}
		}
	}
}

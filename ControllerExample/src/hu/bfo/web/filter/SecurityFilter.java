package hu.bfo.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {

	private List<String> whiteListList = new ArrayList<String>();
	{
		whiteListList.add("/app/login");
		whiteListList.add("/app/rest/registration");
		whiteListList.add("/app/rest/addUser");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getSession().getAttribute("userid") == null) {

			for (String u : whiteListList) {

				if (req.getRequestURI().contains(u)) {
					arg2.doFilter(request, response);
					return;
				}
			}
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("http://localhost:8080/frontoffice/app/login");
		} else {
			arg2.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

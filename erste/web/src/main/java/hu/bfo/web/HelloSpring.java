package hu.bfo.web;

import hu.bfo.service.DefaultAccountService;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
 
@WebServlet("/processForm")
public class HelloSpring extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
           throws IOException {
		
	   ApplicationContext ctx = (ApplicationContext) request.getServletContext().getAttribute("applicationContext");
	   DefaultAccountService service = (DefaultAccountService) ctx.getBean("defaultAccountService");
       response.getWriter().println("<h1>"+service.increaseBalance(10)+"</h1>");
       
       
   }
}
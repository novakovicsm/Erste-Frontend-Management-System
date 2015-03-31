package hu.bfo.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class SpringApplicationContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		
		ClassPathXmlApplicationContext ac = (ClassPathXmlApplicationContext) arg0.getServletContext().getAttribute("applicationContext");
		ac.close();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath*:/spring-config/application-context.xml");
		arg0.getServletContext().setAttribute("applicationContext", ac);

	}

}
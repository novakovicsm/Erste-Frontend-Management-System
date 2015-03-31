package hu.bfo.web.controller;

import hu.bfo.dto.UserDTO;
import hu.bfo.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public String loginGet(Model model) {

		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req, Model model,
			@Valid LoginBean loginBean, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return "login";
		}

		String foundUser = null;
		List<UserDTO> users = service.getAllActiveUser();

		for (UserDTO d : users) {
			if (d.getUserName().equalsIgnoreCase(loginBean.getUserName())
					&& d.getPassword()
							.equalsIgnoreCase(loginBean.getPassword())) {
				foundUser = d.getUserName();
				break;
			}
		}

		if (foundUser == null) {
			model.addAttribute("invaliduser", "err");
			return "login";
		}

		req.getSession().setAttribute("userid", foundUser);
		return "redirect:/app/rest/test/all";
	}

	@ModelAttribute("loginBean")
	public LoginBean createLoginBean() {
		return new LoginBean();
	}
}
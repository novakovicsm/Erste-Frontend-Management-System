package hu.bfo.web.controller;

import hu.bfo.dto.UserDTO;
import hu.bfo.service.UserService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/rest")
public class TestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test/{id}/{mode}")
	public String getUserById(@PathVariable Integer id, Model model,
			@PathVariable String mode) throws Exception {

		UserDTO user = (UserDTO) userService.getUserById(id);

		if (user != null)

			model.addAttribute("user", user);
		model.addAttribute("mode", mode);
		return "useradmin";
	}

	@RequestMapping(value = "/test/all")
	public String getAllActiveUser(Model model) throws Exception {

		List<UserDTO> users = userService.getAllActiveUser();
		model.addAttribute("users", users);
		return "listusers";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid UserDTO user,
			BindingResult result, ModelMap model) throws Exception {
		if (result.hasErrors()) {
			return "user";
		}
		userService.createUser(user);
		model.addAttribute("user", user);

		return "result";
	}
	
	@RequestMapping(value = "/userAdmin", method ={ RequestMethod.GET, RequestMethod.POST})
	public String userAdmin(@ModelAttribute("user") @Valid UserDTO user,
			BindingResult result, ModelMap model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("mode", "update");
			return "useradmin";
		}
		userService.createUser(user);
		model.addAttribute("user", user);

		return "result";
	}

	@RequestMapping(value = "/removeUser", method = RequestMethod.POST)
	public String removeUser(@ModelAttribute("user") UserDTO user)
			throws Exception {

		if (user != null)
			userService.deleteUser(user.getId());

		return "redirect:/rest/test/all";
	}

	@RequestMapping(value = "/registration")
	public String userForm() {

		return "user";
	}

	@ModelAttribute("user")
	public UserDTO createUserDTO() {
		return new UserDTO();
	}
}

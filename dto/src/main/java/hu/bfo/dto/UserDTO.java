package hu.bfo.dto;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String userName;
	
	@Email
	private String userEmail;
	
	@NotEmpty
	@Size(max=6)
	private String password;
	
	private List<AccountDTO> accounts;


	public String getUserName() {
		return userName;
	}

	public List<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

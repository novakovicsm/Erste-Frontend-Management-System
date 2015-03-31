package hu.bfo.service;

import hu.bfo.dto.UserDTO;

import java.util.List;

public interface UserService {
	
	void createUser(UserDTO user) throws Exception;
	
	UserDTO getUserById(Integer id)throws Exception;
	
	void deleteUser( Integer id)throws Exception;
	
	List<UserDTO> getAllActiveUser() throws Exception;
}

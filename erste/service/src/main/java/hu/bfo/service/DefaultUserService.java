package hu.bfo.service;

import hu.bfo.dao.UserDAO;
import hu.bfo.dto.UserDTO;
import hu.bfo.dto.UserTransformer;
import hu.bfo.model.BusinessObject;
import hu.bfo.model.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	UserDAO dao;
	
	@Autowired
	private UserTransformer transformer;

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, timeout = 3000, rollbackFor = Exception.class)
	public void createUser(UserDTO user) throws Exception {
		User u = null;
		try {
			user.setActive(Boolean.TRUE);
			u = transformer.transformDTOToEntity(user);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.save(u);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, timeout = 3000, rollbackFor = Exception.class)
	public UserDTO getUserById(Integer id) throws Exception {
		User u = (User) dao.getById(id);
		return transformer.transformEntityToDTO(u);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, timeout = 3000, rollbackFor = Exception.class)
	public void deleteUser(Integer id) {
		BusinessObject obj = dao.getById(id);
		dao.delete((User) obj);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, timeout = 3000, rollbackFor = Exception.class)
	public List<UserDTO> getAllActiveUser() throws Exception {
		List<UserDTO> result = new ArrayList<UserDTO>();

		for (User u : dao.getActiveUsers()) {
			result.add(transformer.transformEntityToDTO(u));
		}
		return result;
	}

	}

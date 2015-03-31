package hu.bfo.dto;

import hu.bfo.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer extends BaseTransformer<UserDTO, User> {

	@Autowired
	AccountTransformer accountTransformer;

	@Override
	public UserDTO transformEntityToDTO(User user) throws Exception {

		UserDTO result = super.transformEntityToDTO(user, UserDTO.class);
		result.setUserName(user.getUserName());
		result.setUserEmail(user.getUserEmail());
		result.setPassword(user.getPassword());
		result.setAccounts(accountTransformer.transformEntitiesToDTOs(user
				.getAccounts()));

		return result;
	}

	@Override
	public User transformDTOToEntity(UserDTO dto) throws Exception {

		User result = super.transformDTOToEntity(dto, User.class);
		result.setUserName(dto.getUserName());
		result.setUserEmail(dto.getUserEmail());
		result.setPassword(dto.getPassword());

		return result;
	}

	@Override
	public List<UserDTO> transformEntitiesToDTOs(List<User> businessobjectList)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> transformDTOsToEntities(List<UserDTO> dtoList)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

package hu.bfo.dto;

import hu.bfo.model.Account;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountTransformer extends BaseTransformer<AccountDTO, Account> {

	@Override
	public AccountDTO transformEntityToDTO(Account account) throws Exception {

		AccountDTO result = super.transformEntityToDTO(account,
				AccountDTO.class);
		result.setAccountNumF8(account.getAccountNumF8());
		result.setAccountNumM8(account.getAccountNumM8());
		result.setAccountNumL8(account.getAccountNumL8());
		result.setAccountType(account.getAccountType());
		result.setActive(account.getActive());
		result.setActualBalance(account.getActualBalance());
		result.setId(account.getId());

		return result;
	}

	@Override
	public Account transformDTOToEntity(AccountDTO account) throws Exception {

		Account result = super.transformDTOToEntity(account, Account.class);
		result.setAccountNumF8(account.getAccountNumF8());
		result.setAccountNumM8(account.getAccountNumM8());
		result.setAccountNumL8(account.getAccountNumL8());
		result.setAccountType(account.getAccountType());
		result.setActualBalance(account.getActualBalance());

		return result;
	}

	@Override
	public List<AccountDTO> transformEntitiesToDTOs(
			List<Account> businessobjectList) throws Exception {

		List<AccountDTO> dtoList = super.transformEntitiesToDTOs(
				businessobjectList, AccountDTO.class);

		for (Account a : businessobjectList) {
			for (AccountDTO d : dtoList) {

				d.setAccountNumF8(a.getAccountNumF8());
				d.setAccountNumM8(a.getAccountNumM8());
				d.setAccountNumL8(a.getAccountNumL8());
				d.setAccountType(a.getAccountType());
				d.setActualBalance(a.getActualBalance());
			}
		}
		return dtoList;
	}

	@Override
	public List<Account> transformDTOsToEntities(List<AccountDTO> dtoList)
			throws Exception {

		List<Account> accountList = super.transformDTOsToEntities(dtoList,
				Account.class);

		for (AccountDTO d : dtoList) {

			for (Account a : accountList) {

				a.setAccountNumF8(d.getAccountNumF8());
				a.setAccountNumM8(d.getAccountNumM8());
				a.setAccountNumL8(d.getAccountNumL8());
				a.setAccountType(d.getAccountType());
				a.setActualBalance(d.getActualBalance());
			}

		}

		return accountList;
	}

}

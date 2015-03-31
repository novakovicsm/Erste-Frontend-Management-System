package hu.bfo.dto;

import hu.bfo.model.AccountType;


public class AccountDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accountNumF8;
	private String accountNumM8;
	private String accountNumL8;
	private Double actualBalance;
	private AccountType accountType;
	
	
	public String getAccountNumF8() {
		return accountNumF8;
	}
	public void setAccountNumF8(String accountNumF8) {
		this.accountNumF8 = accountNumF8;
	}
	public String getAccountNumM8() {
		return accountNumM8;
	}
	public void setAccountNumM8(String accountNumM8) {
		this.accountNumM8 = accountNumM8;
	}
	public String getAccountNumL8() {
		return accountNumL8;
	}
	public void setAccountNumL8(String accountNumL8) {
		this.accountNumL8 = accountNumL8;
	}
	public Double getActualBalance() {
		return actualBalance;
	}
	public void setActualBalance(Double actualBalance) {
		this.actualBalance = actualBalance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	
}

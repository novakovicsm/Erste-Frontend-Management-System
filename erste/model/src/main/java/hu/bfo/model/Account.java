package hu.bfo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_id",unique=true, nullable=true, insertable=true, updatable=true)
	private User user;

	@Column(name = "account_num_f8")
	private String accountNumF8;

	@Column(name = "account_num_m8")
	private String accountNumM8;

	@Column(name = "account_num_l8")
	private String accountNumL8;

	@Column(name = "actual_balance")
	private Double actualBalance;

	@Column(name = "account_type")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

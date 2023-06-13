package model;

import dao.AccountDAO;

public class RegisterLogic {

	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		Boolean account_flg = dao.register(account);
		return account_flg;
	}
}

package service;

import dao.AccountDao;
import dto.Account;

public class AccountService {
	AccountDao dao= new AccountDao();
	
	
	public void makeAccount(Account acc) throws Exception{
		Account sacc =  dao.selectAccount(acc.getId());
		if (sacc != null) throw new Exception("계좌번호가 중복됩니다.");
			dao.insertAccount(acc);
	}
	
	public Account accountInfo(String id) {
		Account acc = dao.selectAccount(id);
		return acc;
	}
	
	public Account deposit(String id, String money) {
		Account acc =  dao.selectAccount(id);
		acc.deposit(Integer.parseInt(money));
		dao.updateAccount(acc);
		return acc;
	}
	
	public Account withdraw(String id, int money) {
		Account acc =  dao.selectAccount(id);
		acc.withdraw(money);
		dao.updateAccount(acc);
		return acc;
	}
	
}

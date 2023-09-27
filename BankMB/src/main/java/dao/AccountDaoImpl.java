package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Account;
import utill.MybatisSqlSessionFactory;

public class AccountDaoImpl implements AccountDao {
	
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		sqlSession.insert("mapper.account.insertAccount",acc);
		sqlSession.commit();
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		Account acc = sqlSession.selectOne("mapper.account.selectAccount",id);
		return acc;
	}

	@Override
	public void updateBalance(Account acc) throws Exception {
		sqlSession.update("mapper.account.updateBalance",acc);
		sqlSession.commit();
		
	}

	@Override
	public List<Account> selectAccountList() throws Exception {
		return sqlSession.selectList("mapper.account.selectAccountList");
	}
	

}

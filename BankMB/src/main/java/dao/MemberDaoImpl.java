package dao;

import org.apache.ibatis.session.SqlSession;

import bean.Member;
import utill.MybatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao {
	
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public void insertMember(Member member) throws Exception {
		sqlSession.insert("mapper.member.insertMember",member);
		sqlSession.commit();
	}

	@Override
	public Member selectMember(String id, String password) throws Exception {
			return sqlSession.selectOne("mapper.member.selectMember",id);
	}

}

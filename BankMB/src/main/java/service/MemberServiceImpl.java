package service;

import bean.Member;
import dao.MemberDao;
import dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public void join(Member member) throws Exception {
		memberDao.insertMember(member);
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member smember= memberDao.selectMember(id, password);
		if (smember.getPassword().equals(password)) {
			return smember;
		}else throw new Exception("비밀번호가 틀립니다.");
	}
}

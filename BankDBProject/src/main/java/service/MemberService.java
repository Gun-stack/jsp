package service;


import dao.MemberDao;
import dto.Member;

public class MemberService {
	MemberDao dao = new MemberDao();
	public void join(Member member) {
		dao.insertMember(member);
	}
	
	public Member login(String id,String password) throws Exception{
		Member member = dao.selectMember(id);
		if(member==null) {throw new Exception("아이디가틀립니다.");}
		if(!(member.getPassword().equals(password))) throw new Exception("비밀번호가 틀립니다.");
		member.setPassword(null);
		return member;
	}
}

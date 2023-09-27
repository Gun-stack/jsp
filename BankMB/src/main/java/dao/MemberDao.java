package dao;

import bean.Member;

public interface MemberDao {
	void insertMember(Member member) throws Exception;
	
	Member selectMember(String id,String password) throws Exception;
}

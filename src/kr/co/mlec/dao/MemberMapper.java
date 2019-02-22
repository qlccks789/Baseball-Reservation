package kr.co.mlec.dao;

import kr.co.mlec.domain.Member;

public interface MemberMapper {
	// 회원가입
	void insertMemberInfo(Member member);
	
	// 중복검사
	Member selectMemberInfo(String member);
	
	void updateMemberInfo(Member member);
	
	void deleteMemberInfo(String id);
}

package kr.co.mlec.controller.baseballController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.dao.MemberMapper;
import kr.co.mlec.domain.Member;

public class InsertMemberInfoController extends ScannerController {
	
	private MemberMapper mapper;
	public InsertMemberInfoController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(MemberMapper.class);
	}
	
	public void service() {
		System.out.println();
		UtilController.print(30, "=");
		System.out.println("회원가입");
		UtilController.print(30, "=");
		
		while(true) {
			Member member = new Member();
			
			String id = input("아이디: ");
			//아이디 중복검사
			Member memberId = mapper.selectMemberInfo(id);
			if(memberId != null) {
				System.out.println("중복된아이디입니다.");
				return;
			}
			
			member.setMemberId(id);
			member.setPassword(input("비밀번호: "));
			
			if(member.getMemberId().equals("")|| member.getPassword().equals("")) {
				System.out.println("내용을 입력하세요.");
				return;
			}
			
			System.out.println("회원가입 성공!");
			System.out.println();
			mapper.insertMemberInfo(member);	
			return;
		}
	}

}
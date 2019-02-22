//회원 탈퇴
package kr.co.mlec.controller.memberController;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.baseballController.BaseballController;
import kr.co.mlec.dao.MemberMapper;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class DeleteMemberController extends ScannerController {
	
	Member member = null;
	private MemberMapper mapper;
	public DeleteMemberController() {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(MemberMapper.class);
      member = LogIn.getId();
	}
	
	public void service() {
		System.out.println();
		System.out.println("회원탈퇴");
		UtilController.print(30, "=");
		System.out.println("1. 탈퇴");
		System.out.println("0. 이전");
		UtilController.print(30, "=");
		int menu = Integer.parseInt(input("선택 : "));
		
		switch(menu){
			case 1:
				// 탈퇴
				System.out.println(member.getMemberId()+"님 감사합니다.");
				mapper.deleteMemberInfo(member.getMemberId());
				System.out.println("탈퇴가 완료되었습니다.");
				System.out.println();
				
				BaseballController bc = new BaseballController();
				bc.service();
				break;
			case 0:	
				// 이전
				UpdateMemberController umc = new UpdateMemberController();
				umc.service();
				break;
			default :
				System.out.println("잘못된 메뉴선택입니다.");
				System.out.println("다시 선택해 주세요.");
				return;
		}
		
	}

}
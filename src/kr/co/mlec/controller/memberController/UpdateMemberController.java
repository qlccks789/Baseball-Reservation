package kr.co.mlec.controller.memberController;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.dao.MemberMapper;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class UpdateMemberController extends ScannerController {

	Member member = null;
	private MemberMapper mapper;
	public UpdateMemberController() {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(MemberMapper.class);
      member = LogIn.getId();
	}
	
	
	public void service() {
		System.out.println();
		System.out.println("회원정보");
		System.out.println("아이디 : " + member.getMemberId());
		
		while(true) {
			switch(menu()) {
			case 1:
				// 비밀번호 수정
				UpdatePasswordController upc = new UpdatePasswordController();
				upc.service();
				break;
			case 2:
				// 회원 탈퇴
				DeleteMemberController dmc = new DeleteMemberController();
				dmc.service();
				break;
			case 0:
				//회원화면으로
//				MemberController mc = new MemberController();
//				mc.service();
				return;
			default :
				System.out.println("잘못된 메뉴선택입니다.");
				System.out.println("다시 선택해 주세요.");
				return;
			}
		}
	}
	
	public int menu() {
		System.out.println();
		UtilController.print(30, "=");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 회원 탈퇴");
		System.out.println("0. 이전");
		UtilController.print(30, "=");
		return Integer.parseInt(input("메뉴를 선택하세요: "));
	}
	
}
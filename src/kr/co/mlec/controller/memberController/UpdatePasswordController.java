package kr.co.mlec.controller.memberController;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.dao.MemberMapper;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class UpdatePasswordController extends ScannerController {
	
	Member member = null;
	private MemberMapper mapper;
	public UpdatePasswordController() {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(MemberMapper.class);
      member = LogIn.getId();
	}
	
	public void service() {
		System.out.println();
		System.out.println("비밀번호 변경");
		UtilController.print(30, "=");
		
		member.setPassword(input("변경할 비밀번호: "));
		String pass = input("비밀번호 확인: ");
		
		if(member.getPassword().equals(pass)) {
			Member temp = new Member();
			temp.setMemberId(member.getMemberId());
			temp.setPassword(pass);
			
			mapper.updateMemberInfo(temp);
			System.out.println("비밀번호가 변경되었습니다.");
			return;
		}
		System.out.println("비밀번호가 일치하지 않습니다.");
		return;
	}

}
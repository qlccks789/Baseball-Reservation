package kr.co.mlec.controller.baseballController;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.memberController.MemberController;
import kr.co.mlec.dao.MemberMapper;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class LogInController extends ScannerController{
   
   private MemberMapper mapper;
   public LogInController() {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(MemberMapper.class);
   }
   
   public String id;
   
   public void service() {
	  System.out.println(); 
	  UtilController.print(30, "=");
      System.out.println("로그인");
      UtilController.print(30, "=");
      while(true) {
         id = input("아이디 : ");
         Member memberId = mapper.selectMemberInfo(id);
         if(memberId == null) {
        	 System.out.println("로그인 실패. 아이디를 확인해주세요.");
        	 System.out.println();
        	 return;
         }
         String password = input("비밀번호 : ");
         
         if(memberId.getMemberId().equals(id) && memberId.getPassword().equals(password)) {
            System.out.println("로그인 성공!");
            System.out.println();
            LogIn.setId(memberId);
            
            MemberController mc = new MemberController();
            mc.service();
            
         }else{
            System.out.println("로그인 실패.");
            System.out.println("아이디와 비밀번호를 확인해주세요");
            System.out.println();
            return;
         }
      }
   }
    

   
}



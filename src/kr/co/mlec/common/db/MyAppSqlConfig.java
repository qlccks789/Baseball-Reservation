package kr.co.mlec.common.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//전체 환경설정을 로딩하는 클래스
public class MyAppSqlConfig {   
	private static final SqlSession sqlMapper;
	static {
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";
			// 환경설정과 관련된 것들을 얻어오는 코드이다.
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlMapper = sqlFactory.openSession(true); // true : 자동커밋  
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}
	
	// 호출할때 : static 이기 때문에 클래스.메서드(); 로 접근해야한다..  		-> MyAppSqlConfig.getSqlSession();
	// SqlSeesion 타입으로 생성됐기때문에 받을 때도 SqlSession으로 받아야한다. 	-> SqlSession session = 
	// 호출 : SqlSession session = MyAppSqlConfig.getSqlSession();
	public static SqlSession getSqlSession() {		// SqlSession 을 반환해주는 메서드
		return sqlMapper;
	}
}
package day1223;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day1219.DeptDTO;
import kr.co.sist.dao.MyBatisHandler;

public class TestMyBatisDAO {
	public void insertBoard() {
		// 1. MyBatis Handler얻기
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		
		// 2. method 호출
	    int cnt = ss.insert("day1223.nonParameter");
		// 3. 결과 얻기
		System.out.println(cnt+"건 추가");
		// 4. MyBatis Handler 닫기
//		if(cnt==1) {
//			ss.commit();
//		}
		if(ss!=null) {
			ss.close();
		}//end if
		
	}
	public void insertCpDept(DeptDTO dDTO) {
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		int cnt=ss.insert("day1223.insertDept",dDTO);
		System.out.println(cnt+"건 추가");
		if(ss!=null) {ss.close();}
	}
	
	public void insertCpDept2(DeptDTO dDTO) {
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		int cnt=ss.insert("day1223.insertDept2",dDTO);
		System.out.println(cnt+"건 추가");
		if(ss!=null) {ss.close();}
	}
	
	public static void main(String[] args) {
		try {
//		new TestMyBatisDAO().insertBoard();
		DeptDTO dDTO=new DeptDTO(60, "QA","경기도");
		new TestMyBatisDAO().insertCpDept2(dDTO);
		}catch(PersistenceException pe){
			System.err.println("문제 발생");
			pe.printStackTrace();
		}
	}
	
}

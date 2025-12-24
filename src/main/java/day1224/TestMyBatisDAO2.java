package day1224;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day1219.DeptDTO;
import kr.co.sist.dao.MyBatisHandler;

public class TestMyBatisDAO2 {
	
	public void updateNonParameter() throws PersistenceException{
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		//2. 쿼리문 찾아서 parsing한 후 실행
		int cnt = ss.update("day1224.updateNonParameter");
		//3. 실행 결과 받기
		System.out.println(cnt + "건 변경");
		//4. MyBatis Handler 닫기
		if(ss!=null) {ss.close();}
	}//updateNonParameter
	
	public void updateCpDept(DeptDTO dDTO) throws PersistenceException{
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		//2. 쿼리문 찾아서 parsing한 후 실행
		int cnt = ss.update("day1224.updateCpDept");
		//3. 실행 결과 받기
		System.out.println(cnt + "건 변경");
		//4. MyBatis Handler 닫기
		if(ss!=null) {ss.close();}
	}//updateNonParameter
	
	public void deleteNonParameter() throws PersistenceException{
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		//2. 쿼리문 찾아서 parsing한 후 실행
		int cnt = ss.delete("day1224.deleteCpDept");
		//3. 실행 결과 받기
		System.out.println(cnt + "건 삭제");
		//4. MyBatis Handler 닫기
		if(ss!=null) {ss.close();}
	}//updateNonParameter
	
	public void deleteParameter(int deptno) throws PersistenceException{
		//1. MyBatis Handler 얻기
		SqlSession ss= MyBatisHandler.getInstance().getMyBatisHandler(true);
		//2. 쿼리문 찾아서 parsing한 후 실행
		int cnt = ss.delete("day1224.deleteCpDeptNo",deptno);
		//3. 실행 결과 받기
		System.out.println(cnt + "건 삭제");
		//4. MyBatis Handler 닫기
		if(ss!=null) {ss.close();}
	}//updateNonParameter
	
	public static void main(String[] args) {
		try {
//			new TestMyBatisDAO2().updateNonParameter();
//			new TestMyBatisDAO2().updateParameter(43);
//			DeptDTO dDTO=new DeptDTO(90, "SM","인천");
//			new TestMyBatisDAO2().updateCpDept(dDTO);
//			new TestMyBatisDAO2().deleteNonParameter();
			new TestMyBatisDAO2().deleteParameter(20);
		}catch(PersistenceException pe){
			System.err.println("문제 발생");
			pe.printStackTrace();
		}
	}
	
}

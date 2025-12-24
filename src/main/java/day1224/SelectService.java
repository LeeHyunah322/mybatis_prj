package day1224;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class SelectService {
	private static SelectService ss;
	
	private SelectService() {
		
	}
	public static SelectService getInstance() {
		if(ss==null) {
			ss=new SelectService();
		}
		return ss;
	}//getInstance
	
	/**
	 * 부서번호를 입력하면 부서명을 검색
	 * @param deptno 
	 * @return
	 */
	public String scsr(int deptno) {
		String dname="";
		SelectDAO sDAO=SelectDAO.getInstance();
		try {
			dname=sDAO.scsr(deptno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return dname;
	}
	
	public List<String> scmr(int deptno){
		List<String> list=null;
		SelectDAO sDAO=SelectDAO.getInstance();
		
		try {
			list=sDAO.scmr(deptno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}//scmr

	/**
	 * 사원번호를 입력받아 사원정보를 검색.
	 * @param empno
	 * @return
	 */
	public EmpDTO mcsr(int empno) {
		EmpDTO eDTO=null;
		SelectDAO sDAO=SelectDAO.getInstance();
		try {
			eDTO=sDAO.mcsr(empno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return eDTO;
	}
	
	public List<EmpDTO> mcmr(int deptno){
		List<EmpDTO> list=null;
		
		SelectDAO sDAO=SelectDAO.getInstance();
		
		try {
			list=sDAO.mcmr(deptno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//scmr
}//class

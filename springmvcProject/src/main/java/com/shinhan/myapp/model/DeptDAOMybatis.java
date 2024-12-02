package com.shinhan.myapp.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.vo.DeptDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("deptMybatis")

public class DeptDAOMybatis implements DeptDAOInterface {
	
	String namespace = "com.shinhan.dept.";
	
	// DB���� �� DataSource �� sqlSessionFactory �� sqlSession
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = sqlSession.selectList(namespace + "selectAll");
		
		log.info("dept��ȸ�Ǽ�:" + deptlist.size());
		
		return deptlist;
	}

	@Override
	public DeptDTO selectById(int dept_id) {
		DeptDTO dept = sqlSession.selectOne(namespace + "selectById", dept_id);
		
		log.info("dept 1��:" + dept);
		
		return dept;
	}

	@Override
	public int insert(DeptDTO dept) {
		int result = sqlSession.insert(namespace + "insert", dept);
		
		log.info("�Է°Ǽ�:" + result);
		
		return result;
	}

	@Override
	public int update(DeptDTO dept) {
		int result = sqlSession.update(namespace + "update", dept);
		
		log.info("�����Ǽ�:" + result);
		
		return result;
	}

	@Override
	public int delete(int dept_id) {
		int result = sqlSession.delete(namespace + "delete", dept_id);
		
		log.info("�����Ǽ�:" + result);
		
		return result;
	}

}

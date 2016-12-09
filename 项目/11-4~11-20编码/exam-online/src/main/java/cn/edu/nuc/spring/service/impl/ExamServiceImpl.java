package cn.edu.nuc.spring.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.ExamMapper;
import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.service.interfaces.IExamService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
@Service
public class ExamServiceImpl extends BaseServiceImpl implements IExamService {
	@Autowired
	private ExamMapper examMapper;

	@Override
	public PageInfo<Exam> examLists(Exam exam, PageControl pc) {
		PageInfo<Exam> pi=new PageInfo<>();
		List<Exam> examLists=examMapper.examLists(exam,pc);
		Integer count = rsCount(exam);
		Integer c=0;
		if(count!=null){
			c=count;
		}
		pi.setLists(examLists);
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}
	private Integer rsCount(Exam exam){
		Integer count = examMapper.rsCount(exam);
		return count;
	}
	@Override
	public void add(Exam exam)throws SqlSessionException {
		try{
			examMapper.insert(exam);
		}catch(SqlSessionException e){
			throw new SqlSessionException("添加失败!");
		}
	}

}

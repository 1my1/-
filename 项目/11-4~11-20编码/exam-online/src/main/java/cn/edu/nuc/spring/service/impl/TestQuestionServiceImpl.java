package cn.edu.nuc.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.TestQuestionMapper;
import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.service.interfaces.ITestQuestion;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
@Service
public class TestQuestionServiceImpl extends BaseServiceImpl implements ITestQuestion {
	@Autowired
	private TestQuestionMapper testQuestionMapper;

	public PageInfo<TestQuestion> testQuestionLists(TestQuestion testQuestion, PageControl pc) {
		PageInfo<TestQuestion> pi=new PageInfo<TestQuestion>();
		List<TestQuestion> testQuestionLists=testQuestionMapper.testQuestionLists(testQuestion,pc);
		pi.setLists(testQuestionLists);
		Integer count=rsCount(testQuestion);
		Integer c=0;
		if(count!=null){
			c=count;
		}
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}
	private Integer rsCount(TestQuestion testQuestion) {
		Integer count=testQuestionMapper.rsCount(testQuestion);
		{
			return count;
		}
	}
	public boolean addTq(TestQuestion testQuestion) {

		Integer count=testQuestionMapper.insert(testQuestion);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public TestQuestion findTqByTqId(Integer tqid) {
		TestQuestion testQuestion=testQuestionMapper.selectByPrimaryKey(tqid);
		return testQuestion;
	}
	@Override
	public List<Course> courseLists() {
		
		List<Course> courseLists=testQuestionMapper.courseLists();
		
		return courseLists;
	}
	@Override
	public boolean updateTitleTqid(List<Integer> titids, Integer tqid) {
        int len=titids.size();
		for(int i=0;i<len;i++){
			int count=testQuestionMapper.updateTitleTqid(titids.get(i),tqid);
			if(count>0){
				continue;
			}else{
				return false;
			}
		}
		
		return true;
	}
	@Override
	public List<TestQuestion> tqLists() {

		List<TestQuestion> tqLists=testQuestionMapper.tqLists();
		
		return tqLists;
	}

}

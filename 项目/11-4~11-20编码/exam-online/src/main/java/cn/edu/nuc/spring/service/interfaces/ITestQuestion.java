package cn.edu.nuc.spring.service.interfaces;

import java.util.List;

import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

public interface ITestQuestion extends IBaseService {
	
	PageInfo<TestQuestion> testQuestionLists(TestQuestion testQuestion, PageControl pc);
	
	public boolean addTq(TestQuestion testQuestion);

	TestQuestion findTqByTqId(Integer tqid);

	List<Course> courseLists();

	boolean updateTitleTqid(List<Integer> titids, Integer tqid);

	List<TestQuestion> tqLists();

}

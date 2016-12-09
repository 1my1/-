package cn.edu.nuc.spring.service.interfaces;

import java.util.List;

import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

public interface ITitleService extends IBaseService {

	
	PageInfo<Title> titleLists(Title title,PageControl pc);

	boolean delete(Integer titid);

	//List<TestQuestion> tqLists();

	List<Course> courseLists();

	boolean addTitle(Title title);

	Title findTitleById(Integer titid);

	boolean update(Title title);

	List<TestQuestion> tqLists();
}

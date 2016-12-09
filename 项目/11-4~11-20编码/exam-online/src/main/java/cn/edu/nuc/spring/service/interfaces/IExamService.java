package cn.edu.nuc.spring.service.interfaces;

import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

public interface IExamService extends IBaseService{

	PageInfo<Exam> examLists(Exam exam, PageControl pc);

	void add(Exam exam);

}

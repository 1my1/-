package cn.edu.nuc.spring.service.interfaces;

import java.util.List;

import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.entity.ExamFinished;
import cn.edu.nuc.spring.entity.Student;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;

public interface IStudentService extends IBaseService{

	Student checklogin(Student student, String sessionid);

	List<Exam> examLists(String name);

	Exam getExamById(Integer examid);

	TestQuestion getExamPaperById(Integer tqid);

	List<Title> titleLists(Integer tqid);

	boolean addExamFinished(ExamFinished ef);

	List<ExamFinished> historyExamList(String stuname);

}

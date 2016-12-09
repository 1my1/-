package cn.edu.nuc.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.ExamFinishedMapper;
import cn.edu.nuc.spring.dao.ExamMapper;
import cn.edu.nuc.spring.dao.StudentMapper;
import cn.edu.nuc.spring.dao.TestQuestionMapper;
import cn.edu.nuc.spring.dao.TitleMapper;
import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.entity.ExamFinished;
import cn.edu.nuc.spring.entity.Student;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.service.interfaces.IStudentService;
import cn.edu.nuc.spring.util.PageControl;
@Service
public class StudentServiceImpl extends BaseServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private ExamMapper examMapper;
	
	@Autowired
	private TestQuestionMapper testQuestionMapper;
	
	@Autowired
	private TitleMapper titleMapper;
	
	@Autowired
	private ExamFinishedMapper examFinishedMapper;

	@Override
	public Student checklogin(Student student,String sessionid) {
        Student stu=studentMapper.selectOneStudent(student);
		
		
		if(stu==null){
			Log.debug("管理员登录失败----->返回值为空");
			return null;
		}else{
			if(!stu.getSessionid().equals(sessionid)){
				int count=updateSessionID(sessionid,stu.getStuname(),stu.getStuid());
				if(count>0)
					stu.setSessionid(sessionid);
			}
			return stu;
		}
	}
	private int updateSessionID(String sessionid,String stuname,Integer stuid){
		
		int count=studentMapper.updateSessionID(sessionid,stuname,stuid);
		if(count<0){
			return -1;
		}
		return count;
	}
	@Override
	public List<Exam> examLists(String stuname) {

		List<Exam> examLists=studentMapper.examLists(stuname);
		
		return examLists;
	}
	@Override
	public Exam getExamById(Integer examid) {
		Exam exam=examMapper.selectByPrimaryKey(examid);
		return exam;
	}
	@Override
	public TestQuestion getExamPaperById(Integer tqid) {
		
		TestQuestion tq=testQuestionMapper.selectByPrimaryKey(tqid);
		
		return tq;
	}
	@Override
	public List<Title> titleLists(Integer tqid) {
		Title title=new Title();
		PageControl pc=new PageControl();
        title.setTqid(tqid);
		List<Title> titleLists=titleMapper.titleLists(title,pc);
		return titleLists;
	}
	@Override
	public boolean addExamFinished(ExamFinished ef) {

		Integer count=examFinishedMapper.insertSelective(ef);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public List<ExamFinished> historyExamList(String stuname) {

		List<ExamFinished> efList=studentMapper.historyExamList(stuname);
		
		return efList;
	}
	
	

}

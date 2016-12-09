package cn.edu.nuc.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.entity.ExamFinished;
import cn.edu.nuc.spring.entity.Student;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.service.interfaces.IStudentService;
import cn.edu.nuc.spring.util.SessionUtil;
@Controller
@RequestMapping(value="/student")
public class StudentController extends BaseController {
	@Autowired
	private IStudentService studentServiceImpl;
	
	@RequestMapping(value="/exam",method=RequestMethod.GET)
	public String exam(HttpSession session,Model model){
        
		Student student=(Student)session.getAttribute("student");
		if(student==null){
			model.addAttribute("examLists",null);
		}else{
			List<Exam> examLists=studentServiceImpl.examLists(student.getStuname());
			model.addAttribute("examLists",examLists);
		}
		return "exam";
	}
	@RequestMapping(value="/examing/{examid}",method=RequestMethod.GET)
	public String examing(Model model,@PathVariable("examid")Integer examid){
		        //声明试卷作答时长
				int duration = 0;
				//根据考试id获取考试实体
				Exam exam = studentServiceImpl.getExamById(examid);
				//根据试卷id获取试卷实体
				TestQuestion tq =studentServiceImpl.getExamPaperById(exam.getTqid());
				//获取试卷的内容
				
				List<Title> titleLists  = studentServiceImpl.titleLists(tq.getTqid());
				
                 
				//获取试卷作答时长
				duration = tq.getDuration();
				//获取考试开始时间
				Date startTime = exam.getExamstarttime();
				//将需要的信息存入属性变量中，供页面使用
				model.addAttribute("startTime", startTime);
				model.addAttribute("duration", duration*60);
				model.addAttribute("examPaperId", tq.getTqid());
				model.addAttribute("examId", exam.getExamid());
				model.addAttribute("questionList", titleLists);
		return "examing";
	}
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	public String check_login(Student student,HttpServletRequest request,Model model){
		HttpSession session=SessionUtil.getSessionByRequest(request,true);
		String sessionid=session.getId();
		
		Student stu = studentServiceImpl.checklogin(student,sessionid);
		if(stu==null){
			model.addAttribute("error","登录失败！");
			return "forward:login";
		}else{
			session.setAttribute("student",stu);
			return "redirect:home";
		}
	}
	@RequestMapping(value="/exam-history",method=RequestMethod.GET)
	public String exam_history(Model model,String stuname){
		List<ExamFinished> efList=studentServiceImpl.historyExamList(stuname);
		model.addAttribute("efList",efList);
		return "exam-history";
	}
	@RequestMapping(value="/finished-submit",method=RequestMethod.GET)
	public String finished_submit(){

		
		
		return "finished";
	}
	@RequestMapping(value="/submit-finished",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submit_finished(@RequestBody ExamFinished ef){
        Map<String,Object> map=new HashMap<String,Object>();
        System.out.println("1111111------>"+ef);
		boolean flag=studentServiceImpl.addExamFinished(ef);
		if(flag){
			
		}
		return map;
	}
	@RequestMapping(value="/usercenter",method=RequestMethod.GET)
	public String user_center(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		Student stu = (Student) session.getAttribute("student");
		model.addAttribute("student", stu);
		return "usercenter";
	}
	@RequestMapping(value="/finished",method=RequestMethod.GET)
	public String finished(){
		return "finished";
	}
	@RequestMapping(value="/pratice-improve-qh",method=RequestMethod.GET)
	public String pratice$improve$qh(){
		return "pratice-improve-qh";
	}
	@RequestMapping(value="/pratice",method=RequestMethod.GET)
	public String pratice(){
		return "pratice";
	}

}

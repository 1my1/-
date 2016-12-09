package cn.edu.nuc.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.service.impl.ClassesServiceImpl;
import cn.edu.nuc.spring.service.interfaces.IClassesService;
import cn.edu.nuc.spring.service.interfaces.IExamService;
import cn.edu.nuc.spring.service.interfaces.ITestQuestion;
import cn.edu.nuc.spring.service.interfaces.ITitleService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

@Controller
@RequestMapping(value="/admin")
public class ExamController extends BaseController {
	@Autowired
	private IExamService examServiceImpl;
	
	@Autowired
	private ITestQuestion testQuestionServiceImpl;
	
	@Autowired
	private IClassesService classesServiceImpl;
	
	@RequestMapping(value="/exam/index",method=RequestMethod.GET)
	public String exam_index(Exam exam,Integer currindex,Model model){
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(7);
		PageInfo<Exam> pi=examServiceImpl.examLists(exam,pc);
		List<TestQuestion> tqLists=testQuestionServiceImpl.tqLists();
		List<Classes> classesLists=classesServiceImpl.claList();
		//List<Course> courseLists=testQuestionServiceImpl.courseLists();
		//model.addAttribute("courseLists", courseLists);
		model.addAttribute("tqLists", tqLists);
		model.addAttribute("examname", exam);
		model.addAttribute("pi", pi);
		model.addAttribute("classesLists",classesLists);
		return "admin/exam/index";
	}
	@RequestMapping(value="/exam/doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> exam_add(Exam exam){
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				examServiceImpl.add(exam);
				map.put("statusCode", 200);
				map.put("success", true);
				map.put("message", "保存成功");
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			map.put("statsuCode", 300);
			map.put("success", false);
			map.put("message", "请不要重复提交");
		}
		return map;
	}

}

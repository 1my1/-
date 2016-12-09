package cn.edu.nuc.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.service.interfaces.ITestQuestion;
import cn.edu.nuc.spring.service.interfaces.ITitleService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

@Controller
@RequestMapping(value="/admin")
public class TestQuestionController extends BaseController {
	@Autowired
	private ITestQuestion testQuestionServiceImpl;
	
	@Autowired
	private ITitleService titleServiceImpl;
	
	@RequestMapping(value="/testQuestion/index",method=RequestMethod.GET)
	public String testQuestion_index(TestQuestion testQuestion,Integer currindex,Model model){
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(7);
		PageInfo<TestQuestion> pi=testQuestionServiceImpl.testQuestionLists(testQuestion,pc);
		//List<TestQuestion> tqLists=titleServiceImpl.tqLists();
		List<Course> courseLists=testQuestionServiceImpl.courseLists();
		model.addAttribute("courseLists", courseLists);
		//model.addAttribute("tqLists", tqLists);
		model.addAttribute("testQuestionname", testQuestion);
		model.addAttribute("pi", pi);
		return "admin/exampaper/index";
	}
	
	@RequestMapping(value="/testQuestion/doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> testQuestion_doAdd(TestQuestion testQuestion){
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag=testQuestionServiceImpl.addTq(testQuestion);
		if(flag){
			map.put("message","添加成功！");
			map.put("tqid",testQuestion.getTqid());
		}else{
			map.put("message","添加失败！");
		}
		return map;
	}
	@RequestMapping(value="/testQuestion/update",method=RequestMethod.GET)
	public String question_update(Integer tqid,Model model){
		TestQuestion testQuestion=testQuestionServiceImpl.findTqByTqId(tqid);
		List<Course> courseLists=testQuestionServiceImpl.courseLists();
		model.addAttribute("courseLists", courseLists);
		model.addAttribute("testQuestion", testQuestion);
		return "admin/exampaper/update";
		
	}
	@RequestMapping(value="/testQuestion/questionlist",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> question_Lists(Title title,Integer currindex,Model model){
		Map<String,Object> map=new HashMap<String,Object>();
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(1);
		PageInfo<Title> pi=titleServiceImpl.titleLists(title,pc);
		map.put("message","添加成功！");
		map.put("pi",pi);
		return map;
	}
	
	@RequestMapping(value="/testQuestion/doUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> testquestion_doUpdate(Integer tqid,String content){
		Map<String,Object> map=new HashMap<String,Object>();
		String[] titids=content.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<titids.length;i++){
			ids.add(Integer.parseInt(titids[i]));
		}
	    boolean flag=testQuestionServiceImpl.updateTitleTqid(ids,tqid);
	    if(flag){
	    	map.put("message","试卷生成成功！");
	    }else{
	    	map.put("message", "试卷生成失败！");
	    }
		return map;
	}

}

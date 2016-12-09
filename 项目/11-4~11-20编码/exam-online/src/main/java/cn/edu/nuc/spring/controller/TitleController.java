package cn.edu.nuc.spring.controller;


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
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.service.interfaces.ITitleService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
@Controller
@RequestMapping(value="/admin")
public class TitleController extends BaseController {
	@Autowired
	private ITitleService titleServiceImpl;
	
	
	@RequestMapping(value="/question/index",method=RequestMethod.GET)
	public String question_index(Title title,Integer currindex,Model model){
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(7);
		PageInfo<Title> pi=titleServiceImpl.titleLists(title,pc);
		//List<TestQuestion> tqLists=titleServiceImpl.tqLists();
		List<Course> courseLists=titleServiceImpl.courseLists();
		model.addAttribute("courseLists", courseLists);
		//model.addAttribute("tqLists", tqLists);
		model.addAttribute("titlename", title);
		model.addAttribute("pi", pi);
		return "admin/question/index";
	}
	@RequestMapping(value="/question/doDelete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> question_delete(Integer titid){
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag=titleServiceImpl.delete(titid);
		if(flag){
			map.put("message","删除成功！");
		}else{
			map.put("message","删除失败！");
		}
		return map;
	}
	@RequestMapping(value="/question/doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> question_add(Title title){
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag = titleServiceImpl.addTitle(title);
		if(flag){
			map.put("message", "添加成功！");
		}else{
			map.put("message", "添加失败！");
		}
		return map;
	}
	@RequestMapping(value="/question/update",method=RequestMethod.GET)
	public String question_update(Integer titid,Model model){
		
		Title title=titleServiceImpl.findTitleById(titid);
		List<Course> courseLists=titleServiceImpl.courseLists();
		model.addAttribute("courseLists", courseLists);
		model.addAttribute("title", title);
		return "admin/question/update";
	}
	@RequestMapping(value="/question/doUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> question_doUpdate(Title title){
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag=titleServiceImpl.update(title);
		if(flag){
			map.put("message","修改成功！");
		}else{
			map.put("message","修改失败！");
		}
		return map;
	}

}

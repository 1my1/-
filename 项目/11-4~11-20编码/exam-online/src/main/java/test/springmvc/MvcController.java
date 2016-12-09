package test.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.spring.controller.BaseController;
import cn.edu.nuc.spring.service.interfaces.IAdminService;
import spring.test.HelloWorld;

@Controller
public class MvcController extends BaseController{
	
	@Autowired
	HelloWorld h;
	@Autowired
	IAdminService adminServiceImpl;
    @RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request){
    	Log.debug("------------------------------");
    	Log.error("---------------------------");
    	Log.info("---------------------------");
    	System.out.println(request.getParameter("name"));
    	System.out.println(request.getCharacterEncoding());
    	System.out.println(adminServiceImpl.find(1));
    	System.out.println(h.getName()+"<--------");
		return "login";
	}
    @RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		return "register";
	}
    
    @RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin(){
		return "admin/login";
	}
    @RequestMapping(value="/usercenter",method=RequestMethod.GET)
    public String usercenter(){
    	return "usercenter";
    }
    @RequestMapping(value="/exam",method=RequestMethod.GET)
    public String exam(){
    	return "exam";
    }
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
    	return "home";
    }
    @RequestMapping(value="/practice-list",method=RequestMethod.GET)
    public String practice$list(){
    	return "practice-improve-qh";
    }
    @RequestMapping(value="admin/user/index",method=RequestMethod.GET)
    public String user_index(){
    	return "admin/user/index";
    }
    @RequestMapping(value="admin/user/group",method=RequestMethod.GET)
    public String user_group(){
    	return "admin/user/group";
    }
    @RequestMapping(value="/exam_index",method=RequestMethod.GET)
    public String exam_index(){
    	return "admin/exam/index";
    }
    @RequestMapping(value="/question_index",method=RequestMethod.GET)
    public String question_index(){
    	return "admin/question/index";
    }
    @RequestMapping(value="/exampaper_index",method=RequestMethod.GET)
    public String exampaper_index(){
    	return "admin/exampaper/index";
    }
    @RequestMapping(value="admin_index",method=RequestMethod.GET)
    public String amdin_index(){
    	return "admin/index";
    }
    
	
}

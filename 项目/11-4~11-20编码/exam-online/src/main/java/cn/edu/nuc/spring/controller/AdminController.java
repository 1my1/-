package cn.edu.nuc.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nuc.spring.entity.Admin;
import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.entity.Dept;
import cn.edu.nuc.spring.entity.Role;
import cn.edu.nuc.spring.service.interfaces.IAdminService;
import cn.edu.nuc.spring.service.interfaces.IClassesService;
import cn.edu.nuc.spring.service.interfaces.IDeptService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
import cn.edu.nuc.spring.util.SessionUtil;
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Autowired
	private IAdminService adminServiceImpl;
	@Autowired
	private IClassesService classesServiceImpl;
	@Autowired
	private IDeptService deptServiceImpl;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		//System.out.println(id);
		return "admin/index";
	}
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "admin/login";
	}
	@RequestMapping(value="checklogin",method=RequestMethod.POST)
	public String checklogin(Admin admin,HttpServletRequest request,Errors error,Model model){
		if(error.hasErrors()){
			return "admin/login";
		}
		HttpSession session=SessionUtil.getSessionByRequest(request, true);
		System.out.println(session.getId());
		//admin.setAdsessionid(session.getId());
		//a.setAdsessionid(session.getId());
		//session.setAttribute("admin", a);
		Admin a=adminServiceImpl.checklogin(admin,session.getId());
		session.setAttribute("admin",a);
		if(a==null){
			model.addAttribute("error", "登录失败!");
			return "admin/login";
		}
		return "redirect:index";
	}
	@RequestMapping(value="/user/index",method=RequestMethod.GET)
	public String user_index(Admin admin,Integer currindex,Model model){
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(7);
		model.addAttribute("adname",admin);
		PageInfo<Admin> pi=adminServiceImpl.adminLists(admin,pc);
		List<Role> roleLists=adminServiceImpl.loadRole();
		model.addAttribute("pi", pi);
		model.addAttribute("roleLists", roleLists);
		return "admin/user/index";
	}
	@RequestMapping(value="/user/doDelete",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> user_delete(Integer adid){
		Map<String,Object> map=new HashMap<>();
		System.out.println("adid======="+adid);
		boolean flag=adminServiceImpl.delete(adid);
		if(flag){
			map.put("success","删除成功！");
		}else{
			map.put("success","删除失败！");
		}
		return map;
	}
	@RequestMapping(value="/user/deleteMany",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete_many(String adids){
		Map<String,Object> map=new HashMap<>();
		System.out.println(adids+"=======adids");
		String str[]=adids.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<str.length;i++){
			ids.add(Integer.parseInt(str[i]));
		}
		boolean flag=adminServiceImpl.deleteMany(ids);
		System.out.println(flag+"=========flag");
		if(flag){
			map.put("success","删除成功！");
		}else{
			map.put("success","删除失败！");
		}
		return map;
	}
	/**
	 * 加载所有的角色
	 * @param model
	 * @param request
	 * @param session
	 */
	@RequestMapping(value="/user/loadRole",method=RequestMethod.POST)
	@ResponseBody
	public void load_role(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.setAttribute("message", "角色");
		List<Role> roleLists=adminServiceImpl.loadRole();
		System.out.println(roleLists);
		session.setAttribute("roleLists",roleLists);
//		try {
//			request.getRequestDispatcher("admin/user/index").forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
	}
	
	/**
	 * 添加
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/user/doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add_user(Admin admin){
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println(admin+"=================");
		boolean flag=adminServiceImpl.addAdmin(admin);
		if(flag){
			map.put("success","添加成功！");			
		}else{
			map.put("success","添加失败！");			
		}
		//System.out.println("admin====="+admin);
		return map;
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.GET)
	public String toUpdate(Integer adid,Model model){
		if(adid==null){
			return "admin/user/index";
		}
		Admin admin=adminServiceImpl.find(adid);
		List<Role> roleLists=adminServiceImpl.loadRole();
		model.addAttribute("updateRoleLists",roleLists);
		model.addAttribute("updateAdmin",admin);
		return "admin/user/update";
	}
	@RequestMapping(value="/user/doUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doUpdate(Admin admin){
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println(admin+"==================admin");
		boolean flag=adminServiceImpl.doUpdate(admin);
		if(flag){
			map.put("message", "修改成功！");
		}else{
			map.put("message","修改失败！");
		}
		return map;
	}
	@RequestMapping(value="/classes/index",method=RequestMethod.GET)
	public String classes_index(Classes classes,Integer currindex,Model model){
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(7);
		model.addAttribute("classesname",classes);
		PageInfo<Classes> pi=classesServiceImpl.classesLists(classes,pc);
		model.addAttribute("pi", pi);
		return "admin/classes/index";
	}
	@RequestMapping(value="/dept/index",method=RequestMethod.GET)
	public String dept_index(Dept dept,Integer currindex,Model model){
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(7);
		model.addAttribute("deptname",dept);
		PageInfo<Dept> pi=adminServiceImpl.deptLists(dept,pc);
		model.addAttribute("pi", pi);
		return "admin/dept/index";
	}
	@RequestMapping(value="/dept/update",method=RequestMethod.GET)
	public String dept_update(Integer deptid,Model model){
		Dept dept=adminServiceImpl.findDeptById(deptid);
		boolean flag=model.containsAttribute("dept");
		if(flag){
			
		}
		model.addAttribute("dept",dept);
		return "admin/dept/update";
	}
	@RequestMapping(value="/classes/update",method=RequestMethod.GET)
	public String classes_update(Integer claid,Model model){
		Classes classes=adminServiceImpl.findClassesById(claid);
		List<Dept> deptLists=deptServiceImpl.deptLists();
		model.addAttribute("deptLists",deptLists);
		model.addAttribute("classes",classes);
		return "admin/classes/update";
	}
	@RequestMapping(value="/dept/doUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dept_doupdate(Integer deptid,String claids){
		Map<String,Object> map=new HashMap<String,Object>();
		String ids[]={};
		if(claids.length()>0){
			ids=claids.split(",");
		}
		List<Integer> claid=null;
		if(ids.length>0){
			claid=new ArrayList<Integer>();
			for (int i = 0; i < ids.length; i++) {
				claid.add(Integer.parseInt(ids[i]));
			}
		}
		boolean flag=adminServiceImpl.doUpdate(claid,deptid);
		if(flag){
			map.put("message","添加成功！");
		}else{
			map.put("message","添加失败！");
		}
		return map;
	}
	@RequestMapping(value="/dept/doAdd",method=RequestMethod.GET)
	public String dept_add(String deptname,Model model,HttpSession session){
		System.out.println(deptname+"<-----------");
		Dept dept=new Dept();
		dept.setDeptname(deptname);
		boolean flag = deptServiceImpl.insertDept(dept);
		if(flag){
			session.setAttribute("dept",dept);
			return "forward:update";
		}else{
			model.addAttribute("error","出现错误,重新创建");
			return "admin/dept/index";
		}
	}
	@RequestMapping(value="/dept/doDelete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dept_delete(Integer deptid){
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag=deptServiceImpl.delete(deptid);
		if(flag){
			map.put("message","删除成功！");
		}else{
			map.put("message","删除失败!");
		}
		return map;
	}
	@RequestMapping(value="/classes/doDelete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> classes_delete(Integer claid){
		Map<String,Object> map=new HashMap<String,Object>();
		boolean flag=classesServiceImpl.delete(claid);
		if(flag){
			map.put("message","删除成功!");
		}else{
			map.put("message","删除失败!");
		}
		return map;
	}
	
	@RequestMapping(value="/classes/classeslist",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> question_Lists(Classes classes,Integer currindex,Model model){
		Map<String,Object> map=new HashMap<String,Object>();
		PageControl pc=new PageControl();
		int curr=1;
		if(currindex!=null){
			curr=currindex;
		}
		pc.setCurrentindex(curr);
		//pc.setPagesize(1);
		PageInfo<Classes> pi=adminServiceImpl.classesLists(classes,pc);
		map.put("message","添加成功！");
		map.put("pi",pi);
		return map;
	}
    
}

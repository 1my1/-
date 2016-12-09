package cn.edu.nuc.spring.inteceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.edu.nuc.spring.entity.Admin;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"login.jsp", "/checklogin", "/login", "/admin/login.jsp", "/admin/login","backui/","frontui/"};
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        System.out.println(">>>: " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                return true;
            }
        }
        if (flag==false) {
        	System.out.println(flag);
        	HttpSession session = request.getSession(true);
        	Admin a=(Admin)session.getAttribute("admin");
        	System.out.println(a);
           if(a!=null){
        	   if(session.getId().equals(a.getAdsessionid())){
        		   
        		   flag = true;
        	   }else{
        		   System.out.println("异地登陆-------------------------------------");
        		   //request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request, response);
        		   response.sendRedirect("http://localhost:8080/springmvc/admin/login");
        	   }
           }else{
        		   System.out.println("异地登陆-------------------------------------");
        		   //request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request, response);
        		   response.sendRedirect("http://localhost:8080/springmvc/admin/login");
           }
        }
        System.out.println("flag======"+flag);
        return flag;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
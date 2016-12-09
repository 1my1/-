package cn.edu.nuc.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BaseController {
       public Logger Log = LoggerFactory.getLogger(this.getClass());
       
       @InitBinder("role")    
       public void initBinder2(WebDataBinder binder) {    
               binder.setFieldDefaultPrefix("role.");    
       }
}

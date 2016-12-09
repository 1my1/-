package cn.edu.nuc.spring.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.nuc.spring.dao.TitleMapper;
import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.service.interfaces.ITitleService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
@Service
public class TitleServiceImpl extends BaseServiceImpl implements ITitleService {
	@Autowired
	private TitleMapper titleMapper;
	public PageInfo<Title> titleLists(Title title,PageControl pc){
		PageInfo<Title> pi=new PageInfo<Title>();
		
		List<Title> titleLists=titleMapper.titleLists(title,pc);
	    titleLists=dealTitlename(titleLists);
		Integer count=rsCount(title);
        Integer c=0;
		if(count!=null){
			c=count;
		}
		pi.setLists(titleLists);
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}
	private Integer rsCount(Title title) {
		Integer count=titleMapper.rsCount(title);
		{
			return count;
		}
	}
	private List<Title> dealTitlename(List<Title> lists){
		List<Title> titleLists=new ArrayList<Title>();
		for(Title title:lists){
			if(title.getTitname().length()>10){
				String titname=title.getTitname().substring(0, 10);
				titname+="....";
				title.setTitname(titname);
			}
			titleLists.add(title);
		}
		return titleLists;
	}
	@Override
	public boolean delete(Integer titid) {
		int count=titleMapper.deleteByPrimaryKey(titid);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public List<TestQuestion> tqLists() {

		List<TestQuestion> tqLists=titleMapper.tqLists();
		
		return tqLists;
	}
	@Override
	public List<Course> courseLists() {

		List<Course> courseLists=titleMapper.courseLists();
		return courseLists;
	}
	@Override
	public boolean addTitle(Title title) {

		int count = titleMapper.addTitle(title);
		
		if(count>0){
			return true;
		}
		
		return false;
	}
	@Override
	public Title findTitleById(Integer titid) {

		Title title=titleMapper.selectByPrimaryKey(titid);
		
		return title;
	}
	@Override
	public boolean update(Title title) {

		int count=titleMapper.updateByPrimaryKey(title);
		if(count>0){
			return true;
		}
		return false;
	}
	

}

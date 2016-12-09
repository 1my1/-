package cn.edu.nuc.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.ClassesMapper;
import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.service.interfaces.IClassesService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
@Service
public class ClassesServiceImpl extends BaseServiceImpl implements IClassesService {

	@Autowired
	private ClassesMapper classesMapper;
	
	@Override
	public PageInfo<Classes> classesLists(Classes classes, PageControl pc) {
		PageInfo<Classes> pi=new PageInfo<Classes>();
		Integer count=rsCount(classes);
		List<Classes> adLists=classesMapper.classesLists(classes,pc);
        Integer c=0;
		if(count!=null){
			c=count;
		}
		pi.setLists(adLists);
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}

	private Integer rsCount(Classes classes) {
		// TODO Auto-generated method stub
		Integer count=classesMapper.rsCount(classes);
		return count;
	}

	@Override
	public boolean delete(Integer claid) {
		Integer count=classesMapper.deleteByPrimaryKey(claid);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Classes> claList() {

		List<Classes> classesLists=classesMapper.claList();
		
		return classesLists;
	}

}

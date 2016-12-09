package cn.edu.nuc.spring.service.interfaces;

import java.util.List;

import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

public interface IClassesService {

	PageInfo<Classes> classesLists(Classes classes, PageControl pc);

	boolean delete(Integer deptid);

	List<Classes> claList();

}

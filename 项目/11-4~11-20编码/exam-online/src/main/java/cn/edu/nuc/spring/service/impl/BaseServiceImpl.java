package cn.edu.nuc.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.nuc.spring.util.PageControl;

public class BaseServiceImpl {
	
	public Logger Log=LoggerFactory.getLogger(this.getClass());
	/**
	 * 处理分页参数
	 * @param pc
	 * @return
	 */
	protected static PageControl dealpage(PageControl pc){
		//获取总页数
		Integer pagecount = pc.getRscount()/pc.getPagesize();
		if(pc.getRscount()%pc.getPagesize()>0){
			pagecount++;
		}
		pc.setPagecount(pagecount);
		
		//计算最大(最小)显示页数
		Integer showpcount = pc.getShowpcount();//分页一次显示多少页
		Integer maxpage = 0;//当前显示最大页码
		Integer minpage = 0;
		Integer index = pc.getCurrentindex();//当前第几页
		if(pagecount<=showpcount){//当总页数小于等于显示的页数时
			maxpage = pagecount;
			minpage = 1;
		}else{
			Integer buff = showpcount/2; //取中间数。maxpage=index+buff
			buff = index+buff;
			if(buff<=showpcount){
				maxpage = showpcount;
				minpage = 1;
			}else if(buff<pagecount){
				maxpage = buff;
				minpage = maxpage - showpcount + 1;
				
			}else if(buff>=pagecount){
				maxpage = pagecount;
				minpage = maxpage - showpcount + 1;
			}
		}
		pc.setMaxpage(maxpage);	
		pc.setMinpage(minpage);
		return pc;
	}

}

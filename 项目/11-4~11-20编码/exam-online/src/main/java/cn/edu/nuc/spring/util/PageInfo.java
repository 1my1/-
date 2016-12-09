package cn.edu.nuc.spring.util;

import java.util.List;

public class PageInfo<T> {
	
	private PageControl pc;
	private List<T> lists;
	public PageControl getPc() {
		return pc;
	}
	public void setPc(PageControl pc) {
		this.pc = pc;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	

}

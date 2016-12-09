package cn.edu.nuc.spring.util;

public class PageControl {
	/**
	 * 每一页的开始
	 */
	private Integer pagestart;
	/**
	 * 每一页的结束
	 */
	private Integer pageend;
	/**
	 * 当前第几页
	 */
	private Integer currentindex;
	/**
	 * 每页多少行数据(默认每页10行数据)
	 */
	private final Integer pagesize = 7;
	/**
	 * 总记录数
	 */
	private Integer rscount;
	
	/**
	 * 总页数
	 */
	private Integer pagecount;
	/**
	 * 分页控件一次显示多少页(默认一次5页)
	 */
	private Integer showpcount = 5;
	/**
	 * 当前分页控件显示的最大页数
	 */
	private Integer maxpage;
	
	/**
	 * 当前分页控件显示的最小页数
	 */
	private Integer minpage;
	
	
	public Integer getPagestart() {
		return pagestart;
	}
	public Integer getPageend() {
		return pageend;
	}
	public void setPageend(Integer pageend) {
		this.pageend = pageend;
	}
	public Integer getCurrentindex() {
		return currentindex;
	}
	public synchronized void setCurrentindex(Integer currentindex) {
		this.currentindex = currentindex;
		this.pagestart=(currentindex-1)*pagesize;
		this.pageend=pagesize;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public Integer getRscount() {
		return rscount;
	}
	public void setRscount(Integer rscount) {
		this.rscount = rscount;
	}
	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
	public Integer getShowpcount() {
		return showpcount;
	}
	public void setShowpcount(Integer showpcount) {
		this.showpcount = showpcount;
	}
	public Integer getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(Integer maxpage) {
		this.maxpage = maxpage;
	}
	public Integer getMinpage() {
		return minpage;
	}
	public void setMinpage(Integer minpage) {
		this.minpage = minpage;
	}

}

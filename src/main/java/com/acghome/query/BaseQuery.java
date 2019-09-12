package com.acghome.query;

public class BaseQuery {

	private int page = 1;//第几页  兼容easyui的分页
	private int rows = 10;//当前页显示的条目数量
	private  int start;
	
	private String q;//关键字查询，为了兼容easyui的combogrid,keyword关键字
	
	private Integer state;//状态字段
	
	public BaseQuery(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public BaseQuery() {
		super();
	}
	
	
	public int getStart(){
		return (page-1)*rows;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}

package com.acghome.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
	PO ：即domain模型，即持久化对象，定义属性类型都是对象类型。 包装类型
	VO ：即Value Object，值对象。
		通常是用来临时封装信息的，但是不需要和数据库同步。如BaseQuery、PageList不用使用对象类型，
		使用普通类型.
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class PageList<T> {
	
	//兼容easyui的分页
	private int total;//总条目
	private List<T> rows = new ArrayList<>();//当前页的数据 
	
	public Integer getTotal() {
		return total; 
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public List<T> getRows() {
		return rows;
	}
	
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}

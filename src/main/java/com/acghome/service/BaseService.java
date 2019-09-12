package com.acghome.service;

import com.acghome.query.BaseQuery;
import com.acghome.utils.PageList;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	/**
	 * 添加
	 * @param t
	 */
	void add(T t);
	/**
	 * 删除
	 * @param id
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 * @param t
	 */
	void update(T t);
	/**
	 * 根据主键查询一条数据
	 * @param id
	 * @return
	 */
	T getOne(Serializable id);
	/**
	 * 查询所有数据
	 * @return
	 */
	List<T> getAll();
	
	/**
	 * 条件查询
	 * @param query
	 * @return
	 */
	PageList<T> getPageByQuery(BaseQuery query);
	
	

}

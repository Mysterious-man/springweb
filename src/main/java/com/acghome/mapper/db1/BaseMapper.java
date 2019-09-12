package com.acghome.mapper.db1;

import com.acghome.query.BaseQuery;

import java.io.Serializable;
import java.util.List;


public interface BaseMapper<T> {

	/**
	 * 添加
	 * @param t
	 */
	void save(T t);
	/**
	 * 删除
	 * @param id
	 */
	void remove(Serializable id);
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
	T loadById(Serializable id);
	/**
	 * 查询所有数据
	 * @return
	 */
	List<T> loadAll();

	/**
	 * 条件查总条目数
	 * @param query
	 * @return
	 */
	int loadCountByQuery(BaseQuery query);

	/**
	 * 条件查数据
	 * @param query
	 * @return
	 */
	List<T> loadDataByQuery(BaseQuery query);

}

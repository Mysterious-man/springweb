package com.acghome.service.impl;

import com.acghome.mapper.db1.BaseMapper;
import com.acghome.query.BaseQuery;
import com.acghome.service.BaseService;
import com.acghome.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;
	
	@Override
	@Transactional
	public void add(T t) {
		baseMapper.save(t);
	}

	@Override
	@Transactional
	public void delete(Serializable id) {
		baseMapper.remove(id);
	}

	@Override
	@Transactional
	public void update(T t) {
		baseMapper.update(t);
	}

	@Override
	public T getOne(Serializable id) {
		return baseMapper.loadById(id);
	}

	@Override
	public List<T> getAll() {
		return baseMapper.loadAll();
	}

	@Override
	public PageList<T> getPageByQuery(BaseQuery query) {
		//总条目数
		int total = baseMapper.loadCountByQuery(query);
		//当前页的数据
		List<T> rows = baseMapper.loadDataByQuery(query);
		//封装PageList
		PageList<T> page = new PageList<>();
		page.setTotal(total);
		page.setRows(rows);
		return page;
	}

}
